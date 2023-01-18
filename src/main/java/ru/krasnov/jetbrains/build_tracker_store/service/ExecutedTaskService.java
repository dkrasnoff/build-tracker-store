package ru.krasnov.jetbrains.build_tracker_store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.krasnov.jetbrains.build_tracker_store.dao.repository.ExecutedTaskRepository;
import ru.krasnov.jetbrains.build_tracker_store.dto.service.ExecutedTaskDto;
import ru.krasnov.jetbrains.build_tracker_store.mapper.ExecutedTaskMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExecutedTaskService {

    private final ExecutedTaskRepository executedTaskRepository;
    private final ExecutedTaskMapper executedTaskMapper;

    @Transactional(readOnly = true)
    public List<ExecutedTaskDto> findAllByBuildId(UUID buildId) {
        return executedTaskMapper.mapToServiceDtoList(
                executedTaskRepository.findByBuildIdOrderByExecutionStartTimestampAsc(buildId));
    }
}
