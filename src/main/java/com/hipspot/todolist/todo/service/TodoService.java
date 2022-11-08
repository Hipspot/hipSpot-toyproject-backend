package com.hipspot.todolist.todo.service;

import com.hipspot.todolist.exception.NotExistTodoException;
import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.request.TodoPatchRequest;
import com.hipspot.todolist.todo.controller.dto.response.TodoListResponse;
import com.hipspot.todolist.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoListResponse getTodoList(){
        return TodoListResponse.from(this.todoRepository.findAll());
    }

    public TodoListResponse createTodo(TodoPatchRequest request) throws IOException {
        todoRepository.save(request.toEntity());
        return TodoListResponse.from(this.todoRepository.findAll());
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
    }

    public TodoListResponse updateTodo(Long id, TodoPatchRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setTitle(request.getTitle());
        todo.setContent(request.getContent());
        todo.setTag(request.getTag());
        todoRepository.save(todo);
        return TodoListResponse.from(this.todoRepository.findAll());
    }

    public TodoListResponse deleteTodo(Long id){
        todoRepository.deleteById(id);
        return TodoListResponse.from(this.todoRepository.findAll());
    }

    @Transactional
    public TodoListResponse toggleTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setIsComplete(!todo.getIsComplete());
        return TodoListResponse.from(this.todoRepository.findAll());
    }

}
