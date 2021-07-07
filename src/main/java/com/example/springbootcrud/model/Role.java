package com.example.springbootcrud.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {}

    public Role(String roleName) {
        if (roleName.equals("ROLE_ADMIN")) {
            this.id = 1L;
        } else if (roleName.equals("ROLE_USER")) {
            this.id = 2L;
        }
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
