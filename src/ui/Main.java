package ui;

import model.*;

public class Main {
	
	public static void main(String[] args) {
		MatrixGame matrix = new MatrixGame(3, 3);
		System.out.println(matrix);
		System.out.println();
		matrix.showMirror(); 
		System.out.println(matrix);
		Node a = matrix.walkAroundMatrix(2, 2, matrix.getFirst());
		System.out.println(a);
	}
}
