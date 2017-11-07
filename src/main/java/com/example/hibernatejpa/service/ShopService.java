package com.example.hibernatejpa.service;

import com.example.hibernatejpa.repository.ShoppingCartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private static final Logger log = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public void logAll() {
        log.info("logAll");
        shoppingCartRepository.findAll().forEach(shoppingCart1 -> {
            log.info("ShoppingCart={}", shoppingCart1);
        });
    }
}
