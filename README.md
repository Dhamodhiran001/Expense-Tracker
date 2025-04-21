
# Expense Tracker Application

## Overview

The Expense Tracker application allows users to track their expenses, providing functionality to add and view expenses. The program allows for the entry of various expense details including amount, category, date, and a description.

## Features

- **Add Expense:** Users can input details of an expense including the amount, category, date, and a description. Each expense is assigned a unique ID.
- **View Expenses:** Displays a list of all recorded expenses with their details.
- **Exit:** Exit the program.

## Requirements

- Java 8 or higher
- A terminal or command prompt to run the program

## How to Run

1. **Download the code:**
   - Download or clone the repository to your local machine.

2. **Compile the code:**
   - Open a terminal or command prompt in the directory where the code is stored.
   - Compile the program by running:
     ```
     javac ExpenseTracker.java
     ```

3. **Run the program:**
   - After compiling, run the program using the following command:
     ```
     java ExpenseTracker
     ```

4. **Interact with the program:**
   - The program will display a menu where you can:
     - Add an expense
     - View existing expenses
     - Exit the program

## Code Explanation

- **Expense Class:**
  - The `Expense` class represents an individual expense with fields for ID, amount, category, date, and description.
  - It includes a constructor to initialize these fields and a `toString()` method to format the expense details.

- **ExpenseTracker Class:**
  - The `ExpenseTracker` class contains the main logic of the program.
  - The `addExpense()` method prompts the user for expense details and adds a new expense to the list.
  - The `viewExpenses()` method displays all the expenses stored in the system.
  - The `main()` method provides a simple text-based menu for the user to interact with the application.

## Example Usage

**Sample Output for Adding an Expense:**
```
Expense Tracker Menu:
1. Add Expense
2. View Expenses
3. Exit
Enter choice: 1
Enter amount: 50.0
Enter category: Groceries
Enter date (YYYY-MM-DD): 2025-04-20
Enter description: Purchased vegetables
Expense added successfully.
```

**Sample Output for Viewing Expenses:**
```
Expense Tracker Menu:
1. Add Expense
2. View Expenses
3. Exit
Enter choice: 2
ID      Amount      Category   Date        Description
1       50.0        Groceries  2025-04-20  Purchased vegetables
```

## Error Handling

- The program handles invalid inputs (such as non-numeric values for the amount and invalid date formats) and prompts the user to try again.
  
## Future Enhancements

- **Search Expenses:** Add functionality to search expenses by category or date.
- **Delete Expense:** Allow users to delete an expense.
- **Save Expenses to File:** Save the expenses list to a file to retain data between program runs.
