package com.blizzard.bookstore.controller;

import com.blizzard.bookstore.entity.Book;
import com.blizzard.bookstore.entity.ShoppingCart;
import com.blizzard.bookstore.service.BookService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PostMapping("/book")
    public Book add(@Validated Book book) {
        this.bookService.add(book);
        return book;
    }

    @GetMapping("/books")
    public List<Book> list() {
        return bookService.list();
    }

    @PostMapping("/addToCart")
    public ShoppingCart addToCart(@NotNull Integer userId, Integer bookId, Integer quantity) {
        return bookService.addToCart(userId, bookId, quantity);
    }

}
