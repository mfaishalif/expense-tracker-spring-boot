package com.example.expense_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByCategory(String category);

    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double sumTotalAmount();
}
