package com.hipspot.todolist.todo.controller.dto.response;

import com.hipspot.todolist.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListResponse {
    private int count;

    private List<TodoDto> todoList;

    public static TodoListResponse from(List<Todo> todoList) {
        List<TodoDto> todoDtoList = new ArrayList<>();
        for(Todo todo: todoList) {
            todoDtoList.add(TodoDto.from(todo));
        }
        return new TodoListResponse(todoDtoList.size(), todoDtoList);
    }
}
