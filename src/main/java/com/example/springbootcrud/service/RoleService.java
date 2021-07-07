package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;

import java.util.Set;

public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}
