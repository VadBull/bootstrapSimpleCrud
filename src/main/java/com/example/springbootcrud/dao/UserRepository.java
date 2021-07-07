package com.example.springbootcrud.dao;


import com.example.springbootcrud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}