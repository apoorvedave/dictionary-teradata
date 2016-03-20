package teradata;

// This code was written only as a support for Dictionary implementation 
// Singly Linked list to represent a list of strings
// It is a minimal representation which currently does not handle null cases and encapsulation of values
// Can be extended to support other List operations.
public class StringList {
	private StringNode head;
	private StringNode tail;
	private int count = 0;
	
	/*
	 *  Method to insert at end of list
	 */
	public void insert(String s) {
		StringNode node = new StringNode(s);
		if (head == null) {
			head = node;
		}
		else {
			tail.setRight(node);
		}
		tail = node;
		count++;
	}
	
	/*
	 * Method to return an array of strings from StringList object
	 */
	public String[] getStrings() {
		if (count == 0) {
			return null;
		}
		String [] strings = new String[count];
		StringNode node = head;
		int i=0;
		while(node!=null) {
			strings[i] = node.getValue();
			i++;
			node=node.getRight();
		}
		return strings;
	}
	
	/*
	 * Some Test Code
	 */
	public static void main(String[] args) {
		// Some Test Code
		StringList sl = new StringList();
		sl.insert("abc");
		System.out.println(sl.head.getValue());
		System.out.println(sl.tail.getValue());
		sl.insert("bac");
		System.out.println(sl.head.getValue());
		System.out.println(sl.tail.getValue());
		
		System.out.println(sl.getStrings()[1]);
	}
}
