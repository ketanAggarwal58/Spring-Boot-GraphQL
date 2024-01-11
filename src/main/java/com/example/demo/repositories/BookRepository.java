package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

}
