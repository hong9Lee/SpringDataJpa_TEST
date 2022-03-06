package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.Book;
import com.data.jpa.datajpa.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    @Query(value = "select b from Book b " +
            "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByNameRecently(@Param("name") String name,
                                  @Param("createdAt") LocalDateTime createdAt,
                                  @Param("updatedAt") LocalDateTime updatedAt);

//    @Query(value = "select b.name as name, b.category as category from Book b")
    @Query(value = "select new com.data.jpa.datajpa.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.data.jpa.datajpa.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);
}
