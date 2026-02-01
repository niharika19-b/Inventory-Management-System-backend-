package com.smart.inventorysystem.repository;

import java.util.List;
import java.util.Optional;

import com.smart.inventorysystem.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional <User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	  // Only ADMIN 
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = 'ROLE_ADMIN'")
    List<User> findAdmins();

    // Only STAFF users
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = 'ROLE_STAFF'")
    List<User> findStaff();

    // ADMIN + STAFF
    @Query("SELECT DISTINCT u FROM User u JOIN u.roles r WHERE r.name IN ('ROLE_ADMIN','ROLE_STAFF')")
    List<User> findAdminAndStaff();
}

