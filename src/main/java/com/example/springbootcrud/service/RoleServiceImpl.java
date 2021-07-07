package com.example.springbootcrud.service;

import com.example.springbootcrud.dao.RoleRepository;
import com.example.springbootcrud.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRoles(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(role -> set.add(role));
        return set;
    }
}