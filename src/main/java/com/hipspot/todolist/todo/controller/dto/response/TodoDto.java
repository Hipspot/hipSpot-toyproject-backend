package com.hipspot.todolist.todo.controller.dto.response;

import com.hipspot.todolist.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoDto {
    private Long id;

    private String title;

    private String content;

    private Boolean isComplete;

    private Todo.TagEnum tag;

    public static TodoDto from(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getIsComplete(),
                todo.getTag()
        );
    }
}
