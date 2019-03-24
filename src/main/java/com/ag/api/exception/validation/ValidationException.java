package com.ag.api.exception.validation;

import com.ag.api.exception.validation.ToDoItemValidationDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends javax.validation.ValidationException
{
    private ToDoItemValidationDetails details;
    public ValidationException(String location, String param, String message, String value)
    {
        this.details = new ToDoItemValidationDetails(location, param, message, value);
    }

    public ToDoItemValidationDetails getDetails()
    {
        return details;
    }
}
