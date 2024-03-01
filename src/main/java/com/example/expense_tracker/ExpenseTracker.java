package com.example.expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExpenseTracker {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(ExpenseTracker.class, args);

	}

}
