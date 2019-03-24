package com.ag.api.service;

import com.ag.api.dto.BalanceTestResult;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class TaskServiceImpl implements TaskService
{
    @Override
    public BalanceTestResult validateBrackets(String input)
    {
        BalanceTestResult result = new BalanceTestResult();
        result.setInput(input);
        if (input.isEmpty())
        {
            result.setBalanced(true);
            return result;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            char current = input.charAt(i);
            if (current == '{' || current == '(' || current == '[')
                stack.push(current);

            if (current == '}' || current == ')' || current == ']')
            {
                if (stack.isEmpty())
                {
                    result.setBalanced(false);
                    return result;
                }

                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                {
                    result.setBalanced(false);
                    return result;
                }
            }
        }
        result.setBalanced(stack.isEmpty());
        return result;
    }
}
