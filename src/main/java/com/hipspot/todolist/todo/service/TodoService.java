package com.hipspot.todolist.todo.service;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.TodoCreateRequest;
import com.hipspot.todolist.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getTodoList(){
        return this.todoRepository.findAll();
    }

    public List<Todo> createTodo(TodoCreateRequest request) throws IOException {
        todoRepository.save(request.toEntity());
        return todoRepository.findAll();
    }

//    public Todo getTodo(String id) {
//        return todoRepository.findById();
//    }
//
//    public List<Todo> updateTodo() {
//        return todoRepository.findAll();
//    }
//
//    public List<Todo> deleteTodo(){
//        return todoRepository.findAll();
//    }
//
//    public List<Todo> toggleTodo(){
//        return todoRepository.findAll();
//    }


}
