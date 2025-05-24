package com.kitm;

public class Fix34 {
	public int[] fix34(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4 && nums[i - 1] != 3) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == 3 && nums[j + 1] != 4) {
						int temp = nums[i];
						nums[i] = nums[j + 1];
						nums[j + 1] = temp;
					}
				}
			}
		}
		return nums;
	}
}