package com.ag.api;

import com.ag.api.exception.notfound.ResourceNotFoundException;
import com.ag.api.model.ToDoItem;
import com.ag.api.repository.ToDoItemRepository;
import com.ag.api.service.TaskServiceImpl;
import com.ag.api.service.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TodoServiceTest
{
    @TestConfiguration
    static class TodoServiceTestContextConfiguration
    {
        @Bean
        public TodoServiceImpl todoService()
        {
            return new TodoServiceImpl();
        }
    }

    @Autowired
    private TodoServiceImpl todoService;

    @MockBean
    private ToDoItemRepository toDoItemRepository;

    @Test
    public void testCreateToDoItem_whenSendTextValue_shouldReturnSavedToDoItem()
    {
        ToDoItem toDoItem = mock(ToDoItem.class);
        when(toDoItemRepository.save(any())).thenReturn(toDoItem);
        assertNotNull(todoService.createToDoItem(any()));
    }

    @Test
    public void testFindToDoItemById_whenSendToDoId_shouldReturnToDoItem()
    {
        Optional<ToDoItem> optional = spy(Optional.of(new ToDoItem()));
        when(toDoItemRepository.findById(anyLong())).thenReturn(optional);

        // if todoItem is not present
        doReturn(false).when(optional).isPresent();
        assertThrows(ResourceNotFoundException.class, () ->
        {
            todoService.findToDoItemById(anyLong());
        });

        // if todoItem is present
        doReturn(true).when(optional).isPresent();
        assertNotNull(todoService.findToDoItemById(anyLong()));
    }

    @Test
    public void testUpdateToDoItem_whenSendToDoItemParameters_shouldReturnUpdatedToDoItem()
    {
        ToDoItem toDoItem = spy(ToDoItem.class);
        Optional<ToDoItem> optional = spy(Optional.of(toDoItem));
        when(toDoItemRepository.findById(anyLong())).thenReturn(optional);
        doReturn(true).when(optional).isPresent();

        when(todoService.findToDoItemById(anyLong())).thenReturn(toDoItem);
        when(toDoItemRepository.save(any())).thenReturn(toDoItem);

        // Scenario 1: update todoItem  with text = 'test 1' and complete = true
        ToDoItem item = todoService.updateToDoItem(0L, "test 1", true);
        assertNotNull(item);
        assertEquals("test 1", item.getText());
        assertTrue(item.isCompleted());

        // Scenario 2: update todoItem  with text = 'test 2' and complete = false
        item = todoService.updateToDoItem(0L, "test 2", false);
        assertNotNull(item);
        assertEquals("test 2", item.getText());
        assertFalse(item.isCompleted());
    }
}
