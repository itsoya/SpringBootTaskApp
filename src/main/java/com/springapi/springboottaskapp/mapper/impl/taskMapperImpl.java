package com.springapi.springboottaskapp.mapper.impl;

import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.dto.CreateTaskRequestDto;
import com.springapi.springboottaskapp.domain.dto.TaskDto;
import com.springapi.springboottaskapp.domain.dto.UpdateTaskRequestDto;
import com.springapi.springboottaskapp.domain.entity.Tasks;
import com.springapi.springboottaskapp.mapper.TaskMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class taskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(@Valid CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequestDto fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequestDto(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority(),
                dto.status()
        );
    }

    @Override
    public TaskDto toDto(Tasks task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
