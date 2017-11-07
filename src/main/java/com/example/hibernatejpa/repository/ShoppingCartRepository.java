package com.example.hibernatejpa.repository;

import com.example.hibernatejpa.model.onetomany.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

    Collection<ShoppingCart> findAll();

    ShoppingCart findByName(String name);
}
