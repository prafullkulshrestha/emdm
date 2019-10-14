package com.sahaj.paragraphqa.entity;

import java.util.HashMap;
import java.util.Map;

public class RawDocument {
	private final String name;
	private final String original;
	private Map<String, Integer> words = new HashMap<>();

	public RawDocument(String sentence, String name) {
		this.name = name;
		this.original = sentence;

		// parse the sentence into words
		// -break by white space (\s), and ignore punctuation (\p{Punct})?
		// -break by white space (\s) and punctuation (\p{Punct}), and ignore empty
		// strings.
		for (String word : sentence.split("\\s|\\p{Punct}")) {
			addWord(word);
		}
	}

	/**
	 * Add word and its frequesncy. Ignores empty words.
	 */
	private void addWord(String word) {
		if (word.isEmpty())
			return;
		word = word.toLowerCase();
		int count = getRawCount(word) + 1;
		words.put(word, count);
	}

	final public boolean contains(String word) {
		return words.containsKey(word.toLowerCase());
	}

	final public int getRawCount(String word) {
		return words.getOrDefault(word.toLowerCase(), 0);
	}

	public Map<String, Integer> getWords() {
		return words;
	}

	public void setWords(Map<String, Integer> words) {
		this.words = words;
	}

	public String getName() {
		return name;
	}

	public String getOriginal() {
		return original;
	}
	
	
}
