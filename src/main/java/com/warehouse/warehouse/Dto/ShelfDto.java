package com.warehouse.warehouse.Dto;
import com.warehouse.warehouse.entity.Warehouse;

public class ShelfDto {

	private int id;
	private String description;
	private Warehouse warehouse;
	
	public ShelfDto () {
		
	}
	
	public ShelfDto(int id, String description,  Warehouse warehouse) {
		super();
		this.id = id;
		this.description = description;
		this.warehouse = warehouse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}
	public Warehouse setWarehouse(Warehouse warehouse) {
		this.warehouse= warehouse;
		return warehouse;
	}

}
