package com.ag.api.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends NoSuchElementException
{
    private String message;

    public ResourceNotFoundException(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }
}
