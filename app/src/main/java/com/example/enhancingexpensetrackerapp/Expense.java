package com.example.enhancingexpensetrackerapp;


import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Expense {
    private final String id; // Changed id type to String
    private final double amount;
    private final String currency;
    private final String createDate;
    private final String category;
    private final String remark;

    private static final List<Expense> expenses = new ArrayList<>();
// constructor
    public Expense(double amount, String currency, String createDate, String category, String remark) {
        this.id = UUID.randomUUID().toString(); // Generate UUID for each expense
        this.amount = amount;
        this.currency = currency;
        this.createDate = createDate;
        this.category = category;
        this.remark = remark;
    }
// getters
    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getCategory() {
        return category;
    }

    public String getRemark() {
        return remark;
    }

    public static List<Expense> getExpenses() {
        return expenses;
    }
// method to add expense
    public static void addExpense(Expense expense) {
        expenses.add(expense);
    }
// method to get expense by id
    public static Expense getExpenseById(String id) {
        for (Expense expense : expenses) {
            if (expense.getId().equals(id)) { // Use equals for String comparison
                return expense;
            }
        }
        return null;
    }
}
