package com.ag.api.controller;

import com.ag.api.dto.BalanceTestResult;
import com.ag.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("/api/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping("/validateBrackets")
    public ResponseEntity<BalanceTestResult> validateBrackets(@Size(min = 1, max = 50, message = "Must be between 1 and 50 chars long") String input)
    {
        return ResponseEntity.ok().body(taskService.validateBrackets(input));
    }
}
