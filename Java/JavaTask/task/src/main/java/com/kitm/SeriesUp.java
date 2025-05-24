package com.kitm;

public class SeriesUp {
	public int[] seriesUp(int n) {
		int len = n * (n + 1) / 2;
		int[] arr = new int[len];
		int groupLength = 1;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= groupLength; j++) {
				arr[i] = j;
				i++;
			}
			groupLength++;
			i--;
		}
		return arr;
	}
}
