package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTestSuite {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void mapToTaskAndBack() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //When
        Task task = taskMapper.mapToTask(taskDto);
        TaskDto taskDto1 = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getTitle(), "title");
        assertEquals(taskDto1.getTitle(), "title");
    }
    @Test
    public void mapToTaskDtoListAndBack() {
        //Given
        Task task1 = new Task(1L, "task 1", "content 1");
        Task task2 = new Task(2L, "task 2", "content 2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(taskDtoList.size(), 2);
    }
}
