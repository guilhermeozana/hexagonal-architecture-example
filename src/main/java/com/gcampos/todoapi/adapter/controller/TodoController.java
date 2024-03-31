package com.gcampos.todoapi.adapter.controller;

import com.gcampos.todoapi.domain.dto.TodoDTO;
import com.gcampos.todoapi.domain.model.Todo;
import com.gcampos.todoapi.domain.port.TodoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoServicePort todoServicePort;

    @GetMapping
    ResponseEntity<List<Todo>> findAll(@RequestBody TodoDTO todoDTO) {
        List<Todo> todoList = todoServicePort.findAll();

        return ResponseEntity
                .ok(todoList);
    }

    @PostMapping
    ResponseEntity<Todo> create(@RequestBody TodoDTO todoDTO) throws URISyntaxException {
        Todo todo = todoServicePort.create(todoDTO);
        return ResponseEntity
                .created(new URI("/todos/"+ todo.getId().toString())).body(todo);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> update(@PathVariable("id") Integer id, @RequestBody TodoDTO todoDTO){
        Todo todo = todoServicePort.update(todoDTO, id);
        return ResponseEntity
                .ok(todo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Integer id){
        todoServicePort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
