package com.example.swaraj_main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Calculator extends AppCompatActivity {

    String email,password;
    EditText num1,num2,op;

    TextView res,loginInfo;

    Button calculate,change,mail,arrayDisplay,logout,database;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        op = findViewById(R.id.op);

        loginInfo = findViewById(R.id.loginInfo);
        res = findViewById(R.id.res);

        calculate = findViewById(R.id.calculate);
        change = findViewById(R.id.smartSearchBtn);
        mail = findViewById(R.id.mail);
        arrayDisplay = findViewById(R.id.arrayDisplay);
        logout = findViewById(R.id.logout);
        database = findViewById(R.id.goToDatabasePage);

        loginInfo.setText(String.format("Email: %s\nPassword: %s",email,password));



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

        change.setOnClickListener(v->{
            Intent intent = new Intent(Calculator.this, smartSearch.class);
            startActivity(intent);
        });

        mail.setOnClickListener(v->{
            Intent intent = new Intent(Calculator.this, email.class);
            startActivity(intent);
        });

        arrayDisplay.setOnClickListener(v->{
            Intent intent = new Intent(Calculator.this, arrayDisplayer.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            Intent intent = new Intent(Calculator.this,MainActivity.class);
            startActivity(intent);
        });

        database.setOnClickListener(v -> {
            Intent intent = new Intent(Calculator.this,Database.class);
            startActivity(intent);
        });
    }
}
