package com.am.autocomplete.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
	public TrieNode rootNode;

	// Constructor
	public Trie() {
		rootNode = new TrieNode();
	}


	// Insert each word into the trie and insert the word into the queue.
	public void insert(String word, long frequency) {
		TrieNode currentNode = rootNode;

		int n = word.length();

		for(int i=0; i<n; i++){

			// if the current does not have current letter as a child, create new node for the letter.
			if(currentNode.children[word.charAt(i)-'a'] == null) {
				currentNode.children[word.charAt(i)-'a'] = new TrieNode();
			}
			currentNode = currentNode.children[word.charAt(i)-'a'];

			// add the word two the priority queue of the prefix.
			currentNode.suggestions.add(new Entry(word, frequency));

			// only 10 most frequently used suggestions are needed.
			if(currentNode.suggestions.size() > 10){
				currentNode.suggestions.poll();
			}
		}
	}

	// return the most frequent words as suggestion
	public List<String> findSuggestions(String prefix){

		prefix = prefix.toLowerCase();
		TrieNode currentNode = rootNode;
		int n = prefix.length();

		// Traverse the Trie to find the prefix.
		for(int i=0; i<n; i++) {
			if(currentNode.children[prefix.charAt(i)-'a']==null) return null;
			else currentNode = currentNode.children[prefix.charAt(i)-'a'];
		}

		// add all the entiers of priority queue to a list.
		List<String> result = new ArrayList<>();
		for(Entry e : currentNode.suggestions){
			result.add(e.getWord());
		}
		Collections.sort(result);

		return result;
	}
}
