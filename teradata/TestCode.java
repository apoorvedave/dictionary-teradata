package teradata;

import java.util.Arrays;

public class TestCode {

	public static void main(String[] args) {
		Dictionary dict = new Trie();
		dict.insert("hello", "greeting");
		System.out.println(dict.getDefinition("hello"));
		dict.insert("hellboy", "movie character");
		System.out.println(dict.getDefinition("hellboy"));
		String[] helWords = dict.getWordsWithPrefix("hel");
		System.out.println(Arrays.toString(helWords));
		dict.delete("hel");
		dict.delete("hello");
		System.out.println(dict.getDefinition("hello"));
		helWords = dict.getWordsWithPrefix("hel");
		System.out.println(Arrays.toString(helWords));
		System.out.println(dict.getDefinition("hellboy"));
	}
	
	/*
output:
greeting
movie character
[hellboy, hello]
null
[hellboy]
movie character
*/
}
