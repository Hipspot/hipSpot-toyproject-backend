package com.hipspot.todolist.todo.controller;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.request.TodoCreateRequest;
import com.hipspot.todolist.todo.controller.dto.request.TodoUpdateRequest;
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
    public ResponseEntity<List<Todo>> getTodoList() {
        return ResponseEntity.ok().body(todoService.getTodoList());
    }

    @PostMapping
    public ResponseEntity<List<Todo>> createTodoList(@RequestBody TodoCreateRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.getTodo(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<List<Todo>> updateTodo(@PathVariable @Valid Long id, @RequestBody TodoUpdateRequest request) {
        return ResponseEntity.ok().body(todoService.updateTodo(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Todo>> deleteTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.deleteTodo(id));
    }

    @PatchMapping("/toggle/{id}")
    public ResponseEntity<List<Todo>> toggleTodo(@PathVariable @Valid Long id) {
        return ResponseEntity.ok().body(todoService.toggleTodo(id));
    }
}
