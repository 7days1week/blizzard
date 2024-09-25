package com.blizzard.bookstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart_item")
public class CartItem {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Book book;
    private Integer shoppingCartId;
    private Integer quantity;
}
