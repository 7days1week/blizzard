package com.blizzard.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blizzard.bookstore.entity.CartItem;
import org.apache.ibatis.annotations.Insert;

public interface CartItemMapper extends BaseMapper<CartItem> {

    @Insert("INSERT INTO cart_item (shopping_cart_id, book_id, quantity) Values (#{shoppingCartId}, #{book.id}, #{quantity})")
    int addCartItem(CartItem item);
}