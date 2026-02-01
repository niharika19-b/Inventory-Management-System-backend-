package com.smart.inventorysystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.smart.inventorysystem.entity.User;
import com.smart.inventorysystem.entity.Role;
import com.smart.inventorysystem.repository.UserRepository;
import com.smart.inventorysystem.repository.RoleRepository;
import com.smart.inventorysystem.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // CREATE
    @Override
    public User createUser(User user, List<String> roleNames) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }

        user.setRoles(roles);

        return userRepository.save(user);
    }

    // GET BY ID
    @Override
    public User getById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // GET ALL
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // UPDATE (only existing fields)
    @Override
    public User updateUser(int id, User updatedUser) {

        User existing = getById(id);

        existing.setUsername(updatedUser.getUsername());
        existing.setEnabled(updatedUser.isEnabled());

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteUser(int id) {
        userRepository.delete(getById(id));
    }
}