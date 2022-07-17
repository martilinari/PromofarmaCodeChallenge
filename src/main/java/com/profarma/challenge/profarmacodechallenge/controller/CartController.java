package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.service.implementation.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promofarma/cart")

public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    //post cart api
    public ResponseEntity<?> addToCart() {

        return null;
    }

    //get all cart items

    //delete a cart item


}
