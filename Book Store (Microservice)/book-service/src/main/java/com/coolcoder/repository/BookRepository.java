package com.coolcoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coolcoder.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}