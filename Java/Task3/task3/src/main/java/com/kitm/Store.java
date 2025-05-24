package com.kitm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

public class Store {
	private ArrayList<InventoryItem> inventory;
	private ArrayList<Cart> carts;
	private HashMap<Category, ArrayList<InventoryItem>> aisleInventory;

	public Store(ArrayList<InventoryItem> inventory, ArrayList<Cart> carts,
			HashMap<Category, ArrayList<InventoryItem>> aisleInventory) {
		this.inventory = inventory;
		this.carts = carts;
		this.aisleInventory = aisleInventory;
	}
	
	public ArrayList<Cart> manageStoreCarts() {
		return carts;
	}

	public void checkOutCarts() {
		for (Cart cart : carts) {
			ArrayList<SimpleEntry<InventoryItem, Integer>> products = cart.getProducts();
			if (products.isEmpty())
				continue;

			for (var product : products) {
				product.getKey().sellItem(product.getValue());
			}
			cart.printSalesSlip();
		}
		carts.clear();
	}

	public void abandonCarts() {
		for (Cart cart : carts) {
			if (cart.getDate().getTime() < System.currentTimeMillis() - 24 * 60 * 60 * 1000) {
				for (var product : cart.getProducts()) {
					product.getKey().releaseItem(product.getValue());
				}
			}
		}
	}

	public void listProductsByCategory() {
		for (Category category : Category.values()) {
			System.out.println("------------------------------------");
			System.out.println("Category: " + category);
			System.out.println();
			System.out.println("Online:");
			for (InventoryItem item : inventory) {
				if (item.getProduct().category() == category)
					System.out.println(item);
			}

			System.out.println();
			System.out.println("In Aisle:");
			for (InventoryItem aisleItem : aisleInventory.get(category)) {
				System.out.println(aisleItem);
			}
			System.out.println("------------------------------------");
		}
	}

	public ArrayList<InventoryItem> getInventory() {
		return inventory;
	}

	public ArrayList<InventoryItem> getAisleInventory(Category category) {
		return aisleInventory.get(category);
	}
}
