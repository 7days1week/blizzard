package com.blizzard.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blizzard.bookstore.entity.ShoppingCart;

public interface ShoppingCartService extends IService<ShoppingCart> {
    ShoppingCart selectByUserId(int id);
}
