package com.smart.inventorysystem.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	@Column(name = "action")
	private String action;


	@Column(name = "entity")
	private String entity;


	@Column(name = "timestamp")
	private LocalDateTime timestamp = LocalDateTime.now();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getEntity() {
		return entity;
	}


	public void setEntity(String entity) {
		this.entity = entity;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	}

