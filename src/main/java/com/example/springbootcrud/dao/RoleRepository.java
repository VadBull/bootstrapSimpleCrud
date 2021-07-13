package com.example.springbootcrud.dao;

import com.example.springbootcrud.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
