package teradata;
// This is a node in the Trie which implements the dictionary

import java.util.HashMap;

public class TrieNode {

	// Variable to hold word meaning.
	// null means the word is not terminated on this trie node.
	// I have overloaded the meaning variable to store the meaning (if non null) as well as 
	// a flag whose non null value represents the end of word from the beginning of trie. 
	private String meaning;
	
	// Store mappings of children nodes (represents set of possible next characters
	// Assumption: ascii and non-ascii characters both belong to unicode character set. 
	// (NOTE: I am using Character as key here with an assumption(fact) that all the above mentioned characters can also be represented by Character
	private HashMap<Character, TrieNode> children;
	
	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public TrieNode() {
		children = new HashMap<>();
		meaning = null;
	}
}
