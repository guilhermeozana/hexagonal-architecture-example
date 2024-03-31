package com.gcampos.todoapi.domain.port;

import com.gcampos.todoapi.domain.dto.TodoDTO;
import com.gcampos.todoapi.domain.model.Todo;

import java.util.List;

public interface TodoServicePort {

    List<Todo> findAll();

    Todo create(TodoDTO todoDTO);


    Todo update(TodoDTO todoDTO, Integer id);

    void delete(Integer id);
}
