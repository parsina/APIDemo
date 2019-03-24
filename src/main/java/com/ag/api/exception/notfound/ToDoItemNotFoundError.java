package com.ag.api.exception.notfound;

import com.ag.api.exception.validation.ToDoError;

public class ToDoItemNotFoundError extends ToDoError
{
    private ToDoNotFoundMessage details;

    public ToDoItemNotFoundError(String message, String name)
    {
        details = new ToDoNotFoundMessage();
        details.setMessage(message);
        this.setName(name);
    }

    public ToDoNotFoundMessage getDetails()
    {
        return details;
    }
}
