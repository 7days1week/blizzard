package com.blizzard.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blizzard.bookstore.entity.ShoppingCart;
import com.blizzard.bookstore.mapper.ShoppingCartMapper;
import com.blizzard.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    public ShoppingCart selectByUserId(int id) {
        return this.shoppingCartMapper.selectByUserId(id);
    }

}
