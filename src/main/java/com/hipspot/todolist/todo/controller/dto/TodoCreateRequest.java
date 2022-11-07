package com.hipspot.todolist.todo.controller.dto;

import com.hipspot.todolist.tag.Tag;
import com.hipspot.todolist.tag.TagEnum;
import com.hipspot.todolist.todo.Todo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TodoCreateRequest {

    @NotNull
    private String title;

    private String content;

    private List<TagEnum> tagList;

    public Todo toEntity() {
        Todo todo = new Todo(title, content);
        for(TagEnum tagName : tagList) {
            todo.addTag(new Tag(tagName));
        }
        return todo;
    }
}
