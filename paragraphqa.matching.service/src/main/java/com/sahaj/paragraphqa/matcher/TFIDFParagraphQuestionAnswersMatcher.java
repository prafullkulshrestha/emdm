/**
 * 
 */
package com.sahaj.paragraphqa.matcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;
import com.sahaj.paragraphqa.entity.RawDocument;

/**
 * @author prafullkulshrestha
 *
 */
@Component
public class TFIDFParagraphQuestionAnswersMatcher implements ParagraphQuestionAnswersMatcher {
	
	private static Logger log = LoggerFactory.getLogger(TFIDFParagraphQuestionAnswersMatcher.class);

	/* (non-Javadoc)
	 * @see com.sahaj.paragraphqa.matcher.ParagraphQuestionAnswersMatcher#matchParagraphQuestionsAndAnswers()
	 */
	@Override
	public List<String> matchParagraphQuestionsAndAnswers(ParagraphQuestionsAndAnswers  paraQnA) {

		log.debug("Request received for matching paragraph questions and answers");
		// Get the paragraph, questions and answers in the respective string arrays
		String[] rawSentences = paraQnA.getParaLines();
		String[] rawAnswers = paraQnA.getAnswers();
		String[] rawQuestions = paraQnA.getQuestions();
		List<String> matchedAnswers = new ArrayList<>();
		// Focus only on those sentences those contain the answers
		List<String> rawSentenceCanditates = new ArrayList<>(rawSentences.length);
		for (String rawSentence : rawSentences) {
			for (String rawAnswer : rawAnswers) {
				if (rawSentence.contains(rawAnswer)) {
					rawSentenceCanditates.add(rawSentence);
					break;
				}
			}
		}
		rawSentences = rawSentenceCanditates.toArray(new String[rawSentenceCanditates.size()]);
		
		//Create documents from all the filtered sentences
		RawDocument[] sentences = new RawDocument[rawSentences.length];
		for (int i = 0; i < rawSentences.length; i++)
			sentences[i] = new RawDocument(rawSentences[i], "S" + i);
		
		//Create documents from all the questions to be matched with answers
		RawDocument[] questions = new RawDocument[rawQuestions.length];
		for (int i = 0; i < rawQuestions.length; i++)
			questions[i] = new RawDocument(rawQuestions[i], "Q" + i);
		
		//Create documents from all the answers to be matched with questions
		RawDocument[] answers = new RawDocument[rawAnswers.length];
		for (int i = 0; i < rawAnswers.length; i++)
			answers[i] = new RawDocument(rawAnswers[i], "A" + i);

		//For each question calculate and store a question score for all the sentences
		double[][] questionSentenceScores = new double[questions.length][];
		// cache the idfs for various words.
		Map<String, Double> idfCache = new HashMap<>();
		for (int q = 0; q < questions.length; q++) {
			questionSentenceScores[q] = getQueryScoreForAllDocuments(questions[q], sentences, false, idfCache);
		}
		
		//For each answer calculate and store an answer score for all the sentences
		double[][] answerSentenceScores = new double[questions.length][];
		Map<String, Double> idfCache2 = new HashMap<>();
		for (int a = 0; a < answers.length; a++) {
			answerSentenceScores[a] = getQueryScoreForAllDocuments(answers[a], sentences, true, idfCache2);
		}
		
		//Calculate question and answer scores
		double[][] qaScores = new double[questions.length][answers.length];
		// score (q,a) = max_{s} preference(q,s) preference(a,s)
		for (int q = 0; q < questions.length; q++) {
			for (int a = 0; a < answers.length; a++) {
				double scoreQA = Double.NEGATIVE_INFINITY;
				for (int s = 0; s < sentences.length; s++) {
					final double scoreQSA = questionSentenceScores[q][s] * answerSentenceScores[a][s];
					if (scoreQSA > scoreQA) {
						scoreQA = scoreQSA;
					}
					qaScores[q][a] = scoreQA;
				}
			}
			normalize(qaScores[q]);

		}

		boolean[] alreadyAssignedAnswer = new boolean[answers.length];// all false at first.
		Integer[] unassignedQuestions = new Integer[questions.length];
		for (int i = 0; i < questions.length; i++)
			unassignedQuestions[i] = i;
		int unassignedQuestionCount = questions.length;
		int[] bestAnswerForQuestion = new int[questions.length];

		while (unassignedQuestionCount > 0) {
			int bestQi = -1;
			int aForBestQi = -1;
			double bestQScore = Double.NEGATIVE_INFINITY;

			//Calculate the best/max score for a question and its answer
			//Also calculate the question and its answer index for the best score
			for (int qi = 0; qi < unassignedQuestionCount; qi++) {
				final int q = unassignedQuestions[qi];

				for (int a = 0; a < answers.length; a++) {
					if (alreadyAssignedAnswer[a])
						continue;
					double scoreQA = qaScores[q][a];
					if (scoreQA > bestQScore) {
						bestQi = qi;
						bestQScore = scoreQA;
						aForBestQi = a;
					}
				}
			}
			// Calculate the best answer index for the question and store in the bestAnswerForQuestion array
			final int q = unassignedQuestions[bestQi];
			bestAnswerForQuestion[q] = aForBestQi;

			// mark question q as assigned
			unassignedQuestionCount--;
			unassignedQuestions[bestQi] = unassignedQuestions[unassignedQuestionCount];
			unassignedQuestions[unassignedQuestionCount] = -1;

			// mark answer aForBestQi as assigned
			alreadyAssignedAnswer[aForBestQi] = true;
		}
		// Look for best answer index value in bestAnswerForQuestion array and get the answer value from the 
		// rawAnswers array by getting the answer value at that index
		for (int a : bestAnswerForQuestion) {
			matchedAnswers.add(rawAnswers[a]);
		}
		return matchedAnswers;
	
	}
	
