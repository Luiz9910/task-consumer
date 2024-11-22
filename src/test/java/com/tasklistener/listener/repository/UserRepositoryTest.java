package com.tasklistener.listener.repository;

import com.tasklistener.listener.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User(1, "Test User", "testuser@example.com", null);

        when(userRepository.save(any(User.class))).thenReturn(testUser);
    }

    @Test
    void testSaveUser() {
        User savedUser = userRepository.save(testUser);

        assertNotNull(savedUser);
        assertEquals(testUser.getId(), savedUser.getId());
        assertEquals("Test User", savedUser.getName());
        assertEquals("testuser@example.com", savedUser.getEmail());
    }
}
