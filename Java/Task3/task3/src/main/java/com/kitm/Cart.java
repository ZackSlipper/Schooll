package com.kitm;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Date;

public class Cart {
	private int Id;
	private ArrayList<SimpleEntry<InventoryItem, Integer>> products;
	private Date date;
	private CartType type;

	public Cart(int Id, ArrayList<SimpleEntry<InventoryItem, Integer>> products, Date date, CartType type) {
		this.Id = Id;
		this.products = products;
		this.date = date;
		this.type = type;
	}

	public boolean addItem(InventoryItem item, int qty) {
		if (item.reserveItem(qty))
		{
			products.add(new SimpleEntry<>(item, qty));
			return true;
		}
		return false;
	}

	public void removeItem(SimpleEntry<InventoryItem, Integer> item) {
		products.remove(item);
		item.getKey().releaseItem(item.getValue());
	}

	public Date getDate() {
		return date;
	}

	public CartType getType() {
		return type;
	}

	public ArrayList<SimpleEntry<InventoryItem, Integer>> getProducts() {
		return products;
	}

	public SimpleEntry<InventoryItem, Integer> getProduct(String sku) {
		return products.stream().filter(p -> p.getKey().getProduct().sku().equals(sku)).findFirst().orElse(null);
	}

	public void printSalesSlip() {
		System.out.println("------------------------------------");
		System.out.println("Sales Slip");
		System.out.println("Cart ID: " + Id);
		System.out.println("Date: " + date);
		System.out.println("Type: " + type);
		System.out.println("Products:");
		for (SimpleEntry<InventoryItem, Integer> product : products) {
			System.out.println(product.getKey().getProduct() + " x" + product.getValue());
		}
		System.out.println("------------------------------------");
	}
}
