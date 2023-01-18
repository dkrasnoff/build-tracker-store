package ru.krasnov.jetbrains.build_tracker_store.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.krasnov.jetbrains.build_tracker_store.dao.entity.ExecutedTask;
import ru.krasnov.jetbrains.build_tracker_store.dao.repository.ExecutedBuildRepository;
import ru.krasnov.jetbrains.build_tracker_store.dto.service.ExecutedBuildDto;
import ru.krasnov.jetbrains.build_tracker_store.mapper.ExecutedBuildMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class ExecutedBuildService {

    private final ExecutedBuildRepository executedBuildRepository;
    private final ExecutedBuildMapper executedBuildMapper;

    @Transactional
    public void saveExecutedBuild(ExecutedBuildDto executedBuildDto) {
        final var executedBuild = executedBuildMapper.mapToEntity(executedBuildDto);
        for (ExecutedTask executedTask : executedBuild.getExecutedTasks()) {
            executedTask.setBuild(executedBuild);
        }
        executedBuildRepository.save(executedBuild);
    }

    @Transactional(readOnly = true)
    public List<ExecutedBuildDto> findAll() {
        return executedBuildMapper.mapToServiceDtoList(
                executedBuildRepository.findAll(Sort.by(Sort.Order.desc("buildStartTimestamp"))));
    }
}
