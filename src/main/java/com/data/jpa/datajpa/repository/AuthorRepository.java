package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
