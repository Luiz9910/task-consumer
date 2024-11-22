package com.tasklistener.listener.repository;

import com.tasklistener.listener.model.Task;
import com.tasklistener.listener.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class TaskRepositoryTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    private Task task1;
    private Task task2;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User(100, "Test User", "testuser@example.com", new Date());
        task1 = new Task(1, "Task 1", "Description 1", "P", new Date(), new Date(), 100);
        task2 = new Task(2, "Task 2", "Description 2", "C", new Date(), new Date(), 100);

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(taskRepository.save(any(Task.class))).thenReturn(task1, task2);
    }
}
