package com.example.expense_tracker;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesController {
    private final ExpenseService expenseService;

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<ExpenseDTO> findAll(){
        List<Expense> expenses = expenseService.findAll();

        return expenses.stream()
                .map(expense -> new ExpenseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getCategory(),
                        expense.getDate()
                ))
                .toList();
    }

    @GetMapping("/expenses/{id}")
    public ExpenseDTO findById(@PathVariable int id){
        Expense expense = expenseService.findById(id);

        return new ExpenseDTO(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDate()
        );
    }

    @GetMapping("/expenses/stats/total")
    public double getTotal(){
        return expenseService.getTotal();
    }

    @PostMapping("/expenses")
    public ExpenseDTO addExpense(@Valid @RequestBody ExpenseDTO dto){
        Expense expense = new Expense();
        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());
        expense.setCategory(dto.category());
        expense.setDate(dto.date());

        Expense savedExpense = expenseService.save(expense);

        return new ExpenseDTO(
                savedExpense.getId(),
                savedExpense.getDescription(),
                savedExpense.getAmount(),
                savedExpense.getCategory(),
                savedExpense.getDate()
        );

    }

    @PutMapping("/expenses/{id}")
    public ExpenseDTO updateExpense(@PathVariable int id, @Valid @RequestBody ExpenseDTO dto){
        Expense saved = expenseService.updateExpense(id, dto);

        return new ExpenseDTO(
                saved.getId(),
                saved.getDescription(),
                saved.getAmount(),
                saved.getCategory(),
                saved.getDate()
        );

    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable int id) { // 1. Use @PathVariable (and Long)

        expenseService.deleteById(id);

        return "Deleted expense with id - " + id;
    }
}
