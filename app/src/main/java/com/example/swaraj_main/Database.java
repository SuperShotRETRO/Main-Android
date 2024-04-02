package com.example.swaraj_main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Database extends AppCompatActivity {

    EditText name,email,password;

    Button regBtn;

    DatabaseUtils db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        name = findViewById(R.id.regName);
        email = findViewById(R.id.regEmail);
        password = findViewById(R.id.regPassword);

        regBtn = findViewById(R.id.regBtn);

        db = new DatabaseUtils(this);
        Toast.makeText(getApplicationContext(),"Database", Toast.LENGTH_LONG).show();

        regBtn.setOnClickListener(v->{

            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();

            if(!(nameText.isEmpty() && emailText.isEmpty() && passwordText.isEmpty())){
                boolean res = db.register(nameText,emailText,passwordText);
                if (res){
                    Toast.makeText(getApplicationContext(),"User Created", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(),"Fields empty", Toast.LENGTH_LONG).show();
            }
        });


    }
}
