package com.smart.inventorysystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	@Column(name = "created_at", updatable = false)
	protected LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		createdAt = LocalDateTime.now();
		
	}
	
	@PreUpdate
	public void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
	
	

}
