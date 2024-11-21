package com.tasklistener.listener.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasklistener.listener.model.Task;
import com.tasklistener.listener.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(String message) throws JsonProcessingException {
        Task task = objectMapper.readValue(message, Task.class);
        taskRepository.save(task);
    }
}
