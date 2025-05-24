package com.kitm;

public class LinearIn {
	public boolean linearIn(int[] outer, int[] inner) {
		int i = 0;
		for (int o = 0; o < outer.length; o++) {
			if (i == inner.length)
				break;

			if (outer[o] == inner[i])
				i++;
		}

		return i == inner.length;
	}
}
