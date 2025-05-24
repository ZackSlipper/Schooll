package com.kitm;

public class Floor {
	private double length;
	private double width;

	public Floor(double length, double width) {
		this.length = length;
		this.width = width;

		if (length < 0)
			this.length = 0;

		if (width < 0)
			this.width = 0;
	}

	public double getArea() {
		return width * length;
	}
}
