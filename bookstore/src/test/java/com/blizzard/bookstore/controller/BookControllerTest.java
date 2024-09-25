package com.blizzard.bookstore.controller;

import com.blizzard.bookstore.BookstoreApplication;
import com.blizzard.bookstore.entity.Book;
import com.blizzard.bookstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BookstoreApplication.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void setUp() throws Exception{
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setPrice(9.9);
        b1.setTitle("title1");
        b1.setAuthor("author1");
        b1.setCategory("category1");
        books.add(b1);
        Book b2 = new Book();
        b2.setId(2);
        b2.setPrice(9.9);
        b2.setTitle("title2");
        b2.setAuthor("author2");
        b2.setCategory("category2");
        books.add(b2);
        Mockito.when(bookService.list()).thenReturn(books);
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

}
