package com.example.expensetracker.service;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
@Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(User user) {
    return expenseRepository.findByUser(user);
     }
    public List<Expense> getUserExpenses(User user){

        return expenseRepository.findByUser(user);

    }
}




