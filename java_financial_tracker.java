package com.example.semesterprojectrenathasanchez;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinancialTracker extends Application {

    private double totalExpenses = 0.0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Financial Tracker");

        // adding the gridpanes
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //
        //
        // adding textfields

        // expenses textfield
        TextField expensesTextField = new TextField();
        expensesTextField.setPromptText("Enter Expenses");
        GridPane.setConstraints(expensesTextField, 0, 0);

        // budget textfield
        TextField budgetTextField = new TextField();
        budgetTextField.setPromptText("Enter Budget");
        GridPane.setConstraints(budgetTextField, 0, 1);

        // savings textfield
        TextField savingsTextField = new TextField();
        savingsTextField.setPromptText("Enter Savings");
        GridPane.setConstraints(savingsTextField, 0, 2);

        // current money textfield
        TextField moneyTextField = new TextField();
        moneyTextField.setPromptText("Enter Money Available");
        GridPane.setConstraints(moneyTextField, 0, 3);

        //
        //
        // adding the buttons

        // subtract button that subtracts expenses from current amount
        Button subtractButton = new Button("Subtract Current Amount");
        GridPane.setConstraints(subtractButton, 1, 3);

        // subtract button that subtracts expenses from savings
        Button subtractSavingsButton = new Button("Subtract Savings");
        GridPane.setConstraints(subtractSavingsButton, 1, 2);

        // add button to add all expenses made together
        Button addButton = new Button("Add Expenses");
        GridPane.setConstraints(addButton, 1, 0);

        // button to check the sum of expenses made
        Button expenseTrackerButton = new Button("Check Expenses");
        GridPane.setConstraints(expenseTrackerButton, 1, 4);

        // label for users know what happens when they click on the buttons
        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 0, 4);

        //
        //
        // ACTIONS

        // addbutton for the expenses
        addButton.setOnAction(ever -> {
            try {
                double expenses = Double.parseDouble(expensesTextField.getText());
                double budget = Double.parseDouble(budgetTextField.getText());
                double remainingMoney = Double.parseDouble(moneyTextField.getText());
                double savings = Double.parseDouble(savingsTextField.getText());

                if (expenses > budget) {
                    resultLabel.setText("Your expenses exceed your budget!");
                } else if (expenses > remainingMoney) {
                    resultLabel.setText("Your expenses exceed your current amount!");
                } else if (expenses > savings) {
                    resultLabel.setText("Your expenses exceed your savings!");
                } else {
                    if (expenses <= budget && expenses <= remainingMoney && expenses <= savings) {
                        totalExpenses += expenses;
                        resultLabel.setText("Expense added: " + expenses);
                    } else {
                        resultLabel.setText("Expense amount exceeds one budget, savings, or remaining money");
                    }
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid expense amount!");
            }
        });


        // tracking users expenses aka adding up allll the expenses
        expenseTrackerButton.setOnAction(event -> {
            resultLabel.setText("Total Expenses: " + totalExpenses);
        });


        // subtract action, subtracting expenses from current amount
        subtractButton.setOnAction(event -> {
            try {
                double remainingMoney = Double.parseDouble(moneyTextField.getText());
                double expenses =Double.parseDouble(expensesTextField.getText());
                double budget = Double.parseDouble(budgetTextField.getText());

                if (expenses > remainingMoney) {
                    resultLabel.setText("You do not have enough money to cover expenses!");
                } else if (expenses > budget) {
                    resultLabel.setText("Exceeds budget. Unable to subtract expenses.");
                } else {
                    remainingMoney -= expenses;
                    resultLabel.setText("New remaining money: " + remainingMoney);
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers");
            }
        });

        //subtracting expenses from savings
        subtractSavingsButton.setOnAction(event -> {
            try {
                double savings = Double.parseDouble(savingsTextField.getText());
                double amountToSubtract = Double.parseDouble(expensesTextField.getText());
                double budget = Double.parseDouble(budgetTextField.getText());

                if (amountToSubtract > savings) {
                    resultLabel.setText("Your expenses exceed your savings!");
                } else if (amountToSubtract > budget) {
                    resultLabel.setText("Your expenses exceed the budget!");
                } else {
                    savings -= amountToSubtract;
                    resultLabel.setText("New Savings: " + savings);
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        //
        //
        // getting children so textfields and buttons show up
        gridPane.getChildren().addAll(expensesTextField, budgetTextField, savingsTextField, moneyTextField, subtractButton, subtractSavingsButton, addButton, expenseTrackerButton, resultLabel);

        //
        // setting the scene
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}