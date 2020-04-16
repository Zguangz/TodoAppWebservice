package com.app.todowebservice.service;

import com.app.todowebservice.dto.Todo;

import java.util.List;

public interface TodoHardCodedService {

    List<Todo> findAll();

    Todo deleteById(long id);

    Todo findById(long id);

    Todo save(Todo todo);
}
