package com.sahaj.paragraphqa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;
import com.sahaj.paragraphqa.service.ParagraphQAMatchingServiceImpl;
import com.sahaj.paragraphqa.service.ParagraphQAMatchingService;

@SpringBootApplication
public class ParagraphQAMatchingApplication {

	private static Logger log = LoggerFactory.getLogger(ParagraphQAMatchingApplication.class);

	public static void main(String[] args) {
		ParagraphQAMatchingService paragraphMatchingService = SpringApplication.run(ParagraphQAMatchingApplication.class, args)
				.getBean(ParagraphQAMatchingServiceImpl.class);
		List<String> matchedAnswers = paragraphMatchingService.matchParagraphQuestionsAndAnswers();
		ParagraphQuestionsAndAnswers paragraphQuestionsAndAnswers = paragraphMatchingService.getParagraphQuestionsAndAnswers();
		log.debug("\nParagraph is:\n {}\n Questions are: \n {}\n Answers are:\n {}\n",
				String.join(". ", paragraphQuestionsAndAnswers.getParaLines()),
				String.join(",", paragraphQuestionsAndAnswers.getQuestions()),
				String.join(";", paragraphQuestionsAndAnswers.getAnswers()));
		log.info("The matched answers are:\n {} ", String.join(",\n", matchedAnswers));
	}

}
