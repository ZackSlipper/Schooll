package com.kitm;

public class CountClumps {
	public int countClumps(int[] nums) {
		int count = 0;
		boolean inClump = false;
		int last;
		for (int i = 1; i < nums.length; i++) {
			last = nums[i - 1];
			if (nums[i] == last && !inClump) {
				inClump = true;
				count++;
			} else if (nums[i] != last) {
				inClump = false;
			}
		}
		return count;
	}
}
