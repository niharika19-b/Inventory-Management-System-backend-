package com.smart.inventorysystem.service;

import java.util.List;
import com.smart.inventorysystem.entity.User;

public interface UserService {

    User createUser(User user, List<String> roles);

    User getById(int id);

    List<User> getAll();

    User updateUser(int id, User user);

    void deleteUser(int id);
}