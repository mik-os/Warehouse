package com.warehouse.warehouse.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name ="date")
	private Date date;	
	
	@ManyToOne
	@JoinColumn(name="barcode")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="shelf")
	private Shelf shelf;
	
	@Column(name = "quantity")
	private Integer quantity;

    public Stock() {
        	
    }

	public Stock(Integer id, Date date, Product product, Shelf shelf, Integer quantity) {
		super();
		this.id = id;
		this.date = date;
		this.product = product;
		this.shelf = shelf;
		this.quantity = quantity;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		
		
}		