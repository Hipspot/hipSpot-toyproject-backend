package com.hipspot.todolist;

import com.hipspot.todolist.tag.Tag;
import com.hipspot.todolist.tag.TagEnum;
import com.hipspot.todolist.tag.repository.TagRepository;
import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TagRepository tagRepository;

    @Test
    void testJpa() {
        Todo todo1 = new Todo();
        todo1.setContent("밥먹기");
        todo1.setCompleted(Boolean.TRUE);
        todo1.setContent("hi");
        todo1.setTitle("titile");
        this.todoRepository.save(todo1);
        Tag tag1 = new Tag();
        tag1.setId(todo1.getId());
        tag1.setTagName(TagEnum.fe);
        this.tagRepository.save(tag1);
    }

}
