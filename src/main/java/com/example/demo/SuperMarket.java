package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SuperMarket {

	public SuperMarket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	long id;
	String name;
	double price;
	int quantity;
	
	@ManyToOne
    private Shelf shelf;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Shelf getShelf() {
		return shelf;
	}
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	@Override
	public String toString() {
		return "SuperMarket [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", shelf="
				+ shelf + "]";
	}
	public SuperMarket(long id, String name, double price, int quantity, Shelf shelf) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.shelf = shelf;
	}
	
	
	
}
