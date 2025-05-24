package com.kitm;

public class SquareUp {
	public int[] squareUp(int n) {
		int[] arr = new int[n * n];
		int[] insert = new int[n];

		for (int i = insert.length - 1; i >= 0; i--) {
			insert[i] = n - i;
			for (int j = 0; j < insert.length; j++) {
				arr[j + (n - 1 - i) * n] = insert[j];
			}
		}

		return arr;
	}
}
