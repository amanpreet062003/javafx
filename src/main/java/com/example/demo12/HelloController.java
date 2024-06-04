package com.example.demo12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private TextField Amount_Entered;
    @FXML
    private TextField Converted_amount;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Button Convert_button;
    @FXML
    private Label welcomeText;

    // Initialize the controller and setup the ComboBox
    @FXML
    public void initialize() {
        combo.getItems().addAll("EUR", "GBP", "JPY"); // Example currencies
        welcomeText.setText("Please enter an amount and select a currency.");
    }

    // Event handler for the convert button
    @FXML
    protected void onHelloButtonClick() {
        try {
            double amount = Double.parseDouble(Amount_Entered.getText());
            String selectedCurrency = combo.getValue();
            double convertedAmount = convertCurrency(amount, selectedCurrency);
            Converted_amount.setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException e) {
            Converted_amount.setText("Please enter a valid number.");
        } catch (NullPointerException e) {
            Converted_amount.setText("Please select a currency.");
        }
    }

    // Mock function to convert currency based on the selection
    private double convertCurrency(double amount, String currency) {
        switch (currency) {
            case "EUR":
                return amount * 0.93; // Example rate
            case "GBP":
                return amount * 0.82;
            case "JPY":
                return amount * 145.34;
            default:
                return amount; // Return the same amount if no currency is selected
        }
    }
}
