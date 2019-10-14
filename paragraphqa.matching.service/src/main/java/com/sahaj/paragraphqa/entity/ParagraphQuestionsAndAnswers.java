package com.sahaj.paragraphqa.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class ParagraphQuestionsAndAnswers{
	
	private String [] paragraph;
	
	private String [] questions;
	
	private String [] answers;
	
	public ParagraphQuestionsAndAnswers() {
	}
	
	public ParagraphQuestionsAndAnswers(String [] paragraph, String[] questions, String[] answers) {
		this.paragraph = paragraph;
		this.questions = questions;
		this.answers = answers;
	}

	public String[] getParaLines() {
		return this.paragraph;
	}

	public void setPara(String[] para) {
		this.paragraph = para;
	}

	public String[] getQuestions() {
		return this.questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public String[] getAnswers() {
		return this.answers;
	}

	public void setAnswers(String [] answers) {
		this.answers = answers;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("paragraph", paragraph)
				.append("questions", questions).append("answers", answers).toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {

		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParagraphQuestionsAndAnswers))
			return false;

		ParagraphQuestionsAndAnswers castOther = (ParagraphQuestionsAndAnswers) other;

		return new EqualsBuilder().append(paragraph, castOther.paragraph)
				.append(questions, castOther.questions).append(answers, castOther.answers)
				.isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {

		return new HashCodeBuilder().append(paragraph).append(questions).append(answers).toHashCode();
	}


}
