package model;

public class MatrixGame {
	
	private Node first;
	private int numRows;
	private int numCols;
	private int contador;
	
	public MatrixGame(int m, int n) {
		numRows = m;
		numCols = n;
		createMatrix();
	}
	
	public Node getFirst() {
		return first;
	}
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
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
		if(j+1<numCols) {
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
	
//	public void showMirror() {
//		
//		first.getDown().getNext().getNext().setA(true);
//		
//		if (walkAroundMatrix(pos).checkMirror() == true) {
//			walkAroundMatriz(pos).setA(true);
//		}
//		toString();
//		first.setA(true);
//	}
	
	public void reStartMirror(int k, int f, int c) {
		
		setContador(k);
		generateMirror(f, c, k);
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
	
	public String createRandomMirror() {
		
		String m = "";
		double b = Math.random() *10;
		int c = (int)b;
		
		if (c % 2 == 0) {
			m =  "/"; //derecha

		}else {
			m =  "\\";//izquierda
		}
		return m;
	}
	
	public void generateMirror(int f, int c, int k) { // a = 3; b = 3; mirror = 4; mirror > 9
		String mg = "";
		System.out.println(k);
		if(contador <= f * c) {     
			if(contador <= 0) {
			}else {
				Node temp = generateRandomPosition(f,c);  //1A ; 1A
				
				System.out.println(temp);
				System.out.println(temp.getMirror());
				
 				if(temp.getMirror() == "") {    //1A = ""; 1A = "/" O 1A = "\\";  
 					System.out.println("true");
					temp.setMirror(createRandomMirror());
					System.out.println(temp.getMirror());
				}else {
					System.out.println("Hay una position que ya tiene");
					generateMirror(f,c,contador);
				}
				System.out.println("Siguiente espejo");
				contador  = contador - 1;
				generateMirror(f,c,contador);
			}
		}else {
			mg = "No se puede generar los espejos porque la cantidad supera las dimensiones de la matriz";
		}
		
	}
	
	public Node generateRandomPosition(int f, int c) {
		
		double a1 = Math.random() * f+1;
		double b1 = Math.random() * c;
		
		int fil = (int)a1;
		int col = (int)b1;
		//char col = (char)('A'+ c1);
		
		return walkAroundMatrix(fil, col, getFirst());
	}
}
