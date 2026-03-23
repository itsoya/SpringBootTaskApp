package com.springapi.springboottaskapp.controller;
import com.springapi.springboottaskapp.domain.CreateTaskRequest;
import com.springapi.springboottaskapp.domain.dto.CreateTaskRequestDto;
import com.springapi.springboottaskapp.domain.dto.TaskDto;
import com.springapi.springboottaskapp.domain.entity.Tasks;
import com.springapi.springboottaskapp.mapper.TaskMapper;
import com.springapi.springboottaskapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> getAllTasks(
       @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Tasks task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Tasks> tasks = taskService.getAllTasks();
        List<TaskDto> tasksDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(tasksDtos);
    }
}
