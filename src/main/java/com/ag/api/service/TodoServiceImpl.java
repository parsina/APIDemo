package com.ag.api.service;

import com.ag.api.exception.notfound.ResourceNotFoundException;
import com.ag.api.model.ToDoItem;
import com.ag.api.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItem createToDoItem(String text)
    {
        ToDoItem toDoItem = new ToDoItem(text);
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public ToDoItem findToDoItemById(Long id)
    {
        Optional<ToDoItem> optional = toDoItemRepository.findById(id);
        if(!optional.isPresent())
            throw new ResourceNotFoundException("Item with id(" + id + ") not found");
        return optional.get();
    }

    @Override
    public ToDoItem updateToDoItem(Long id, String text, boolean complete)
    {
        ToDoItem toDoItem = findToDoItemById(id);
        toDoItem.setText(text);
        toDoItem.setCompleted(complete);
        return toDoItemRepository.save(toDoItem);
    }
}
