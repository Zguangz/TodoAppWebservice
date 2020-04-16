package com.app.todowebservice.service;

import com.app.todowebservice.dto.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
class TodoHardCodedServiceImpl implements TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "zguang", "Learn React", new Date(), false));
        todos.add(new Todo(++idCounter, "zguang", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "zguang", "Learn Full Stack Development", new Date(), false));
        todos.add(new Todo(++idCounter, "zguang", "Learn IBM MQ", new Date(), false));
        todos.add(new Todo(++idCounter, "zguang", "Learn Microservices", new Date(), false));
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        todos.remove(todo);
        return todo;
    }

    @Override
    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0 ) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }


}
