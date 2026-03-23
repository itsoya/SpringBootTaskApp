package com.springapi.springboottaskapp.mapper;

import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.dto.CreateTaskRequestDto;
import com.springapi.springboottaskapp.domain.dto.TaskDto;
import com.springapi.springboottaskapp.domain.entity.Tasks;
import jakarta.validation.Valid;

public interface TaskMapper {
    CreateTaskRequest fromDto(@Valid CreateTaskRequestDto dto);

    TaskDto toDto(Tasks task);
}
