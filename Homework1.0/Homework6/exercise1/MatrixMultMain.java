package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MatrixMultMain {
	public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
		if (matrixA == null || matrixB == null || matrixA.length == 0 || matrixB.length == 0) {
			throw new IllegalArgumentException("Matrices cannot be null or empty.");

		}
		if (matrixA[0].length != matrixB.length) {
			throw new IllegalArgumentException("Matrix A columns must equal Matrix B rows for multiplication. "
					+ "A_cols= " + matrixA[0].length + ", B_rows= " + matrixB.length);
			/*
			 * int[][] matrixA = { {1, 2, 3}, // Row 0 {4, 5, 6}, // Row 1 {7, 8, 9}, // Row
			 * 2 {10, 11, 12} // Row 3 }; // This is a 4x3 matrix (4 rows, 3 columns
			 */}
		int rowsA = matrixA.length;
		int colsA = matrixA[0].length;
		int colsB = matrixB[0].length;
		int[][] resultMatrix = new int[rowsA][colsB];
		// To calculate resultMatrix[i][j], we need to sum up products:
		// matrixA[i][0]*matrixB[0][j] + matrixA[i]
		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				List<DotProductThread> threadsForElement = new ArrayList<>();
				int sumForElement = 0;

				for (int k = 0; k < colsA; k++) {
					DotProductThread task = new DotProductThread(matrixA[i][k], matrixB[k][j]); // Think of it as an
																								// empty box or a blank
																								// to-do list,
																								// specifically designed
																								// to hold our "worker
																								// threads"
					threadsForElement.add(task); // It takes the task object (our worker thread) and puts it into the
													// threadsForElement list.
					task.start(); // how you get multiple calculations happening

				}
				for (DotProductThread task : threadsForElement) {
					try {
						task.join(); // Your main program PAUSES here, waiting for THIS specific robot to finish.
						sumForElement += task.getDot(); // Get the computed product

					} catch (InterruptedException e) {
						System.err.println("Thread for element calculation was interrupted " + e.getMessage());
						Thread.currentThread().interrupt();
						throw new RuntimeException("Matrix multiplication interrupted", e);
					}
				}
				resultMatrix[i][j] = sumForElement;

			}

		}
		return resultMatrix;

	}
	
	public static void printMatrixSimple(String label, int[][] matrix) {
		System.out.println(label);
		if(matrix == null) {
			System.out.println("null");
			return;
		}
		for(int[] row: matrix) {
			for(int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println(); // values would be printed below 
		}
		System.out.println(); // extra space after the matrix has been printed 
	}

	public static void main(String[] args) {
		System.out.println("--Matrix Multiplication Test--");
		int[][] matrixA = {
				{1,2},
				{3,4}
		};
		int[][] matrixB = {
				{5,6},
				{7,8}
		};
		printMatrixSimple("Matrix A:", matrixA);
		printMatrixSimple("Matrix B:", matrixB);
		
		try {
			int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
			printMatrixSimple("Result Matrix C (A*B):", productMatrix);
		} catch (Exception e) {
			System.err.println("An error occurred during matrix multiplication: " + e.getMessage());
			e.printStackTrace();
		}

	}
}