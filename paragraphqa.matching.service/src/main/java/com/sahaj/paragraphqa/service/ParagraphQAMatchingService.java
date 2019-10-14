/**
 * 
 */
package com.sahaj.paragraphqa.service;

import java.util.List;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;

/**
 * The service interface for paragraph questions and answers matching.
 * @author prafullkulshrestha
 *
 */
public interface ParagraphQAMatchingService {
	
	/** The method returns the paragraph contents questions and
	 *  the answers to be matched.
	 * @return	paragraph questions and answers object
	 */
	ParagraphQuestionsAndAnswers getParagraphQuestionsAndAnswers();
	
	/** The method returns the list of matched answers in an 
	 * order of the questions 
	 * @return ordered list of matched answers
	 */
	List<String> matchParagraphQuestionsAndAnswers();

}
