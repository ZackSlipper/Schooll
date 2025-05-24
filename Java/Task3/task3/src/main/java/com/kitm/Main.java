package com.kitm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
			new Product("A100","apple","local",Category.PRODUCE),
			new Product("B100","banana","local",Category.PRODUCE),
			new Product("P100","pear","local",Category.PRODUCE),
			new Product("L103","lemon","local",Category.PRODUCE),
			new Product("M201","milk","farm",Category.DAIRY),
			new Product("Y001","yogurt","farm",Category.DAIRY),
			new Product("C333","cheese","farm",Category.DAIRY),
			new Product("R777","rice chex","Nabisco",Category.CEREAL),
			new Product("G111","granola","Nat Valley",Category.CEREAL),
			new Product("BB11","ground beef","butcher",Category.MEAT),
			new Product("CC11","chicken","butcher",Category.MEAT),
			new Product("BC11","bacon","butcher",Category.MEAT),
			new Product("BC77","coke","coca cola",Category.BEVERAGE),
			new Product("BC88","coffee","value",Category.BEVERAGE),
			new Product("BC99","tea","herbal",Category.BEVERAGE)
		);

		Store store = new Store(
				generateRandomInventoryItems(products),
				generateRandomCarts(),
				generateRandomAisleInventory(products));

		for (int i = 0; i < 10; i++)
			addRandomProductsToCart(store.manageStoreCarts().get(i), store);

		store.listProductsByCategory();
		store.abandonCarts();
		store.checkOutCarts();
		store.listProductsByCategory();
	}

	private static ArrayList<InventoryItem> generateRandomInventoryItems(List<Product> products) {
		ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();
		for (Product product : products)
			inventory.add(new InventoryItem(product, (int) (Math.random() * 100), 0, 0, 10, 1 + (Math.random() * 99)));
		return inventory;
	}

	private static ArrayList<Cart> generateRandomCarts() {
		ArrayList<Cart> carts = new ArrayList<Cart>();
		for (int i = 0; i < 10; i++)
			carts.add(new Cart(i, new ArrayList<>(), new Date(), Math.random() < 0.5 ? CartType.PHYSICAL : CartType.VIRTUAL));
		return carts;
	}

	private static HashMap<Category, ArrayList<InventoryItem>> generateRandomAisleInventory(List<Product> products) {
		HashMap<Category, ArrayList<InventoryItem>> aisleInventory = new HashMap<>();

		for (Category category : Category.values()) {
			aisleInventory.put(category, new ArrayList<>());
			for (Product product : products)
				if (product.category() == category)
					aisleInventory.get(category).add(new InventoryItem(product, (int) (Math.random() * 100), 0, 0, 10,
							1 + (Math.random() * 99)));
		}
		return aisleInventory;
	}
	
	private static void addRandomProductsToCart(Cart cart, Store store) {
		for (int i = 0; i < (int) (Math.random() * 10); i++) {
			ArrayList<InventoryItem> inventory = cart.getType() == CartType.PHYSICAL
					? store.getAisleInventory(Category.values()[(int) (Math.random() * Category.values().length)])
					: store.getInventory();

			InventoryItem item = inventory.get((int) (Math.random() * inventory.size()));
			cart.addItem(item, (int) (Math.random() * 100));
		}
	}

}