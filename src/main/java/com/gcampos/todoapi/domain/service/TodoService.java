package com.gcampos.todoapi.domain.service;

import com.gcampos.todoapi.domain.dto.TodoDTO;
import com.gcampos.todoapi.domain.model.Todo;
import com.gcampos.todoapi.domain.port.TodoRepositoryPort;
import com.gcampos.todoapi.domain.port.TodoServicePort;

import java.util.List;

public class TodoService implements TodoServicePort {

    private final TodoRepositoryPort todoRepositoryPort;

    public TodoService(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepositoryPort.findAll();
    }

    @Override
    public Todo create(TodoDTO todoDTO) {
        return todoRepositoryPort.create(todoDTO);
    }

    @Override
    public Todo update(TodoDTO todoDTO, Integer id) {
        return todoRepositoryPort.update(todoDTO);
    }

    @Override
    public void delete(Integer id) {
        todoRepositoryPort.delete(id);
    }
}
