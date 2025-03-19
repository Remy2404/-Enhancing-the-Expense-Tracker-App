package com.example.enhancingexpensetrackerapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailExpenseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_expense);

        // Get the expense ID as a String instead of an int
        String expenseId = getIntent().getStringExtra("expenseId");
        if (expenseId != null) {
            Expense expense = Expense.getExpenseById(expenseId);
            if (expense != null) {
                TextView tvAmount = findViewById(R.id.tvAmount);
                TextView tvCurrency = findViewById(R.id.tvCurrency);
                TextView tvCreateDate = findViewById(R.id.tvCreateDate);
                TextView tvCategory = findViewById(R.id.tvCategory);
                TextView tvRemark = findViewById(R.id.tvRemark);

                tvAmount.setText("Amount: " + expense.getAmount());
                tvCurrency.setText("Currency: " + expense.getCurrency());
                tvCreateDate.setText("Date: " + expense.getCreateDate());
                tvCategory.setText("Category: " + expense.getCategory());
                tvRemark.setText("Remark: " + expense.getRemark());
            }
        }
    }
}