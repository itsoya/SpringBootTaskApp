package com.springapi.springboottaskapp.domain;

import com.springapi.springboottaskapp.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {

}
