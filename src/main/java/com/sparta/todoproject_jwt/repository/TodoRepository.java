package com.sparta.todoproject_jwt.repository;

import com.sparta.todoproject_jwt.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
