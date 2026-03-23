package com.springapi.springboottaskapp.domain.dto;

import com.springapi.springboottaskapp.domain.entity.TaskPriority;
import com.springapi.springboottaskapp.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH) @Length(max = 255,message = ERROR_MESSAGE_TITLE_LENGTH) String title,
        @Length(max = 100, message = ERROR_MESSAGE_DESCRIPTION_LENGTH) @Nullable String description,
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE_FUTURE )@Nullable LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY_LENGTH) TaskPriority priority,
        @NotNull(message = ERROR_MESSAGE_STATUS_LENGTH) TaskStatus taskStatus
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title length must be between 1 and 255.";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = "Description must be less than 1000 characters";
    private static final String ERROR_MESSAGE_DUE_DATE_FUTURE = "Due date must be in the future.";
    private static final String ERROR_MESSAGE_PRIORITY_LENGTH = "Priority must be between 1 and 1000 characters";
    private static final String ERROR_MESSAGE_STATUS_LENGTH = "Status must be between 1 and 1000 characters";

}
