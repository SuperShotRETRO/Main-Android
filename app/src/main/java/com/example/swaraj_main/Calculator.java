package com.example.swaraj_main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Calculator extends AppCompatActivity {
    EditText num1,num2,op;

    TextView res;

    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        op = findViewById(R.id.op);

        res = findViewById(R.id.res);

        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());

                String oper = op.getText().toString();

                if(oper.equals("+") || oper.equals("sum")){
                    res.setText(String.format("%s",a+b));
                } else if (oper.equals("-") || oper.equals("diff")) {
                    res.setText(String.format("%s",a-b));
                } else if(oper.equals("*") || oper.equals("mult")){
                    res.setText(String.format("%s",a*b));
                } else if(oper.equals("/") || oper.equals("div")){
                    res.setText(String.format("%s",a-b));
                } else{
                    res.setText("Error");
                }


            }
        });
    }
}
