package com.hipspot.todolist.todo;

import com.hipspot.todolist.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String content;

    private String title;

    private boolean completed;

    @OneToMany(
            mappedBy = "todo",
            orphanRemoval = true
    )
    private List<Tag> tags = new ArrayList<>();

    public Todo() {

    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.setTodo(this);
    }

    public Todo(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.completed = Boolean.FALSE;
    }
}
