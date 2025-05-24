package com.kitm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * int[] arr = { 10, 7, 132, 546, 21, 48, 8, 76, 79, 11 };
		 * 
		 * System.out.println("Array: " + Arrays.toString(arr));
		 * System.out.println("Max: " + Max(arr));
		 * System.out.println("Min: " + Min(arr));
		 * System.out.println("Sum: " + Sum(arr));
		 * System.out.println("Avg: " + Avg(arr));
		 */

		/*
		 * int[] arr2 = { 1, 2, 3, 8, 9, 3, 2, 1 };
		 * int[] arr3 = { 1, 2, 1, 4 };
		 * int[] arr4 = { 7, 1, 2, 9, 7, 2, 1 };
		 * System.out.println("Max mirror: " + maxMirror(arr4));
		 * 
		 * int[][] numbers = { { 1, 2, 3 }, { 4, 5, 6 } };
		 * int rows = 5;
		 * int cols = 4;
		 * 
		 * Random rng = new Random();
		 * int[][] table = new int[rows][cols];
		 * 
		 * for (int i = 0; i < rows; i++) {
		 * for (int j = 0; j < cols; j++)
		 * table[i][j] = rng.nextInt(100);
		 * 
		 * System.out.println(Arrays.toString(table[i]));
		 * }
		 */

		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * System.out.print("Enter the number of rows: ");
		 * int rows = scanner.nextInt();
		 * 
		 * System.out.print("Enter the number of columns: ");
		 * int cols = scanner.nextInt();
		 * 
		 * int[][] arr = new int[rows][cols];
		 * 
		 * for (int i = 0; i < rows; i++) {
		 * for (int j = 0; j < cols; j++) {
		 * System.out.println("Enter the number at position (" + i + ", " + j + "): ");
		 * arr[i][j] = scanner.nextInt();
		 * }
		 * }
		 * 
		 * System.out.println("The array is: ");
		 * for (int i = 0; i < rows; i++) {
		 * for (int j = 0; j < cols; j++)
		 * System.out.printf("%4d ", arr[i][j]);
		 * 
		 * System.out.println();
		 * }
		 * 
		 * System.out.println("The average of the array is: " + multDimArrayAvg(arr));
		 * 
		 * scanner.close();
		 */

		System.out.println(array2DContainsValue(new int[] { 1, 1 },
				new int[] { -2, -2 }, new int[] { 3, 3 }, 1));
		System.out.println(array2DContainsValue(new int[] { -1, 2, 3 },
				new int[] { 4, -5, 6 }, new int[] { 7, 8, -9 }, 5));
		System.out.println(array2DContainsValue(new int[] { 1 },
				new int[] { 2 }, new int[] { 3 }, 1));
	}

	public static boolean array2DContainsValue(int[] row1, int[] row2, int[] row3,
			int value) {
		int[][] arr = { row1, row2, row3 };

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				if (arr[i][j] == value)
					return true;
		return false;
	}

	/*
	 * public static double multDimArrayAvg(int[][] arr)
	 * {
	 * int sum = 0;
	 * int count = 0;
	 * for (int i = 0; i < arr.length; i++)
	 * {
	 * for (int j = 0; j < arr[i].length; j++) {
	 * sum += arr[i][j];
	 * count++;
	 * }
	 * }
	 * 
	 * return (double) sum / count;
	 * }
	 */

	/*
	 * public static int maxMirror(int[] arr) {
	 * int[] reversed = new int[arr.length];
	 * for (int i = 0; i < arr.length; i++)
	 * reversed[arr.length - 1 - i] = arr[i];
	 * 
	 * int maxLength = 0;
	 * int mirrorLength = 0;
	 * 
	 * // section start
	 * for (int i = 0; i < arr.length; i++) {
	 * // section end
	 * for (int j = i; j < arr.length; j++) {
	 * mirrorLength = mirrorLength(arr, i, j, reversed);
	 * 
	 * if (mirrorLength > maxLength)
	 * maxLength = mirrorLength;
	 * }
	 * }
	 * 
	 * return maxLength;
	 * }
	 * 
	 * private static int mirrorLength(int[] arr, int start, int end, int[] revArr)
	 * {
	 * int maxLength = 0;
	 * int length = 0;
	 * for (int i = 0; i < revArr.length; i++) {
	 * length = 0;
	 * for (int j = 0; j < end - start + 1; j++) {
	 * if (i + j >= revArr.length || revArr[i + j] != arr[start + j])
	 * break;
	 * 
	 * length++;
	 * if (j == end - start) {
	 * if (length > maxLength)
	 * maxLength = length;
	 * }
	 * }
	 * }
	 * 
	 * return maxLength;
	 * }
	 */

	/*
	 * public static int Max(int[] arr) {
	 * int max = arr[0];
	 * for (int i = 1; i < arr.length; i++)
	 * if (arr[i] > max)
	 * max = arr[i];
	 * 
	 * return max;
	 * }
	 * 
	 * public static int Min(int[] arr) {
	 * int min = arr[0];
	 * for (int i = 1; i < arr.length; i++)
	 * if (arr[i] < min)
	 * min = arr[i];
	 * 
	 * return min;
	 * }
	 * 
	 * public static int Sum(int[] arr) {
	 * int sum = 0;
	 * for (int i = 0; i < arr.length; i++)
	 * sum += arr[i];
	 * return sum;
	 * }
	 * 
	 * public static double Avg(int[] arr) {
	 * return (double) Sum(arr) / arr.length;
	 * }
	 */
}