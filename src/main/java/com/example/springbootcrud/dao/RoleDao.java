package com.example.springbootcrud.dao;

import com.example.springbootcrud.model.Role;

import java.util.Set;

public interface RoleDao {
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();

}
