package com.example.hibernatejpa.repository;

import com.example.hibernatejpa.model.onetomany.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}

