package com.gcampos.todoapi.adapter.repository;

import com.gcampos.todoapi.adapter.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
}
