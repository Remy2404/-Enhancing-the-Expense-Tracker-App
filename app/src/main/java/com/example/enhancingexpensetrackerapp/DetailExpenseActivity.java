package com.example.enhancingexpensetrackerapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class DetailExpenseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_expense);

        // Get the expense ID as a String
        String expenseId = getIntent().getStringExtra("expenseId");
        if (expenseId != null) {
            Expense expense = Expense.getExpenseById(expenseId);
            if (expense != null) {
                TextView tvAmount = findViewById(R.id.tvAmount);
                TextInputEditText etCurrency = findViewById(R.id.etCurrency);
                TextInputEditText etCreateDate = findViewById(R.id.etCreateDate);
                TextInputEditText etCategory = findViewById(R.id.etCategory);
                TextInputEditText etRemark = findViewById(R.id.etRemark);

                tvAmount.setText("Amount: " + expense.getAmount());
                etCurrency.setText(expense.getCurrency());
                etCreateDate.setText(expense.getCreateDate());
                etCategory.setText(expense.getCategory());
                etRemark.setText(expense.getRemark());
            }
        }
    }
}
