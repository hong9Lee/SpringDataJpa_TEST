package com.data.jpa.datajpa.service;

import com.data.jpa.datajpa.domain.Author;
import com.data.jpa.datajpa.domain.Book;
import com.data.jpa.datajpa.repository.AuthorRepository;
import com.data.jpa.datajpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);
    }


}
