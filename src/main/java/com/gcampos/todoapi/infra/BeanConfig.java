package com.gcampos.todoapi.infra;

import com.gcampos.todoapi.domain.port.TodoRepositoryPort;
import com.gcampos.todoapi.domain.port.TodoServicePort;
import com.gcampos.todoapi.domain.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TodoServicePort todoServicePort(TodoRepositoryPort todoRepositoryPort) {
        return new TodoService(todoRepositoryPort);
    }
}
