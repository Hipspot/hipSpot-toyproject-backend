package com.hipspot.todolist.todo.controller.dto.request;

import com.hipspot.todolist.todo.Todo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoPatchRequest {

    @NotNull
    private String title;

    private String content;

    private Todo.TagEnum tag;

    public Todo toEntity() {
        Todo todo = new Todo(title, content, tag);
        return todo;
    }
}
