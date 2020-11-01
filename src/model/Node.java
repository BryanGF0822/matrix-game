package model;

public class Node {
	
	private int fil;
	private int col;
	private String pos;
	private String mirror;
	private boolean a;
	
	private Node next;
	private Node prev;
	private Node up;
	private Node down;
	

	public Node(int f, int c) {
		fil = f+1;
		col = c;
		
		this.next = null;
		this.prev = null;
		this.up = null;
		this.down = null;
		
		this.mirror = "";
		
		a = false;
		
		char letter = (char)('A' + col);
		this.pos = fil + "" + letter;
	}
	
	public boolean checkMirror() {
		if (mirror == "") {
			return false;
		}else {
			return true;
		}
	}

	public int getFil() {
		return fil;
	}

	public int getCol() {
		return col;
	}

	public String getPos() {
		return pos;
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
	
	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public String getMirror() {
		return mirror;
	}

	public void setMirror(String mirror) {
		this.mirror = mirror;
	}

	public String toString() {
		if (this.a == false) {
			return "[" + pos + "]";

		}else {
			return "[" + mirror + "]";

		}
	}
}
