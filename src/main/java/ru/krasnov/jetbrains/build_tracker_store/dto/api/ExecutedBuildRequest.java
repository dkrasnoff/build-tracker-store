package ru.krasnov.jetbrains.build_tracker_store.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecutedBuildRequest {

    private List<String> requestedTaskNames;
    private LocalDateTime buildStartTimestamp;
    private LocalDateTime buildEndTimestamp;
    private List<ExecutedTask> executedTasks;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ExecutedTask {
        private String name;
        private LocalDateTime executionStartTimestamp;
        private LocalDateTime executionEndTimestamp;
    }
}
