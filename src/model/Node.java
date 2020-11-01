package model;

public class Node {
	
	private int fil;
	private int col;
	
	
	private String pos = "" + fil + (char)(col);
	
	private Node next;
	private Node prev;
	private Node up;
	private Node down;
	
	//private String espejo;

	public Node(int f, int c) {
		fil = f;
		col = c;
	}

	public int getFil() {
		return fil;
	}

	public int getCol() {
		return col;
	}

	public char getNameCol() {
		return (char)('A' + col);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}
	
	public String toString() {
		return "[("+fil+","+col+")]";
	}
}
