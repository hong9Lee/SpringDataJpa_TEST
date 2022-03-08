package com.data.jpa.datajpa.repository;

import com.data.jpa.datajpa.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
