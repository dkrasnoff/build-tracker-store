package ru.krasnov.jetbrains.build_tracker_store.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.krasnov.jetbrains.build_tracker_store.service.ExecutedTaskService;

import java.util.UUID;

@RequestMapping("/task")
@Controller
@AllArgsConstructor
public class ExecutedTaskController {

    private final ExecutedTaskService executedTaskService;

    @GetMapping("/{buildId}")
    public String findAllForBuild(@PathVariable UUID buildId, Model model) {
        model.addAttribute("executedTasks",
                executedTaskService.findAllByBuildId(buildId));
        model.addAttribute("buildId", buildId);
        return "executedTasks";
    }
}
