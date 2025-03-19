# Expense Tracker App

An Android application for tracking and managing expenses with features to add, view, and categorize spending.

## Features
- Track expenses with amount, currency, category, and remarks
- View expense details and history
- Support for multiple currencies (USD, KHR)
- Categorize expenses (Food, Travel, Shopping, etc.)
- Modern Material Design UI with bottom navigation

## Technical Implementation
- **UUID-based IDs:** Each expense has a unique identifier generated using UUID
- **Fragment-based UI:** Home, Add Expense, and Expense List fragments
- **RecyclerView:** Used for displaying expense lists with efficient memory usage
- **Material Components:** TextInputLayout, FloatingActionButton, BottomNavigationView

## Project Structure
- **MainActivity:** Main entry point with bottom navigation and sample data initialization
- **Expense:** Model class for expense data with static methods for data management
- **DetailExpenseActivity:** Shows detailed information for a selected expense

### UI Fragments
- **HomeFragment:** Dashboard overview
- **AddExpenseFragment:** Form for adding new expenses
- **ExpenseListFragment:** List of all expenses

## Setup
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run on an emulator or physical device.

## Requirements
- Android Studio Meerkat | 2024.3.1 or newer
- Android SDK with minimum API level as specified in build.gradle
- JDK 11 or newer
