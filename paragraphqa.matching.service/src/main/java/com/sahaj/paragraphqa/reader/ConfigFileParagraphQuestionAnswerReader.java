package com.sahaj.paragraphqa.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;

@Component
public class ConfigFileParagraphQuestionAnswerReader implements ParagraphQuestionAnswerReader {
	
	@Value("${questions}")
	private String questions;

	@Value("${paragraph}")
	private String paragraph;

	@Value("${answers}")
	private String answers;

	private static Logger log = LoggerFactory.getLogger(ConfigFileParagraphQuestionAnswerReader.class);

	@Override
	public ParagraphQuestionsAndAnswers getParagraphQuestionsAndAnswers() {
		log.debug("Request received for getting paragraph, questions and answers");
		ParagraphQuestionsAndAnswers paraQnA = new ParagraphQuestionsAndAnswers(
				paragraph.split("(\\.(\\[\\p{Digit}+\\])?(\\s|$))|(,\\sbut\\s)|(;\\s)"), questions.split(","),
				answers.split(";"));
		return paraQnA;
	}

}
