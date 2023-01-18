package ru.krasnov.jetbrains.build_tracker_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.krasnov.jetbrains.build_tracker_store.dao.entity.ExecutedTask;
import ru.krasnov.jetbrains.build_tracker_store.dto.service.ExecutedTaskDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExecutedTaskMapper {

    List<ExecutedTaskDto> mapToServiceDtoList(List<ExecutedTask> executedTasks);
}
