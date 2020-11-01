package ui;

import model.*;

public class Main {
	
	public static void main(String[] args) {
		MatrixGame matrix = new MatrixGame(5, 5);
		System.out.println(matrix);
		System.out.println();
		//matrix.showMirror(); 
		System.out.println(matrix);
		//Node a = matrix.walkAroundMatrix(5, 5, matrix.getFirst());
		//System.out.println(a);
		System.out.println(matrix.createRandomMirror());
		System.out.println(matrix.createRandomMirror());
		System.out.println(matrix.createRandomMirror());
		System.out.println(matrix.createRandomMirror());
		System.out.println(matrix.createRandomMirror());
		
		System.out.println();
		System.out.println("POSICIONES");
		
		System.out.println(matrix.generateRandomPosition(5, 5));
		System.out.println(matrix.generateRandomPosition(5, 5));
		System.out.println(matrix.generateRandomPosition(5, 5));
		System.out.println(matrix.generateRandomPosition(5, 5));
		System.out.println(matrix.generateRandomPosition(5, 5));
		System.out.println(matrix.generateRandomPosition(5, 5));

		
		System.out.println();
		System.out.println("ESPEJOS");
		matrix.reStartMirror(16,4,4);
	}
}
