package com.example.hibernatejpa.repository;

import com.example.hibernatejpa.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    @Transactional(readOnly = true)
    public User update(User user){
        return entityManager.merge(user);
    }

    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        Query query_find_all_users = entityManager.createNamedQuery("query_find_all_users", User.class);
        return query_find_all_users.getResultList();
    }
}
