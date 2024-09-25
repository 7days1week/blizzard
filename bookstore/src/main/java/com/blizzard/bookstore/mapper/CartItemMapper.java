package com.blizzard.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blizzard.bookstore.entity.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartItemMapper extends BaseMapper<CartItem> {
//    @Select("SELECT * FROM cart_item WHERE shopping_cart_id = #{id}")
//    @Results({
//            @Result(column = "id", property = "id"),
//            @Result(column = "id", property = "book", one = @One(
//                    select = "com.blizzard.bookstore.mapper.BookMapper.selectBookById"
//
//            ))})
//    List<CartItem> selectCartItemsByCartId(Integer id);

    @Insert("INSERT INTO cart_item (shopping_cart_id, book_id, quantity) Values (#{shoppingCartId}, #{book.id}, #{quantity})")
    int addCartItem(CartItem item);
}