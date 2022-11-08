package com.hipspot.todolist.todo.controller.dto.request;

import com.hipspot.todolist.todo.TagEnum;
import com.hipspot.todolist.todo.Todo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoCreateRequest {

    @NotNull
    private String title;

    private String content;

    private TagEnum tag;

    public Todo toEntity() {
        Todo todo = new Todo(title, content, tag);
        return todo;
    }
}
