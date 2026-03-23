package com.springapi.springboottaskapp.domain;

import java.time.LocalDate;
import com.springapi.springboottaskapp.domain.entity.TaskStatus;
import  com.springapi.springboottaskapp.domain.entity.TaskPriority;

public record UpdateTaskRequest(
    String title,
    String description,
    LocalDate dueDate,
    TaskStatus status,
    TaskPriority priority
) {

}
