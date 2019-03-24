package com.ag.api.exception;

import com.ag.api.exception.notfound.ResourceNotFoundException;
import com.ag.api.exception.notfound.ToDoItemNotFoundError;
import com.ag.api.exception.validation.ToDoItemValidationDetails;
import com.ag.api.exception.validation.ToDoItemValidationError;
import com.ag.api.exception.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request)
    {
        String message = ex.getMessage();
        String value = request.getParameter("input") == null ? "" : request.getParameter("input");
        ToDoItemValidationDetails details = new ToDoItemValidationDetails("input", "text", message, value);
        ToDoItemValidationError error = new ToDoItemValidationError(details, "ValidationError");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request)
    {
        ToDoItemValidationError error = new ToDoItemValidationError(ex.getDetails(), "ValidationError");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request)
    {
        ToDoItemNotFoundError error = new ToDoItemNotFoundError(ex.getMessage(), "NotFoundError");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
