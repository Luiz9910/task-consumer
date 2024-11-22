package com.tasklistener.listener.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tasklistener.listener.custom.TaskConsumerCustom;
import com.tasklistener.listener.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class TaskConsumerListerner {
    private final TaskService taskService;

    @TaskConsumerCustom(groupId = "group-1")
    public void createTask(String message) throws JsonProcessingException {
        taskService.createTask(message);
        log.info("Create ::: Task criada com sucesso");
    }

    @TaskConsumerCustom(groupId = "group-1", topics = "taskUpdate-topic")
    public void updateTask(String message) throws JsonProcessingException {
        taskService.updateTask(message);
        log.info("Update ::: Task atualizada com sucesso");
    }

    @TaskConsumerCustom(groupId = "group-1", topics = "taskDelete-topic")
    public void deleteTask(String message) {
        taskService.deleteUser(Integer.valueOf(message));
        log.info("Delete ::: Task deletada com sucesso");
    }
}