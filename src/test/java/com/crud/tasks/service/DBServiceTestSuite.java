package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DBServiceTestSuite {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L, "test task", "test description");
        taskList.add(task);
        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> taskList1 = taskRepository.findAll();

        //Then
        assertEquals(taskList1.size(), 1);
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task = new Task(1L, "test task", "test description");
        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.of(task));

        //When
        Optional<Task> task1 = taskRepository.findById(1L);

        //Then
        assertNotNull(task1);
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1L, "test task", "test description");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        Optional<Task> task1 = Optional.ofNullable(taskRepository.save(task));

        //Then
        assertNotNull(task1);
    }
}
