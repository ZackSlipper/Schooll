package com.kitm;

public class InventoryItem {
	private Product product;
	private int qtyTotal;
	private int qtyReserved;
	private int qtyReorder;
	private int qtyLow;
	private double salesPrice;

	public InventoryItem(Product product, int qtyTotal, int qtyReserved, int qtyReorder, int qtyLow,
			double salesPrice) {
		this.product = product;
		this.qtyTotal = qtyTotal;
		this.qtyReserved = qtyReserved;
		this.qtyReorder = qtyReorder;
		this.qtyLow = qtyLow;
		this.salesPrice = salesPrice;
	}
	
	public boolean reserveItem(int qty) {
		if (qtyReserved + qty <= qtyTotal) {
			qtyReserved += qty;
			return true;
		}
		return false;
	}

	public void releaseItem(int qty) {
		qtyReserved -= qty;
	}

	public boolean sellItem(int qty) {
		if (qtyReserved < qty)
			return false;

		qtyReserved -= qty;
		qtyTotal -= qty;
		if (qtyTotal <= qtyLow)
			placeInventoryOrder(qtyLow);
		return true;
	}

	public void placeInventoryOrder(int qty) {
		qtyReorder += qty;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "InventoryItem [product=" + product + ", qtyTotal=" + qtyTotal + ", qtyReserved=" + qtyReserved
				+ ", qtyReorder=" + qtyReorder + ", qtyLow=" + qtyLow + ", salesPrice=" + salesPrice + "]";
	}
}
