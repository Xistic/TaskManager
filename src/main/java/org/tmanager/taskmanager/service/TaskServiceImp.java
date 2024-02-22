package org.tmanager.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmanager.taskmanager.model.Task;
import org.tmanager.taskmanager.model.TaskStatus;
import org.tmanager.taskmanager.repo.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);

        if (existingTask != null){
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDateTime(task.getDueDateTime());
            existingTask.setCompleted(task.isCompleted());

            return taskRepository.save(existingTask);
        }
        return null;
    }


    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
