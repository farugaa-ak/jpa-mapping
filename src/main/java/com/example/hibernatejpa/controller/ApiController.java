package com.example.hibernatejpa.controller;

import com.example.hibernatejpa.model.onetomany.ShoppingCart;
import com.example.hibernatejpa.repository.ShoppingCartRepository;
import com.example.hibernatejpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ApiController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShopService shopService;

    @Autowired
    public ApiController(ShoppingCartRepository shoppingCartRepository, ShopService shopService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shopService = shopService;
    }

    @GetMapping("/api/shoppingcarts")
    Collection<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @GetMapping("/api/log")
    void justLog() {
        shopService.logAll();
    }

}
