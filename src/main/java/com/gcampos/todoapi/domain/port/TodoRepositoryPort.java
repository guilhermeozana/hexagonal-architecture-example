package com.gcampos.todoapi.domain.port;

import com.gcampos.todoapi.domain.dto.TodoDTO;
import com.gcampos.todoapi.domain.model.Todo;

import java.util.List;

public interface TodoRepositoryPort {

    List<Todo> findAll();

    Todo create(TodoDTO todo);

    Todo update(TodoDTO todoDTO);

    void delete(Integer id);
}
