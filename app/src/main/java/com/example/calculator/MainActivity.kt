package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {

    private var edtNumber1: EditText? = null
    private var edtNumber2: EditText? = null
    private var textResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText, Buttons, and Result TextView
        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
        textResult = findViewById(R.id.txtResult)

        val buttonAdd = findViewById<Button>(R.id.btnAdd)
        val buttonSubtract = findViewById<Button>(R.id.btnSub)
        val buttonMultiply = findViewById<Button>(R.id.btnMul)
        val buttonDivide = findViewById<Button>(R.id.btnDiv)
        val buttonSquareRoot = findViewById<Button>(R.id.btnSqrt)
        val buttonReset = findViewById<Button>(R.id.btnReset)


        // Set OnClickListener for Add Button
        buttonAdd.setOnClickListener { performOperation("+") }

        // Set OnClickListener for Subtract Button
        buttonSubtract.setOnClickListener { performOperation("-") }

        // Set OnClickListener for Multiply Button
        buttonMultiply.setOnClickListener { performOperation("*") }

        // Set OnClickListener for Divide Button
        buttonDivide.setOnClickListener { performOperation("/") }

        // Set OnClickListener for Square Root Button
        buttonSquareRoot.setOnClickListener { performSquareRootOfSum() }
    }

    private fun performOperation(operation: String) {
        // Get the input numbers
        val firstInput = edtNumber1!!.text.toString()
        val secondInput = edtNumber2!!.text.toString()

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Try to parse the input as Double
        val num1: Double
        val num2: Double
        try {
            num1 = firstInput.toDouble()
            num2 = secondInput.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        var result = 0.0

        when (operation) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> if (num2 != 0.0) {
                result = num1 / num2
            } else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Display the result
        textResult!!.text = "Result: $result"
    }

    private fun performSquareRootOfSum() {
        val firstInput = edtNumber1!!.text.toString()
        val secondInput = edtNumber2!!.text.toString()

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Try to parse the input as Double
        val num1: Double
        val num2: Double
        try {
            num1 = firstInput.toDouble()
            num2 = secondInput.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Calculate the sum of both numbers
        val sum = num1 + num2

        // Calculate the square root of the sum
        val result = sqrt(sum)

        // Display the result
        textResult!!.text = "Square Root of Sum: $result"
    }
}
