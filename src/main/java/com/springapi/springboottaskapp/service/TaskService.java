package com.springapi.springboottaskapp.service;

import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.dto.UpdateTaskRequestDto;
import com.springapi.springboottaskapp.domain.entity.Tasks;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Tasks createTask(CreateTaskRequest request);

    List<Tasks> getAllTasks();

    Tasks updateTask(UUID taskId, UpdateTaskRequestDto request);

}
