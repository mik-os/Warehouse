package com.warehouse.warehouse.Dto;
import java.util.Date;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;

public class StockDto {

	private int id;
	private Date date;	
	private Product product;
	private Shelf shelf;
	private Integer quantity;
	
	public StockDto() {
		
	}
	
	public StockDto(Integer id, Date date, Product product, Shelf shelf, Integer quantity) {
		super();
		this.id = id;
		this.date = date;
		this.product = product;
		this.shelf = shelf;
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
}
