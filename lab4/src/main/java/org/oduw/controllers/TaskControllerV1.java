package org.oduw.controllers;

import lombok.RequiredArgsConstructor;
import org.oduw.models.Task;
import org.oduw.services.TaskService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskControllerV1 {

    private final TaskService taskService;

    @QueryMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @QueryMapping
    public Task getTaskById(@Argument Long id) {
        return taskService.getById(id);
    }

    @MutationMapping
    public Task addTask(
            @Argument String name,
            @Argument String description,
            @Argument String color,
            @Argument String author
    ) {
        return taskService.addTask(name, description, color, author);
    }

    @MutationMapping
    public Task updateTask(
            @Argument Long id,
            @Argument String name,
            @Argument String description,
            @Argument String color,
            @Argument String author
    ) {
        return taskService.updateTask(id, name, description, color, author);
    }
}
