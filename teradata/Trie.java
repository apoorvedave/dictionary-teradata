package teradata;

import java.util.Map.Entry;

// This class represents an implementation of the dictionary
// Word keys are stored in trie
// TrieNodes with 'meaning' not null represents end of word and associated definition.

/* Suggested Improvements:
 * 1. 
	Along with tries, words vs definitions can simultaneously be put in a hash table.
	This will increase efficiency at the cost of extra space.
	Insert, getMeaning will be faster.
	Retrieving prefix based words and deleting will still depend on the depth of trie.
   2.
   	Deletion is fast but does not clean up dead unused nodes which do not have extended words.
*/
public class Trie implements Dictionary {

	// represents the root of dictionary
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word, String meaning) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.getChildren().get(c) == null) {
				cur.getChildren().put(c, new TrieNode());
			}
			cur = cur.getChildren().get(c);
		}
		cur.setMeaning(meaning);
	}

	public String[] getWordsWithPrefix(String prefix) {
		StringList sl = new StringList();
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.getChildren().get(c) == null) {
				// implies no words exist with this prefix
				// return an empty list
				return sl.getStrings();
			}
			cur = cur.getChildren().get(c);
		}
		// add all words from cur node onwards to the list sl
		getAllWords(cur, prefix, sl);
		return sl.getStrings();
	}

	public String getDefinition(String word) {

		// Assumption: If a word definition does not exist, return null.
		// OR, a null returned value means the word itself does not exits.

		if (word == null || word.length() == 0) {
			return null;
		}

		// Search the word in trie. If the word is complete, its 'meaning' will
		// be non-null. Return Meaning. Else null;
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.getChildren().get(c) == null) {
				return null;
				// Can also throw error message saying "No such word exists".
				// I have not used it since the message being a string, can be
				// confused
				// with a definition to the uninitiated or to bots.
			}
			cur = cur.getChildren().get(c);
		}
		// if cur.meaning is null, we return null else 'meaning'
		return cur.getMeaning();
	}

	private void getAllWords(TrieNode cur, String prefix, StringList sl) {
		// Recursive helper method to collect all complete words with given
		// prefix starting at current trie node
		if (cur == null) {
			return;
		}
		if (cur.getMeaning() != null) {
			// implies the "prefix" is also a complete word
			sl.insert(prefix);
		}
		for (Entry<Character, TrieNode> child : cur.getChildren().entrySet()) {
			// recursively add all complete words starting with
			// <prefix>+'current char'
			getAllWords(child.getValue(), prefix + child.getKey(), sl);
		}
		return;
	}

	public void delete(String word) {

		// I am initially going for a simple implementation where I just set the
		// 'meaning' variable of the last trieNode(represents last character) of
		// word to null
		// This will clear the definition if already present.
		// Advantages: Simple to implement
		// Disadvantages: This will lead to some dead nodes which could have
		// been cleaned up.
		// Will work on the cleanup code if time permits.

		if (word == null) {
			return;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.getChildren().get(c) == null) {
				// The word was not found in the dictionary;
				return;
			}
			cur = cur.getChildren().get(c);
		}
		cur.setMeaning(null);
	}
}
