package pl.jaros.Models;

public class Product {
	private String name;
	private String price;
	private String supplier;

	public Product(String name, String price, String supplier) {
		this.name = name;
		this.price = price;
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
