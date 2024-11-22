package com.tasklistener.listener.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tasklistener.listener.custom.UserConsumerCustom;
import com.tasklistener.listener.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class UserConsumerListerner {
    private final UserService userService;

    @UserConsumerCustom(groupId = "group-1")
    public void createUser(String message) throws JsonProcessingException {
        userService.createUser(message);
        log.info("Create ::: Usuário criado com sucesso");
    }

    @UserConsumerCustom(groupId = "group-1", topics = "userUpdate-topic")
    public void updateUser(String message) throws JsonProcessingException {
        userService.updateUser(message);
        log.info("Update ::: Usuário atualizado com sucesso");
    }

    @UserConsumerCustom(groupId = "group-1", topics = "userDelete-topic")
    public void deleteUser(String message) {
        userService.deleteUser(Integer.valueOf(message));
        log.info("Delete ::: Usuário deletado com sucesso");
    }
}