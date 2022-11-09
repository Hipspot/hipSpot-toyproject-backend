package com.hipspot.todolist.todo.controller.dto.response;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.controller.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListResponse {
    private int count;

    private List<TodoDto> todoList;

    public static TodoListResponse from(List<TodoDto> todoList) {
        return new TodoListResponse(todoList.size(), todoList);
    }
}
