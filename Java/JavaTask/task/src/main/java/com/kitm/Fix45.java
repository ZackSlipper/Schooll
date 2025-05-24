package com.kitm;

public class Fix45 {
	public int[] fix45(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4) {
				int fiveIndex = -1;
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == 5 && (j == 0 || nums[j - 1] != 4)) {
						fiveIndex = j;
						break;
					}
				}

				if (fiveIndex != -1) {
					int temp = nums[i + 1];
					nums[i + 1] = 5;
					nums[fiveIndex] = temp;
				}
			}
		}
		
		return nums;
	}
}
