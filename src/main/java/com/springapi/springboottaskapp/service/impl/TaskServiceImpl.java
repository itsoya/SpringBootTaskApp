package com.springapi.springboottaskapp.service.impl;

import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.dto.UpdateTaskRequestDto;
import com.springapi.springboottaskapp.domain.entity.Tasks;
import com.springapi.springboottaskapp.domain.entity.TaskStatus;
import com.springapi.springboottaskapp.exception.TaskNotFoundException;
import com.springapi.springboottaskapp.repository.TaskRepository;
import com.springapi.springboottaskapp.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Tasks createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Tasks task = new Tasks(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
        return taskRepository.save(task);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Tasks updateTask(UUID taskId,UpdateTaskRequestDto request) {
        Tasks task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority());
        task.setStatus(TaskStatus.OPEN);
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
    }
}
