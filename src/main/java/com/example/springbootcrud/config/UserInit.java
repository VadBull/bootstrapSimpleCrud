package com.example.springbootcrud.config;

import com.example.springbootcrud.dao.RoleRepository;
import com.example.springbootcrud.dao.UserRepository;
import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class UserInit implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;

    public UserInit (UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ADMIN"));
        allRoles.add(new Role("USER"));
        roleService.createRoles(allRoles);
        User admin = new User("admin", "admin", 32, "admin@mail.ru", "admin");
        admin.setRoles("ROLE_ADMIN, ROLE_USER");
        userService.createUser(admin);
        User user = new User("user", "user", 18, "user@mail.ru", "user");
        user.setRoles("ROLE_USER");
        userService.createUser(user);

        User user2 = new User("user2", "user", 18, "user2@mail.ru", "4718395");
        user2.setRoles("ROLE_USER");
        userService.createUser(user2);


    }
}
