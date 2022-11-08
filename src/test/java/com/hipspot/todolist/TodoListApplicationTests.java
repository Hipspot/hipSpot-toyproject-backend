package com.hipspot.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import com.hipspot.todolist.todo.TagEnum;
import com.hipspot.todolist.todo.Todo;
import com.hipspot.todolist.todo.repository.TodoRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void testJpa() {
        Todo todo1 = new Todo("마라탕", "맛있음", TagEnum.be);
        Todo todo2 = new Todo("마라탕1", "맛없음",TagEnum.fe);
        Todo todo3 = new Todo("마라탕2", "맛웂음",TagEnum.mobile);
        Todo todo4 = new Todo("마라탕3", "맛옶음",TagEnum.fe);

        this.todoRepository.save(todo1);
        this.todoRepository.save(todo2);
        this.todoRepository.save(todo3);
        this.todoRepository.save(todo4);

        // 리스트 확인
        List<Todo> all = todoRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(1);
        assertThat(all.get(1).getId()).isEqualTo(2);
        assertThat(all.get(2).getId()).isEqualTo(3);

    }

}
