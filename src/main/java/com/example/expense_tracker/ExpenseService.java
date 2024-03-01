package com.example.expense_tracker;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public double getTotal() {
        Double total = expenseRepository.sumTotalAmount();

        return (total != null) ? total : 0.0;
    }


    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }

    public Expense findById(int id){
        Optional<Expense> result = expenseRepository.findById(id);

        return result.orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
    }

    public Expense save(Expense expense){
        return expenseRepository.save(expense);
    }

    @Transactional
    public Expense updateExpense(int id, ExpenseDTO dto) {
        Expense existingExpense = findById(id);

        existingExpense.setDescription(dto.description());
        existingExpense.setAmount(dto.amount());
        existingExpense.setCategory(dto.category());
        existingExpense.setDate(dto.date());

        return expenseRepository.save(existingExpense);
    }

    public void deleteById(int id) {
        if (!expenseRepository.existsById(id)) {
            throw new ExpenseNotFoundException("Expense not found id - " + id);
        }

        expenseRepository.deleteById(id);
    }

    public List<Expense> findByCategory(String category){
        return expenseRepository.findByCategory(category);
    }
}
