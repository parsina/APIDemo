package com.ag.api.service;

import com.ag.api.model.ToDoItem;

public interface TodoService
{
    ToDoItem createToDoItem(String text);

    ToDoItem findToDoItemById(Long id);

    ToDoItem updateToDoItem(Long id, String text, boolean complete);
}