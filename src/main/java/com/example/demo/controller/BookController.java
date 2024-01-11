package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.service.BookService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Create a Book
    @MutationMapping("createBook")
    public Books create(@Argument BookInput book) {
        Books bok = new Books();
        bok.setTitle(book.getTitle());
        bok.setDescp(book.getDesc());
        bok.setAuthor(book.getAuthor());
        bok.setPages(book.getPages());
        bok.setPrice(book.getPrice());
        return this.bookService.create(bok);
    }

    // Get All Books
    @QueryMapping("allBooks")
    public List<Books> getAll() {
        return this.bookService.getAll();
    }

    // Get Single Book
    @QueryMapping("getBook")
    public Books get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

}

@Getter
@Setter
class BookInput {
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
