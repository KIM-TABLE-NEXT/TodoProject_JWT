package com.sparta.todoproject_jwt.repository;

import com.sparta.todoproject_jwt.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