	private void normalize(double[] scores) {
		double sum = 0;
		for (int a = 0; a < scores.length; a++) {
			sum += scores[a];
		}
		if (sum == 0.0)
			return;
		for (int a = 0; a < scores.length; a++) {
			scores[a] /= sum;
		}
	}

	/** The method calculates the query match scores for each documents
	 *  stores it in an array and returns 
	 * @param query
	 * @param documents
	 * @param queryMustShowUpAsIs
	 * @param idfCache
	 * @return
	 */
	private double[] getQueryScoreForAllDocuments(RawDocument query, RawDocument[] documents, boolean queryMustShowUpAsIs, Map<String, Double> idfCache) {
	
		double[] scores = new double[documents.length];
		for (int d = 0; d < documents.length; d++) {
			final RawDocument doc = documents[d];

			log.debug(doc.getName() + "\t");
			double score = 0;

			if (!queryMustShowUpAsIs || doc.getOriginal().contains(query.getOriginal())) {
				// Get the final query score for the current document by accumulating each words score 
				// in the query for the current document
				for (String word : query.getWords().keySet()) {
					double tf = (double) doc.getRawCount(word); // term frequency
					double idf = idfCache.computeIfAbsent(word, key -> idf(key, documents));// inverse document frequency
					double wordScore = tf * idf;

					if (wordScore != 0)
						log.debug(word + "->" + wordScore + " ");
					score += wordScore;
				}
				
			}
			scores[d] = score;
		}
			for (int d = 0; d < documents.length; d++) {
				log.debug(">" + documents[d].getName() + "\t" + scores[d]);
			}
		return scores;
	}

	private int countHits(String term, RawDocument[] docs) {
		if (docs.length == 0)
			return 0;

		int count = 0;
		for (RawDocument d : docs)
			if (d.getWords().containsKey(term))
				count++;
		return count;
	}

	private double idf(String term, RawDocument[] docs) {
		int count = countHits(term, docs);
		if (count == 0)
			return 0;// ??
		return Math.log(1 + docs.length / ((double) count));
	}


}
