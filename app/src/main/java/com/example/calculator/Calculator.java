package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    EditText edtNumber1, edtNumber2;
    TextView txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnSqrt, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI Elements
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(v -> {
            Log.d("Calculator", "Add button clicked");
            performOperation('+');
        });
        btnSub.setOnClickListener(v -> {
            Log.d("Calculator", "Subtract button clicked");
            performOperation('-');
        });
        btnMul.setOnClickListener(v -> {
            Log.d("Calculator", "Multiply button clicked");
            performOperation('*');
        });
        btnDiv.setOnClickListener(v -> {
            Log.d("Calculator", "Divide button clicked");
            performOperation('/');
        });
        btnSqrt.setOnClickListener(v -> {
            Log.d("Calculator", "Square Root button clicked");
            performSquareRoot();
        });
        btnReset.setOnClickListener(v -> {
            Log.d("Calculator", "Reset button clicked");
            resetCalculator();
        });


        // Hide Reset Button Initially
        btnReset.setVisibility(View.GONE);

        // Button Listeners
        btnAdd.setOnClickListener(v -> performOperation('+'));
        btnSub.setOnClickListener(v -> performOperation('-'));
        btnMul.setOnClickListener(v -> performOperation('*'));
        btnDiv.setOnClickListener(v -> performOperation('/'));
        btnSqrt.setOnClickListener(v -> performSquareRoot());

        btnReset.setOnClickListener(v -> resetCalculator());
    }

    // Function to perform basic operations
    private void performOperation(char operator) {
        String num1Str = edtNumber1.getText().toString();
        String num2Str = edtNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            txtResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 != 0) result = num1 / num2;
                else {
                    txtResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        txtResult.setText("Result: " + result);
        btnReset.setVisibility(View.VISIBLE);
    }

    // Function for square root operation
    private void performSquareRoot() {
        String num1Str = edtNumber1.getText().toString();

        if (num1Str.isEmpty()) {
            txtResult.setText("Enter a number");
            return;
        }

        double num = Double.parseDouble(num1Str);
        if (num < 0) {
            txtResult.setText("Invalid input: Negative numbers not allowed");
            return;
        }

        double result = Math.sqrt(num);
        txtResult.setText("√ Result: " + result);
        btnReset.setVisibility(View.VISIBLE);
    }

    // Reset Function
    private void resetCalculator() {
        edtNumber1.setText("");
        edtNumber2.setText("");
        txtResult.setText("Result");
        btnReset.setVisibility(View.GONE);
    }
}
