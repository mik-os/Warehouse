package com.warehouse.warehouse.Dto;

public class ProductDto {
	
	private int barcode;
	private String description;
	private int unit;
	
	public ProductDto(int barcode, String description, int unit) {
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
