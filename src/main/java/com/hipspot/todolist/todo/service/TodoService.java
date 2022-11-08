package com.hipspot.todolist.todo.service;

import com.hipspot.todolist.exception.NotExistTodoException;
import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.request.TodoCreateRequest;
import com.hipspot.todolist.todo.controller.dto.request.TodoUpdateRequest;
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

    public List<Todo> getTodoList(){
        return this.todoRepository.findAll();
    }

    public List<Todo> createTodo(TodoCreateRequest request) throws IOException {
        todoRepository.save(request.toEntity());
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
    }

    public List<Todo> updateTodo(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setTitle(request.getTitle());
        todo.setContent(request.getContent());
        todo.setTag(request.getTag());
        todoRepository.save(todo);
        return todoRepository.findAll();
    }

    public List<Todo> deleteTodo(Long id){
        todoRepository.deleteById(id);
        return todoRepository.findAll();
    }

    @Transactional
    public List<Todo> toggleTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setIsComplete(!todo.getIsComplete());
        return todoRepository.findAll();
    }

}
