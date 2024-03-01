package com.example.expense_tracker;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public ExpenseErrorResponse() {}

    public ExpenseErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
