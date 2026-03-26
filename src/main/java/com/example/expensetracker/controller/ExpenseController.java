package com.example.expensetracker.controller;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.ExpenseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/";
        }

        List<Expense> expenses = expenseService.getAllExpenses(user);
        model.addAttribute("expenses", expenses);

        return "dashboard";
    }

    @PostMapping("/addexpense")
    public String addExpense(Expense expense, HttpSession session) {

        User user = (User) session.getAttribute("user");
        expense.setUser(user);

        expenseService.addExpense(expense);

        return "redirect:/dashboard";
    }
}