package ui;

import model.*;

public class Main {
	
	public static void main(String[] args) {
		MatrixGame matrix = new MatrixGame(3, 3);
		System.out.println(matrix);
		System.out.println(matrix);
		Node a = matrix.walkAroundMatrix(2, 3, matrix.getFirst());
		System.out.println(a.isA());
	}
}
