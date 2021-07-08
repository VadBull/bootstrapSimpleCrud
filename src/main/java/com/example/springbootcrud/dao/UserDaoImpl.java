package com.example.springbootcrud.dao;


import com.example.springbootcrud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("select u from User u")
                .getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserByName(String name) {
        return (User) entityManager
                .createQuery("select u from User u where u.userName=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public User getUserById(Long id) {
        return (User) entityManager
                .createQuery("select u from User u where u.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
