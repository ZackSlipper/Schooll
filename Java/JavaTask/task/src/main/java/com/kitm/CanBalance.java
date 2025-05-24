package com.kitm;

public class CanBalance {
	public boolean canBalance(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < i; j++) {
				sum1 += nums[j];
			}
			for (int j = i; j < nums.length; j++) {
				sum2 += nums[j];
			}

			if (sum1 == sum2) {
				return true;
			}
		}
		return false;
	}

}
