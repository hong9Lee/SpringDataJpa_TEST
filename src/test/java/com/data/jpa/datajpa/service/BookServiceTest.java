package com.data.jpa.datajpa.service;

import com.data.jpa.datajpa.domain.Book;
import com.data.jpa.datajpa.repository.AuthorRepository;
import com.data.jpa.datajpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Test()
    void transactionTest() {
        try {
            bookService.putBookAndAuthor();
        } catch (RuntimeException e) {
            System.out.println(">>>" + e.getMessage());
        }


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("Jpa 강의");

        bookRepository.save(book);

        bookService.get(1L);
        System.out.println(">>>>>>>>1" + bookRepository.findAll());
    }

    @Test
    void converterErrorTest() {
        bookService.getAll();

        bookRepository.findAll().forEach(System.out::println);
    }

}
