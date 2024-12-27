package org.oduw.services;

import lombok.RequiredArgsConstructor;
import org.oduw.models.Task;
import org.oduw.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found!"));
    }

    public Task addTask(
            String name,
            String description,
            String color,
            String author
    ) {
        Task task = Task.builder()
                .name(name)
                .description(description)
                .color(color)
                .author(author)
                .isChecked(false)
                .build();

        return taskRepository.save(task);
    }

    public Task updateTask(
            Long id,
            String name,
            String description,
            String color,
            String author
    ) {
        Task task = getById(id);
        task.setName(name);
        task.setDescription(description);
        task.setAuthor(author);
        task.setColor(color);

        return taskRepository.save(task);
    }
}
