package com.hipspot.todolist.tag;

import com.hipspot.todolist.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Todo todo;

    private TagEnum tagName;

    public Tag(TagEnum tagName) {
        this.id = UUID.randomUUID().toString();
        this.tagName = tagName;
    }

    public Tag() {

    }
}
