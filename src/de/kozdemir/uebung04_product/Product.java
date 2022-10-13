package de.kozdemir.uebung04_product;

import java.time.LocalDateTime;

public class Product {
	private int id; 
	private String name;
	private String description;
	private double price;
	private LocalDateTime createdAt;
	
	private static int count; //Class Variable count

	public Product() {
		createdAt = LocalDateTime.now();
		setCreatedAt(createdAt);
		setId(++count);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [name=").append(name).append(", description=").append(description).append(", price=")
				.append(price).append(", createdAt=").append(createdAt).append("]\n");
		
		return builder.toString();
	}


}