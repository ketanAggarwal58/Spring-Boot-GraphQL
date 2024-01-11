package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.repositories.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Books create(Books book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Books> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Books get(int bookId) {
        return this.bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book you are looking for is not available right now"));
    }

}
