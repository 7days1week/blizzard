package com.blizzard.bookstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotNull(message = "title not null")
    private String title;
    private String author;

    private double price;
    private String category;
}
