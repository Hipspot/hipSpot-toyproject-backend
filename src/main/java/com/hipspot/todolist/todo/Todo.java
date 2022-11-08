package com.hipspot.todolist.todo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Boolean isComplete;

    @Enumerated(EnumType.STRING)
    private TagEnum tag;

    public Todo() {

    }

    public Todo(String title, String content, TagEnum tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.isComplete = Boolean.FALSE;
    }

    public enum TagEnum {
        all, pm, design, fe, be, mobile
    }
}
