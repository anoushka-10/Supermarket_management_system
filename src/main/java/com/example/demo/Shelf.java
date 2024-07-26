package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shelfId;
    private String shelfName;

    @ManyToOne
    @JoinColumn(name = "rack_id", nullable = false)
    private Rack rack;

    @OneToOne(mappedBy = "shelf")
    private SuperMarket item;

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public SuperMarket getItem() {
		return item;
	}

	public void setItem(SuperMarket item) {
		this.item = item;
	}

	public Shelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shelf(Long shelfId, String shelfName, Rack rack, SuperMarket item) {
		super();
		this.shelfId = shelfId;
		this.shelfName = shelfName;
		this.rack = rack;
		this.item = item;
	}

	@Override
	public String toString() {
		return "Shelf [shelfId=" + shelfId + ", shelfName=" + shelfName + ", rack=" + rack + ", item=" + item + "]";
	}

    // Getters and setters
    
}