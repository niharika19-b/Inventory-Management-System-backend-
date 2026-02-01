package com.smart.inventorysystem.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import com.smart.inventorysystem.repository.UserRepository;
import com.smart.inventorysystem.entity.User;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    //show ONLY admin
    @GetMapping("/admin")
    public List<User> adminUsers() {
        return userRepository.findAdmins();
    }

    // ONLY staff
    @GetMapping("/staff")
    public List<User> staffUsers() {
        return userRepository.findStaff();
    }

    //  ADMIN + STAFF
    @GetMapping("/profile")
    public List<User> profile(Authentication auth) {
        return userRepository.findAdminAndStaff();
    }
}



