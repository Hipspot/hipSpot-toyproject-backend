package com.hipspot.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void testJpa() {
        Todo todo1 = new Todo("마라탕", "맛있음", Todo.TagEnum.be);

        Todo savedTodo = this.todoRepository.save(todo1);

        assertThat(savedTodo.getId()).isEqualTo(todo1.getId());
    }

}
