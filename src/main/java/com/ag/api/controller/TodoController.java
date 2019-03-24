package com.ag.api.controller;

import com.ag.api.exception.notfound.ResourceNotFoundException;
import com.ag.api.exception.validation.ValidationException;
import com.ag.api.model.ToDoItem;
import com.ag.api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/items")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<ToDoItem> addTodoItem(@RequestBody Map<String, String> input)
    {
        String text = input.get("text");
        if (text == null || text.isEmpty() || text.length() > 50)
            throw new ValidationException("todo", "text", "Must be between 1 and 50 chars long", text);
        return ResponseEntity.ok().body(todoService.createToDoItem(input.get("text")));
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDoItem> getToDoItem(@PathVariable(value = "id") Long id)
    {
        if (id == null)
            throw new ValidationException("todo", "id", "Id is null", String.valueOf(id));
        return ResponseEntity.ok().body(todoService.findToDoItemById(id));
    }

    @PatchMapping("/todo/{id}")
    public ResponseEntity<ToDoItem> updateToDoItem(@PathVariable("id") Long id, @RequestBody Map<String, ?> input) throws ResourceNotFoundException
    {
        return ResponseEntity.ok(todoService.updateToDoItem(id, input.get("text").toString(), Boolean.valueOf(input.get("isComplete").toString())));
    }
}
