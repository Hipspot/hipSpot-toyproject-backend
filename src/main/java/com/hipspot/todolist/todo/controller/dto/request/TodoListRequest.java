package com.hipspot.todolist.todo.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hipspot.todolist.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListRequest {
    private List<Todo.TagEnum> tags;

    private LocalDate start;

    private LocalDate end;
}
