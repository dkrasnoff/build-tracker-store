package ru.krasnov.jetbrains.build_tracker_store.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.krasnov.jetbrains.build_tracker_store.dao.entity.ExecutedTask;

import java.util.List;
import java.util.UUID;

public interface ExecutedTaskRepository extends JpaRepository<ExecutedTask, UUID> {

    List<ExecutedTask> findByBuildIdOrderByExecutionStartTimestampAsc(UUID buildId);
}
