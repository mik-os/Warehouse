package com.warehouse.warehouse.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bulletin")
public class Bulletin {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "barcode")
	private Product product;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "shelf")
	private Shelf shelf;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "employee")
	private String employee;
	
	@Column(name = "TIM")
	private String TIM;


    public Bulletin() {
    	
    }

	public Bulletin(Integer id, String type, Product product, Shelf shelf, Date date, Integer quantity, String employee, String TIM) {
		super();
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

	public String getTIM() {
		return TIM;
	}

	public void setTIM(String tIM) {
		TIM = tIM;
	}
	
	
}