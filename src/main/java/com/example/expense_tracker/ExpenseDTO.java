package com.example.expense_tracker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record ExpenseDTO(
    Long id,
    @NotBlank(message = "Description cannot be empty")
    String description,

    @Positive(message = "Amount must be greater than zero")
    double amount,

    @NotBlank(message = "Category is required")
    String category,

    @NotNull(message = "Date is required")
    LocalDate date

) {}
