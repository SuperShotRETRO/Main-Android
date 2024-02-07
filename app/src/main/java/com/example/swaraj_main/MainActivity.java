package com.example.swaraj_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText email,password;

    Button loginBTN;

    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         email = findViewById(R.id.email);
         password = findViewById(R.id.password);

         loginBTN = findViewById(R.id.loginBtn);

         loginText = findViewById(R.id.loginText);

         loginBTN.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 loginText.setText(String.format("Welcome %s, with password: %s",email.getText().toString(),password.getText().toString()));
                 StringBuffer sb = new StringBuffer();
                 sb.append("Welcome");
                 Intent intent = new Intent(MainActivity.this,LoginSuccess.class);

                 if(email.getText().toString().equals("Swaraj") && password.getText().toString().equals("1234")){
//                     Toast.makeText(getApplicationContext(),sb,Toast.LENGTH_LONG).show();
                     intent.putExtra("email",email.getText().toString());
                     intent.putExtra("password",password.getText().toString());
                     startActivity(intent);
//                     CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> {
//                         intent.putExtra("email",email.getText().toString());
//                         intent.putExtra("password",password.getText().toString());
//                         startActivity(intent);
//                     });
                 }
             }
         });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StringBuffer sb = new StringBuffer();
        sb.append("Closed");
        Toast.makeText(this,sb,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        StringBuffer sb = new StringBuffer();
        sb.append("Start");
        Toast.makeText(this,sb,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        StringBuffer sb = new StringBuffer();
        sb.append("Restart");
        Toast.makeText(this,sb,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        StringBuffer sb = new StringBuffer();
        sb.append("Pause");
        Toast.makeText(this,sb,Toast.LENGTH_LONG).show();
    }

    public void info(){
        Toast.makeText(this,"Info",Toast.LENGTH_LONG).show();
    }
}