package com.kitm;

public record Product(String sku, String name, String manufacturer, Category category) {

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", manufacturer=" + manufacturer + ", category=" + category + "]";
	}
}
