package com.sahaj.paragraphqa;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sahaj.paragraphqa.entity.ParagraphQuestionsAndAnswers;
import com.sahaj.paragraphqa.service.ParagraphQAMatchingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParagraphQAMatchingServiceImplTests {

	@Autowired
	ParagraphQAMatchingService fileParagraphMatchingService;
	private static Logger log = LoggerFactory.getLogger(ParagraphQAMatchingServiceImplTests.class);

	@Before
	public void setup() {

	}

	@Test
	public void getParagraphQuestionsAndAnswers() {
		ParagraphQuestionsAndAnswers paragraphQuestionsAndAnswers = fileParagraphMatchingService
				.getParagraphQuestionsAndAnswers();
		assertThat("The paragraph questions and answers are null", paragraphQuestionsAndAnswers, notNullValue());
		log.debug("\nParagraph is:\n {}\n Questions are: \n {}\n Answers are:\n {}\n",
				String.join(". ", paragraphQuestionsAndAnswers.getParaLines()),
				String.join(",", paragraphQuestionsAndAnswers.getQuestions()),
				String.join(";", paragraphQuestionsAndAnswers.getAnswers()));
	}

	@Test
	public void matchContents() {
		List<String> matchedAnswers = fileParagraphMatchingService.matchParagraphQuestionsAndAnswers();
		assertThat("The matchedAnswers records are null", matchedAnswers, notNullValue());
		log.info("The matched answers are:\n {} ", String.join(",\n", matchedAnswers));
	}

}
