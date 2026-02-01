package com.smart.inventorysystem.repository;

import java.util.List;

import com.smart.inventorysystem.entity.AuditLog;
import com.smart.inventorysystem.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {


List<AuditLog> findByUser(User user);
}
