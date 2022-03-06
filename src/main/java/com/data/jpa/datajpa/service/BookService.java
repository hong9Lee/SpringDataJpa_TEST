package com.data.jpa.datajpa.service;

import com.data.jpa.datajpa.domain.Author;
import com.data.jpa.datajpa.domain.Book;
import com.data.jpa.datajpa.repository.AuthorRepository;
import com.data.jpa.datajpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final EntityManager entityManager;
    private final AuthorService authorService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA 시작하기");
        bookRepository.save(book);

        try {
            authorService.putAuthor();
        } catch (RuntimeException e) {
        }


        throw new RuntimeException("오류가 발생. transaction?");


//        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않았습니다.");
//        throw new Exception("오류가 나서 DB commit이 발생하지 않았습니다.");
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void get(Long id) {
        System.out.println(" >>>>> " + bookRepository.findById(id));
        System.out.println(" >>>>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println("bookRepository = " + bookRepository.findById(id));
        System.out.println(" >>>>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();

    }

}
