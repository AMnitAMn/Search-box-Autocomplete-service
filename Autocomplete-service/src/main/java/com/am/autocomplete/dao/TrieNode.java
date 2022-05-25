package com.am.autocomplete.dao;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TrieNode {

	//Each TrieNode contain an array of TrieNode representing the next letter in string.
	public TrieNode[] children;

	// Priority queue to contain 10 most frequent words with the current prefix.
	public PriorityQueue<Entry> suggestions;
	
	public TrieNode() {

		//considering that the string contains only lower-case alphabet.
		children = new TrieNode[26];

		suggestions = new PriorityQueue<>(11);
	}
}
