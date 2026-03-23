package com.springapi.springboottaskapp.repository;

import com.springapi.springboottaskapp.domain.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, UUID> {

}
