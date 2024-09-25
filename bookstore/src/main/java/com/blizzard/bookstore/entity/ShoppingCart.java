package com.blizzard.bookstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("shopping_cart")
public class ShoppingCart {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private List<CartItem> cartItems;
}
