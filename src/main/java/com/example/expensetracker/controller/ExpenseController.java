package com.example.expensetracker.controller;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.ExpenseService;
import com.example.expensetracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private UserService userService;
    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @PostMapping("/addexpense")
    public String addExpense(Expense expense, Authentication authentication){
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        expense.setUser(user);
        expenseService.addExpense(expense);
        return "redirect:/dashboard";

    }
}


