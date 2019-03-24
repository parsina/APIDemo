package com.ag.api.exception.validation;

public class ToDoItemValidationError extends ToDoError
{
    private ToDoItemValidationDetails details;

    public ToDoItemValidationError(ToDoItemValidationDetails details, String name)
    {
        this.details = details;
        this.setName(name);
    }

    public ToDoItemValidationDetails getDetails()
    {
        return details;
    }

    public void setDetails(ToDoItemValidationDetails details)
    {
        this.details = details;
    }
}