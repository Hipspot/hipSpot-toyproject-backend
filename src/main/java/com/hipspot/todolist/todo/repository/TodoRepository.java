package com.hipspot.todolist.todo.repository;

import com.hipspot.todolist.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByModifiedDateBetween(LocalDate start, LocalDate end);
}
