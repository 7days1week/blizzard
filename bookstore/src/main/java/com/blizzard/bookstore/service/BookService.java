package com.blizzard.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blizzard.bookstore.entity.Book;
import com.blizzard.bookstore.entity.ShoppingCart;

import java.util.List;

public interface BookService extends IService<Book> {
    List<Book> list();
    Book getById(int id);
    boolean add(Book book);
    ShoppingCart addToCart(int userId, int bookId, int quantity);
}
