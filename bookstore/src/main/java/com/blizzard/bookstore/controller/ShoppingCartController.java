package com.blizzard.bookstore.controller;

import com.blizzard.bookstore.entity.ShoppingCart;
import com.blizzard.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/cart/{userId}")
    public ShoppingCart select(@PathVariable int userId) {
        ShoppingCart cart = this.shoppingCartService.selectByUserId(userId);
        return cart;
    }

    @GetMapping("/cart/checkout/{userId}")
    public double checkout(@PathVariable int userId) {
        double totalPrice = 0;
        ShoppingCart cart = this.shoppingCartService.selectByUserId(userId);
        if (cart != null) {
            double totalPriceUnformat = cart.getCartItems().stream()
                    .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity()).sum();
            totalPrice = BigDecimal.valueOf(totalPriceUnformat).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return BigDecimal.valueOf(totalPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


}
