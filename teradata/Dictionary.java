package teradata;

public interface Dictionary {
	
	/**
	 * Method to insert word with meaning. If a word exists already, its meaning will be overwritten.
	 * @param word
	 * @param meaning
	 */
	public void insert(String word, String meaning);

	/**
	 * Returns a list of all words starting with the given prefix. If no words exist, an empty String array is returned
	 * @param prefix
	 * @return Array of strings always
	 */
	public String[] getWordsWithPrefix(String prefix);

	/**
	 * Returns the string definition of word. Assumption: Each word has only one meaning
	 * @param word
	 * @return Word meaning or nulll
	 */
	public String getDefinition(String word);

	/**
	 * Deletes the word if present. Subsequent calls of getDefinition etc will return null.
	 * @param word
	 */
	public void delete(String word);
}
