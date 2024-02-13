package com.example.swaraj_main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Calculator extends AppCompatActivity {

//    Bundle recieved;

    Intent mainIntent = new Intent();
    String password = mainIntent.getStringExtra("password");
    EditText num1,num2,op;

    TextView res,loginInfo;

    Button calculate,logout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        op = findViewById(R.id.op);

        loginInfo = findViewById(R.id.loginInfo);
        res = findViewById(R.id.res);

        calculate = findViewById(R.id.calculate);
        logout = findViewById(R.id.logout);

        loginInfo.setText(String.format("%s",password));

        calculate.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            String oper = op.getText().toString();

            switch (oper) {
                case "+":
                case "sum":
                    res.setText(String.format("Sum result: %s", a + b));
                    break;
                case "-":
                case "diff":
                    res.setText(String.format("Difference Result: %s", a - b));
                    break;
                case "*":
                case "multi":
                    res.setText(String.format("Multiplication Result: %s", a * b));
                    break;
                case "/":
                case "div":
                    res.setText(String.format("Division: %s", a / b));
                    break;
                default:
                    res.setText("Error");
                    break;
            }
        });

        logout.setOnClickListener(v -> {
            Intent intent = new Intent(Calculator.this,MainActivity.class);
            startActivity(intent);
        });
    }
}
