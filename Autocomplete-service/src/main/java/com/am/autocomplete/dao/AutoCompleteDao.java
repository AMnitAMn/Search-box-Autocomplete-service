package com.am.autocomplete.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AutoCompleteDao {
	private static Trie trie;

	static {
		makeTrie();
	}

	// Read the words and their frequency from the csv file and insert the words into Trie.
	private static void makeTrie(){
		trie = new Trie();
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("unigram_freq.csv");
			Scanner scanner = new Scanner(fileInputStream);
			scanner.useDelimiter(",");
			
			while(scanner.hasNextLine()) {
				String[] read = scanner.nextLine().split(",");
				trie.insert(read[0], Long.parseLong(read[1]));
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getSuggestions(String prefix) {
		return trie.findSuggestions(prefix);
	}
	
}
