/**
 * 
 */
package com.sahaj.paragraphqa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;
import com.sahaj.paragraphqa.matcher.ParagraphQuestionAnswersMatcher;
import com.sahaj.paragraphqa.reader.ParagraphQuestionAnswerReader;

/**
 * @author prafullkulshrestha
 *
 *         The implementation class for matching questions to there answers in a paragraph.
 *         
 */
@Service
public class ParagraphQAMatchingServiceImpl implements ParagraphQAMatchingService {

	private ParagraphQuestionAnswerReader paragraphQuestionAnswerReader;

	private ParagraphQuestionAnswersMatcher paragraphQuestionAnswersMatcher;

	private static Logger log = LoggerFactory.getLogger(ParagraphQAMatchingServiceImpl.class);

	@Autowired
	public ParagraphQAMatchingServiceImpl(ParagraphQuestionAnswerReader paragraphQuestionAnswerReader,
			ParagraphQuestionAnswersMatcher paragraphQuestionAnswersMatcher) {
		super();
		this.paragraphQuestionAnswerReader = paragraphQuestionAnswerReader;
		this.paragraphQuestionAnswersMatcher = paragraphQuestionAnswersMatcher;
	}

	
	/* (non-Javadoc)
	 * @see com.sahaj.paragraphqa.service.ParagraphQAMatchingService#getParagraphQuestionsAndAnswers()
	 */
	@Override
	public ParagraphQuestionsAndAnswers getParagraphQuestionsAndAnswers() {
		return paragraphQuestionAnswerReader.getParagraphQuestionsAndAnswers();
	}
	
	/* (non-Javadoc)
	 * @see com.sahaj.paragraphqa.service.ParagraphQAMatchingService#matchParagraphQuestionsAndAnswers()
	 */
	@Override
	public List<String> matchParagraphQuestionsAndAnswers() {
		log.debug("Request received for matching paragraph questions and answers");
		ParagraphQuestionsAndAnswers paragraphQuestionAnswer = getParagraphQuestionsAndAnswers();
		return paragraphQuestionAnswersMatcher.matchParagraphQuestionsAndAnswers(paragraphQuestionAnswer);
	}
	
	

}
