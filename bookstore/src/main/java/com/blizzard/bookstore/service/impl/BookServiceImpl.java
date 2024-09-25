package com.blizzard.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blizzard.bookstore.entity.Book;
import com.blizzard.bookstore.entity.CartItem;
import com.blizzard.bookstore.entity.ShoppingCart;
import com.blizzard.bookstore.mapper.BookMapper;
import com.blizzard.bookstore.mapper.CartItemMapper;
import com.blizzard.bookstore.mapper.ShoppingCartMapper;
import com.blizzard.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CartItemMapper cartItemMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    public List<Book> list() {
        return this.bookMapper.selectList(null);
    }

    public Book getById(int id) {
        Book book = this.bookMapper.selectById(id);
        return book;
    }

    public boolean add(Book book) {
        return this.bookMapper.insert(book) != 0;
    }

    public boolean delete(int id) {
        return this.bookMapper.deleteById(id) != 0;
    }

    public ShoppingCart addToCart(int userId, int bookId, int quantity) {
        ShoppingCart cart = this.shoppingCartMapper.selectByUserId(userId);
        // if the user doesn't have a cart
        if (cart == null) {
            cart = new ShoppingCart();
            cart.setUserId(userId);
            shoppingCartMapper.insert(cart);
        } else {
            // user has a cart with the same item
            if (cart.getCartItems().stream().mapToInt(item -> item.getBook().getId()).anyMatch(id -> id == bookId)) {
                LambdaUpdateWrapper<CartItem> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper.eq(CartItem::getId, userId)
                        .setSql("quantity = quantity + " + quantity);
                cartItemMapper.update(updateWrapper);
            } else {
                // user has a cart without the same item
                CartItem item = new CartItem();
                Book book = bookMapper.selectById(bookId);
                item.setBook(book);
                item.setQuantity(quantity);
                item.setShoppingCartId(cart.getId());
                cartItemMapper.addCartItem(item);
            }
            cart = shoppingCartMapper.selectByUserId(userId);
        }
        return cart;
    }
}
