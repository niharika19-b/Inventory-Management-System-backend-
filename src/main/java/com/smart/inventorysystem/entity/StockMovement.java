package com.smart.inventorysystem.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;


	@Column(name = "quantity")
	private int quantity;


	@Column(name = "type")
	private String type; // IN / OUT / ADJUSTMENT


	@Column(name = "reason")
	private String reason;


	@Column(name = "previous_stock")
	private int previousStock;


	@Column(name = "new_stock")
	private int newStock;


	@Column(name = "timestamp", updatable = false)
	private LocalDateTime timestamp = LocalDateTime.now();

	public StockMovement() {
	}
	public StockMovement(int id, Product product, int quantity, String type, String reason, int previousStock,
			int newStock, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.type = type;
		this.reason = reason;
		this.previousStock = previousStock;
		this.newStock = newStock;
		this.timestamp = timestamp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public int getPreviousStock() {
		return previousStock;
	}


	public void setPreviousStock(int previousStock) {
		this.previousStock = previousStock;
	}


	public int getNewStock() {
		return newStock;
	}


	public void setNewStock(int newStock) {
		this.newStock = newStock;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
