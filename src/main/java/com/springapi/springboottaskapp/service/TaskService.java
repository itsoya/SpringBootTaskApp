package com.springapi.springboottaskapp.service;

import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.entity.Tasks;

import java.util.List;

public interface TaskService {

    Tasks createTask(CreateTaskRequest request);

    List<Tasks> getAllTasks();

}
