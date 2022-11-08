package com.hipspot.todolist.todo.repository;

import com.hipspot.todolist.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
