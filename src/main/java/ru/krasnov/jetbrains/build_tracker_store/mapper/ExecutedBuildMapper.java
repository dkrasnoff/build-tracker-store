package ru.krasnov.jetbrains.build_tracker_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.krasnov.jetbrains.build_tracker_store.dao.entity.ExecutedBuild;
import ru.krasnov.jetbrains.build_tracker_store.dto.api.ExecutedBuildRequest;
import ru.krasnov.jetbrains.build_tracker_store.dto.service.ExecutedBuildDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExecutedBuildMapper {

    @Mapping(source = "request.requestedTaskNames", target = "requestedTaskNames", qualifiedByName = "mapRequestedTaskNames")
    ExecutedBuildDto mapFromSaveRequestToServiceLayer(ExecutedBuildRequest request, String host);

    @Named("mapRequestedTaskNames")
    default String mapRequestedTaskNames(List<String> requestedTaskNames) {
        return String.join(" ", requestedTaskNames);
    }

    ExecutedBuild mapToEntity(ExecutedBuildDto executedBuildDto);
}
