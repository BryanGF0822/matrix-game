package model;

public class Node {
	
	private int fil;
	private int col;
	private String pos;
	private String mirror;
	private boolean a;
	private boolean b;
	private boolean start;
	private boolean end;
	
	private Node next;
	private Node prev;
	private Node up;
	private Node down;
	

	public Node(int fil, int col) {
		this.fil = fil+1;
		this.col = col;
		
		this.next = null;
		this.prev = null;
		this.up = null;
		this.down = null;
		
		this.mirror = "";
		
		this.a = false;
		this.b = false;
		
		char letter = (char)(64 + this.col);
		this.pos = this.fil + "" + letter;
	}
	
	/**
	 * Allows you to check whether or not there is a mirror in a cell.
	 * @return [returns a boolean as false or true to know whether or not there is a mirror.]
	 */
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

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public void setMirror(String mirror) {
		this.mirror = mirror;
	}

	/**
	 * It allows to show in the matrix with the mirrors in case they are found,
	 * also to visualize where the laser beam enters and exits and the positions of the matrix.
	 */
	public String toString(){
		if(a == true) {
			return "[(" + "X" + ")]";
		}else if(b == true) {
			return "[( " +  mirror  + " )]";
		}else if(start == true) {
			return "[(" +  "S"  + ")]";
		}else if(end == true) {
			return "[(" +  "E"  + ")]";
		}
		else {
			return "[(" + pos + ")]";
		}
		
	}
	
	/**
	 * Allows to show the positions of the matrix.
	 * @param [Flase or true para mostrar las posiciones.]
	 * @return [returns the matrix with the positions of each cell.]
	 */
	public String toString(boolean c) {
		return "[(" + pos + ")]";
	}
}
