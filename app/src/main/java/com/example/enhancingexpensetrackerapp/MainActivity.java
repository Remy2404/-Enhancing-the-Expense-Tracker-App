package com.example.enhancingexpensetrackerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize sample data
        initSampleData();

        // Set up Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Replace deprecated method with the new one
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            // Use if-else instead of switch for R.id values
            if (itemId == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.navigation_add_expense) {
                selectedFragment = new AddExpenseFragment();
            } else if (itemId == R.id.navigation_expense_list) {
                selectedFragment = new ExpenseListFragment();
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });

        loadFragment(new HomeFragment());
    }

private void initSampleData() {
        Random random = new Random();
        String[] categories = {"Food", "Travel", "Shopping", "Entertainment", "Health", "Other"};
        String[] descriptions = {"Lunch", "Bus ticket", "Groceries", "Movie", "Dinner", "Medicine", "Train ticket", "Clothing", "Concert", "Breakfast", "Vitamins", "Snack", "Coffee", "Fuel"};
        double usdExchangeRate = 4100.0; // Example exchange rate (1 USD to 4100 KHR)
        double khrMin = 50.0 * usdExchangeRate;
        double khrMax = 300.0 * usdExchangeRate;
        double usdMin = 50.0;
        double usdMax = 300.0;

        for (int i = 0; i < 61; i++) {
            String currency;
            double amount;
            if (random.nextBoolean()) {
                amount = Math.round((usdMin + (usdMax - usdMin) * random.nextDouble()) * 100.0) / 100.0;
                currency = "USD $";
            } else {
                amount = Math.round((khrMin + (khrMax - khrMin) * random.nextDouble()) * 100.0) / 100.0;
                currency = "KHR ៛";
            }

        // 1 US Dollar = 3,998 Cambodian Riel
         usdExchangeRate = 3998.0;
        khrMin = 50.0 * usdExchangeRate;

        int year = 2025;
        int month = random.nextInt(12) + 1; // 1-12
        int day = random.nextInt(28) + 1; // 1-28 (to keep it simple and avoid checking days per month)

        @SuppressLint("DefaultLocale") String date = String.format("%d-%02d-%02d", year, month, day);
        String category = categories[random.nextInt(categories.length)];
        String description = descriptions[random.nextInt(descriptions.length)];

        Expense.addExpense(new Expense(amount, currency, date, category, description));
    }
}
}



