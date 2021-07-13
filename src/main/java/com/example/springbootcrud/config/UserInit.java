package com.example.springbootcrud.config;

import com.example.springbootcrud.dao.RoleRepository;
import com.example.springbootcrud.dao.UserRepository;
import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class UserInit implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserInit (UserRepository userRepository,
                            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role[] rolesArray = new Role[]{new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.addAll(Arrays.asList(rolesArray));
        roleRepository.saveAll(rolesSet);
        User admin = new User("admin", "admin", 30, "admin@mail.ru", "admin", rolesSet);
        userRepository.save(admin);
    }
}
