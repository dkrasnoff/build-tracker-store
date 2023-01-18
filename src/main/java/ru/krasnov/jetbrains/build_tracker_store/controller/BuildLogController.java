package ru.krasnov.jetbrains.build_tracker_store.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.krasnov.jetbrains.build_tracker_store.dto.api.ExecutedBuildRequest;
import ru.krasnov.jetbrains.build_tracker_store.mapper.ExecutedBuildMapper;
import ru.krasnov.jetbrains.build_tracker_store.service.BuildLogService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/build")
@Controller
@AllArgsConstructor
public class BuildLogController {

    private BuildLogService buildLogService;
    private ExecutedBuildMapper executedBuildMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExecutedBuild(@RequestBody ExecutedBuildRequest executedBuildRequest,
                                  HttpServletRequest req) {
        buildLogService.saveExecutedBuild(
                executedBuildMapper.mapFromSaveRequestToServiceLayer(executedBuildRequest, req.getRemoteHost()));
    }
}
