package com.gcampos.todoapi.adapter.repository;

import com.gcampos.todoapi.adapter.entity.TodoEntity;
import com.gcampos.todoapi.domain.dto.TodoDTO;
import com.gcampos.todoapi.domain.model.Todo;
import com.gcampos.todoapi.domain.port.TodoRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoRepositoryAdapter implements TodoRepositoryPort {

    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Todo> findAll() {
        List<TodoEntity> todoEntityList = todoRepository.findAll();

        return todoEntityList.stream()
                    .map(todoEntity -> modelMapper.map(todoEntity, Todo.class))
                    .collect(Collectors.toList());
    }

    @Override
    public Todo create(TodoDTO todoDTO) {
        TodoEntity todoEntity = todoRepository.save(modelMapper.map(todoDTO, TodoEntity.class));

        return modelMapper.map(todoEntity, Todo.class);
    }

    @Override
    public Todo update(TodoDTO todoDTO) {
        TodoEntity todoSaved = todoRepository.findById(todoDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Todo not found"));

        BeanUtils.copyProperties(todoDTO, todoSaved);

        TodoEntity todoUpdated = todoRepository.save(todoSaved);

        return modelMapper.map(todoUpdated, Todo.class);
    }

    @Override
    public void delete(Integer id) {
        TodoEntity todoSaved = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found"));

        todoRepository.delete(todoSaved);
    }
}
