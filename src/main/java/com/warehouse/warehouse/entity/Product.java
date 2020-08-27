package com.warehouse.warehouse.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int barcode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "unit")
	private Integer unit;
	
	public Product() {
		
	}

	public Product(int barcode, String description, int unit) {
		super();
		this.barcode = barcode;
		this.description = description;
		this.unit = unit;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	
}
