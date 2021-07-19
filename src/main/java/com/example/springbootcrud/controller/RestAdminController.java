package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestAdminController {
    private final UserService userService;
    private final RoleService roleService;

    public RestAdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<User> getAuthorizedUser() {
        User authorizedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok()
                .body(authorizedUser);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Iterable<Role>> getAllRoles() {
        return ResponseEntity.ok()
                .body(roleService.getAllRoles());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok()
                .body(user);
    }

}
