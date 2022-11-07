package com.hipspot.todolist.todo.controller;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.TodoCreateRequest;
import com.hipspot.todolist.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> getTodoList() {
        return ResponseEntity.ok().body(todoService.getTodoList());
    }

    @PostMapping("/todo")
    public ResponseEntity<List<Todo>> createTodoList(@RequestBody TodoCreateRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(request));
    }

//    @GetMapping("/todo")
//    public ResponseEntity<Todo> getTodo(@RequestParam() Integer id) {
//        return ResponseEntity.ok().body(todoService.getTodo);
//    }
//
//    @PostMapping("/todo")
//    public ResponseEntity<Todo> updateTodo(@RequestParam() Integer id) {
//        return ResponseEntity.ok().body(todoService.updateTodo());
//    }
//
//    @PostMapping("/todo")
//    public ResponseEntity<Todo> deleteTodo(@RequestParam() Integer id) {
//        return ResponseEntity.ok().body(todoService.deleteTodo());
//    }
//
//    @PostMapping("/todo")
//    public ResponseEntity<Todo> toggleTodo(@RequestParam() Integer id) {
//        return ResponseEntity.ok().body(todoService.toggleTodo());
//    }
}
