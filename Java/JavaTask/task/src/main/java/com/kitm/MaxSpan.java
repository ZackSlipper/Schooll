package com.kitm;

public class MaxSpan {
	public int maxSpan(int[] nums) {
		int maxSpan = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					int span = j - i + 1;
					if (span > maxSpan)
						maxSpan = span;
				}
			}
		}
		return maxSpan;
	}
}
