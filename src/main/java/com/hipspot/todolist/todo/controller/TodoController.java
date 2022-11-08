package com.hipspot.todolist.todo.controller;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.request.TodoPatchRequest;
import com.hipspot.todolist.todo.controller.dto.response.TodoListResponse;
import com.hipspot.todolist.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<TodoListResponse> getTodoList() {
        return ResponseEntity.ok().body(todoService.getTodoList());
    }

    @PostMapping
    public ResponseEntity<TodoListResponse> createTodoList(@RequestBody TodoPatchRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.getTodo(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoListResponse> updateTodo(@PathVariable @Valid Long id, @RequestBody TodoPatchRequest request) {
        return ResponseEntity.ok().body(todoService.updateTodo(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoListResponse> deleteTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.deleteTodo(id));
    }

    @PatchMapping("/toggle/{id}")
    public ResponseEntity<TodoListResponse> toggleTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.toggleTodo(id));
    }
}
