package com.springapi.springboottaskapp.domain.dto;

import com.springapi.springboottaskapp.domain.entity.TaskPriority;
import com.springapi.springboottaskapp.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
