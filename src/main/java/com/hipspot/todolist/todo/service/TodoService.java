package com.hipspot.todolist.todo.service;

import com.hipspot.todolist.exception.NotExistTodoException;
import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.TodoDto;
import com.hipspot.todolist.todo.controller.dto.request.TodoListRequest;
import com.hipspot.todolist.todo.controller.dto.request.TodoPatchRequest;
import com.hipspot.todolist.todo.controller.dto.response.TodoListResponse;
import com.hipspot.todolist.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoListResponse getTodoList(TodoListRequest request){
        List<Todo> todoList;

        if(request == null) return TodoListResponse.from(this.todoRepository.findAll().stream().map(TodoDto::from).toList());

        if(request.getStart() != null && request.getEnd() != null)
            todoList = this.todoRepository.findAllByModifiedDateBetween(request.getStart(), request.getEnd());
        else
            todoList = this.todoRepository.findAll();

        //태그 검사
        if(request.getTags() != null && !request.getTags().contains(Todo.TagEnum.all))
            todoList =  todoList.stream().filter(todo -> request.getTags().contains(todo.getTag())).toList();

        return TodoListResponse.from(todoList.stream().map(TodoDto::from).toList());
    }

    public TodoDto createTodo(TodoPatchRequest request) throws IOException {
        return TodoDto.from(todoRepository.save(request.toEntity()));
    }

    public TodoDto getTodo(Long id) {
        return TodoDto.from(todoRepository.findById(id).orElseThrow(NotExistTodoException::new));
    }

    public TodoDto updateTodo(Long id, TodoPatchRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setTitle(request.getTitle());
        todo.setContent(request.getContent());
        todo.setTag(request.getTag());
        return TodoDto.from(todoRepository.save(todo));
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    @Transactional
    public TodoDto toggleTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistTodoException::new);
        todo.setIsComplete(!todo.getIsComplete());
        return TodoDto.from(todo);
    }

}
