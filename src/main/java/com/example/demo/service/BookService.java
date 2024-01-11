package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Books;

public interface BookService {
    // Create a Book
    Books create(Books book);

    // Get All Books
    List<Books> getAll();

    // Get Single Book
    Books get(int bookId);
}
