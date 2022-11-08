package com.hipspot.todolist.exception;

public class NotExistTodoException extends RuntimeException{
    private static final String MESSAGE = "존재하지 않는 투두입니다.";

    public NotExistTodoException() {
        super(MESSAGE);
    }
}
