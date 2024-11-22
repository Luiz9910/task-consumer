package com.tasklistener.listener.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasklistener.listener.model.Task;
import com.tasklistener.listener.model.User;
import com.tasklistener.listener.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void createUser(String message) throws JsonProcessingException {
        userRepository.save(objectMapper.readValue(message, User.class));
    }

    public void updateUser(String message) throws JsonProcessingException {
        userRepository.save(objectMapper.readValue(message, User.class));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
