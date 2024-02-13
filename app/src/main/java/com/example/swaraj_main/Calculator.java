package com.example.swaraj_main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Calculator extends AppCompatActivity {
    EditText num1,num2,op;

    TextView res;

    Button calculate;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        op = findViewById(R.id.op);

        res = findViewById(R.id.res);

        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            String oper = op.getText().toString();

            switch (oper) {
                case "+":
                case "sum":
                    res.setText(String.format("%s", a + b));
                    break;
                case "-":
                case "diff":
                    res.setText(String.format("%s", a - b));
                    break;
                case "*":
                case "mult":
                    res.setText(String.format("%s", a * b));
                    break;
                case "/":
                case "div":
                    res.setText(String.format("%s", a - b));
                    break;
                default:
                    res.setText("Error");
                    break;
            }


        });
    }
}
