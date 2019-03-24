package com.ag.api.service;

import com.ag.api.dto.BalanceTestResult;

public interface TaskService
{
    BalanceTestResult validateBrackets(String input);
}
