package com.blizzard.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blizzard.bookstore.entity.CartItem;
import com.blizzard.bookstore.mapper.CartItemMapper;
import com.blizzard.bookstore.mapper.ShoppingCartMapper;
import com.blizzard.bookstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private CartItemMapper cartItemMapper;

}
