package com.warehouse.warehouse.Dto;
import java.util.Date;
import java.util.List;

import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;

public class BulletinDto {	
	
	private Integer id;
	private String type;
	private Product product;
	private Shelf shelf;
	private Date date;
	private Integer quantity;
	private String employee;
	private String TIM;
	private List<Product> products;
	
	@Override
	public String toString() {
		return "BulletinDto [id=" + id + ", type=" + type + ", product=" + product + ", shelf=" + shelf + ", date="
				+ date + ", quantity=" + quantity + ", employee=" + employee + ",TIM=" + TIM + "]";
	}

    public BulletinDto() {
    	
    }

	public BulletinDto(Integer id,List<Product> products,String type, Product product, Shelf shelf, Date date, Integer quantity,
			String employee, String TIM) {
		super();
		this.products = products;
		this.id = id;
		this.type = type;
		this.product = product;
		this.shelf = shelf;
		this.date = date;
		this.quantity = quantity;
		this.employee = employee;
		this.TIM = TIM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getTIM() {
		return TIM;
	}

	public void setTIM(String tIM) {
		TIM = tIM;
	}

	
}
