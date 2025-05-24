package com.kitm;

public class MaxMirror {
	public int maxMirror(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				if (nums[i] == nums[j]) {
					int mirrorLength = mirrorLength(nums, i, j);
					if (mirrorLength > max)
						max = mirrorLength;
				}
			}
		}
		return max;
	}
	
	private int mirrorLength(int[] nums, int i, int j) {
		int count = 0;
		while (i >= 0 && j < nums.length && nums[i] == nums[j]) {
			count++;
			i--;
			j++;
		}
		return count;
	}
}
