package ru.krasnov.jetbrains.build_tracker_store.dto.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecutedBuildDto {
    private UUID id;
    private String host;
    private String requestedTaskNames;
    private LocalDateTime buildStartTimestamp;
    private LocalDateTime buildEndTimestamp;
    private List<ExecutedTaskDto> executedTasks;

}
