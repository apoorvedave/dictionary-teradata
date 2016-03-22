package teradata;

public class StringNode {
	// Implements a node of a list of strings;
	private String value;
	private StringNode left;
	private StringNode right;

	public StringNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public StringNode getLeft() {
		return left;
	}

	public void setLeft(StringNode left) {
		this.left = left;
	}

	public StringNode getRight() {
		return right;
	}

	public void setRight(StringNode right) {
		this.right = right;
	}
}
