package com.blizzard.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blizzard.bookstore.entity.CartItem;
import com.blizzard.bookstore.entity.ShoppingCart;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    @Select("select * from shopping_cart s WHERE s.user_id=#{userId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "cartItems", many = @Many(
            select = "com.blizzard.bookstore.mapper.CartItemMapper.selectCartItemsByCartId"

    ))})
    ShoppingCart selectByUserId(Integer userId) ;

    @Select("SELECT * FROM cart_item WHERE shopping_cart_id = #{id}")
    List<CartItem> selectCartItemsByCartId(Integer id);


}