package com.example.springbootcrud.config;

import com.example.springbootcrud.dao.RoleDao;
import com.example.springbootcrud.dao.UserDao;
import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Configuration
public class UserInit {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;


    @Transactional
    @Bean(initMethod = "init")
    public void init(){
        Role[] roles = {new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        Set<Role> allRoles = new HashSet<>(Arrays.asList(roles));
        roleDao.createRole(allRoles);
        User admin = new User("admin", "admin");
        admin.setRoles(allRoles);
        userDao.createUser(admin);
    }
}
