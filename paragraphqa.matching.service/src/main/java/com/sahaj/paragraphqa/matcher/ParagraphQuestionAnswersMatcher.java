package com.sahaj.paragraphqa.matcher;

import java.util.List;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;

/**
 * @author prafullkulshrestha
 *
 */
public interface ParagraphQuestionAnswersMatcher {
	public List<String> matchParagraphQuestionsAndAnswers(ParagraphQuestionsAndAnswers  paraQnA);
}
