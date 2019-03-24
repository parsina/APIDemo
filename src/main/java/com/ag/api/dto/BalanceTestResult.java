package com.ag.api.dto;

public class BalanceTestResult
{
    private String input;
    private boolean isBalanced;

    public String getInput()
    {
        return input;
    }

    public void setInput(String input)
    {
        this.input = input;
    }

    public boolean isBalanced()
    {
        return isBalanced;
    }

    public void setBalanced(boolean balanced)
    {
        isBalanced = balanced;
    }
}
