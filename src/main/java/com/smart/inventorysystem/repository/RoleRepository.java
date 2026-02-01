package com.smart.inventorysystem.repository;

import java.util.Optional;

import com.smart.inventorysystem.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {


Optional<Role> findByName(String name);
} 
