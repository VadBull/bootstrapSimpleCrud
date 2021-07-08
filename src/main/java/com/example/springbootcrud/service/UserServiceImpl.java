package com.example.springbootcrud.service;

import com.example.springbootcrud.dao.RoleDao;
import com.example.springbootcrud.dao.UserDao;
import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public UserServiceImpl() {}


    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }


    @Override
    public User getUserById(Long id) {
        return (User) userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void createRole(Set<Role> roles) {
        roleDao.createRole(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}