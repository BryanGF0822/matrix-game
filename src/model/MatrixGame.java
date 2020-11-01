package model;

public class MatrixGame {
	
	private Node first;
	private int numRows;
	private int numCols;
	
	public MatrixGame(int m, int n) {
		numRows = m;
		numCols = n;
		createMatrix();
	}
	
	public Node getFirst() {
		return first;
	}



	private void createMatrix() {
		first = new Node(0,0);
		createRow(0,0,first);
	}

	private void createRow(int i, int j, Node currentFirstRow) {
		createCol(i,j,currentFirstRow,currentFirstRow.getUp());
		if(i+1<numRows) {
			Node downFirstRow = new Node(i+1,j);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}

	private void createCol(int i, int j, Node prev, Node rowPrev) {
		if(j<numCols) {
			Node current = new Node(i, j+1);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowPrev!=null) {
				rowPrev = rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			
			createCol(i,j+1,current,rowPrev);
		}
	}
	
	public String toString() {
		String msg;
		msg = toStringRow(first);
		return msg;
	}

	private String toStringRow(Node firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	private String toStringCol(Node current) {
		String msg = "";
		if(current!=null) {
			msg = current.toString();
			msg += toStringCol(current.getNext());
		}
		return msg;
	}
	
	public String toString2() {
		String msg = "";
		
		return msg;
	}
	
	public void showMirror() {
		
		first.getDown().getNext().getNext().setA(true);
		
//		if (walkAroundMatrix(pos).checkMirror() == true) {
//			walkAroundMatriz(pos).setA(true);
//		}
//		toString();
//		first.setA(true);
	}
	
	public Node walkAroundMatrix(int f, int c, Node tempo) {
		
		if (f == tempo.getFil()) {
			if (c == tempo.getCol()) {
				return tempo;
			}else {
				tempo = tempo.getNext();
				return walkAroundMatrix(f, c, tempo);
			}
		}else {
			tempo = tempo.getDown();
			return walkAroundMatrix(f, c, tempo);
		}
	}
	
}
