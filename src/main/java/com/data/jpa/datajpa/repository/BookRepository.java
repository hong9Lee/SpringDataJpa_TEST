package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
