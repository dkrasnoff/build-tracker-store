package ru.krasnov.jetbrains.build_tracker_store.dto.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecutedTaskDto {
    private UUID id;
    private String name;
    private LocalDateTime executionStartTimestamp;
    private LocalDateTime executionEndTimestamp;
}
