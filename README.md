# Financial Tracker

A simple desktop financial tracking application built with **Java** and **JavaFX**. The application allows users to enter expenses, budgets, available funds, and savings while providing basic validation and expense-tracking functionality.

## Features

- Add and track expenses
- Calculate total expenses
- Compare expenses against a specified budget
- Validate expenses against available funds
- Track available savings
- Subtract expenses from current available funds
- Subtract expenses from savings
- Display updated financial amounts
- Handle invalid numerical input with error messages
- Simple graphical user interface using JavaFX

## Technologies Used

- Java
- JavaFX
- Object-Oriented Programming
- Event-Driven Programming
- Exception Handling

## Application Overview

The Financial Tracker provides a graphical interface where users can enter financial information and perform basic calculations.

### User Inputs

| Input | Description |
|---|---|
| Expenses | Amount of the current expense |
| Budget | Available budget |
| Savings | Current savings amount |
| Money Available | Current available funds |

### Available Actions

| Button | Description |
|---|---|
| Add Expenses | Adds an expense to the total expense tracker |
| Check Expenses | Displays the total expenses recorded |
| Subtract Current Amount | Subtracts an expense from available funds |
| Subtract Savings | Subtracts an expense from savings |

## How It Works

The application uses JavaFX to create a graphical user interface.

The interface includes:

- Text fields for entering financial information
- Buttons for performing financial operations
- Labels for displaying results and error messages
- A GridPane layout for organizing the interface
- Event handlers for processing user actions

The application maintains a running total of expenses using:


private double totalExpenses = 0.0;


### Part 2 — Validation & Error Handling

Paste this **directly underneath Part 1**:


## Expense Tracking

When the user selects **Add Expenses**, the application checks the entered expense against:

1. The user's budget
2. The user's available money
3. The user's savings

If the expense does not exceed any of these values, it is added to the total expense amount.

For example:


Expenses:        $50
Budget:          $500
Savings:         $1,000
Money Available: $750



## Example Workflow

1. Enter an expense amount.
2. Enter the available budget.
3. Enter current savings.
4. Enter available money.
5. Select **Add Expenses**.
6. The application validates the expense.
7. If the expense is valid, it is added to the total.
8. Select **Check Expenses** to view total expenses.

## Learning Objectives

This project demonstrates practical experience with:

- Java programming
- JavaFX application development
- Object-oriented programming
- Event-driven programming
- GUI development
- User input validation
- Exception handling
- Conditional statements
- Mathematical calculations
- Debugging
- Problem solving

## Future Improvements

Potential improvements include:

- Add a database for persistent transaction storage
- Add expense categories
- Add transaction history
- Add monthly and yearly reports
- Add charts and financial data visualization
- Add edit and delete functionality
- Add automatic budget calculations
- Add currency formatting
- Improve the graphical user interface
- Add the ability to save and load financial information

## Author

**Renatha Sanchez**

