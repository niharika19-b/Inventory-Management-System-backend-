package com.smart.inventorysystem.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "sku", unique = true, nullable = false)
	private String sku;


	@Column(name = "name", nullable = false)
	private String name;


	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "unit_price", precision = 12, scale = 2)
	private BigDecimal unitPrice;
	
	// INVENTORY
	@Column(name = "current_stock")
	private int currentStock = 0;


	@Column(name = "reorder_level")
	private int reorderLevel = 0;


	@Column(name = "status")
	private String status = "ACTIVE";
	
	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}