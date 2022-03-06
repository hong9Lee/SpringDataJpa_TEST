package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.Book;
import com.data.jpa.datajpa.domain.Publisher;
import com.data.jpa.datajpa.domain.Review;
import com.data.jpa.datajpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthor("패스트캠퍼스");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);


        bookRepository.save(book);

        System.out.println("bookRepository = " + bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }

//    @Transactional
    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
//        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");
//        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        bookRepository.save(book);

//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우캠퍼스");
        bookRepository.save(book1);

        System.out.println("publisher : " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);


        Book book3 = bookRepository.findById(1L).get();
        book.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3 - publisher -->" + bookRepository.findById(1L).get().getPublisher());

    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
//        System.out.println(bookRepository.findById(3L));


//        bookRepository.findByCategoryNull().forEach(System.out::println);
//        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
        bookRepository.findAll().forEach(System.out::println);
    }


    @Test
    void queryTest() {
        System.out.println(bookRepository.findByNameRecently("JPA 초격차 패키지",
                LocalDateTime.now().minusDays(1L),
                LocalDateTime.now().minusDays(1L)));

//        System.out.println(bookRepository.findBookNameAndCategory());
//        bookRepository.findBookNameAndCategory().forEach(b -> {
//            System.out.println(b.getName() + " : " + b.getCategory());
//        });

        bookRepository.findBookNameAndCategory(PageRequest.of(0, 1)).forEach(b -> {
            System.out.println(b.getCategory() + " : " +  b.getName());
        });
    }


    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");
        return publisherRepository.save(publisher);
    }

    private User givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이였어요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);

    }


}
