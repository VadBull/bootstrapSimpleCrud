package com.example.springbootcrud.dao;

import com.example.springbootcrud.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Transactional
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    @Override
    public void createRole(Set<Role> roles) {
        roles.forEach(role -> entityManager.persist(role));
    }

    @Override
    public Set<Role> getAllRoles() {
        Set<Role> setRoles = new HashSet<>();
        List<Role> listRoles= entityManager
                .createQuery("select r from Role r")
                .getResultList();
        setRoles.addAll(listRoles);
        return setRoles;
    }
}
