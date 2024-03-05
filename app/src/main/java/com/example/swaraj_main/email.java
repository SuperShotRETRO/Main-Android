package com.example.swaraj_main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class email extends AppCompatActivity {

    EditText to,cc,subject,body;

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        to = findViewById(R.id.toInput);
        cc = findViewById(R.id.ccInput);
        subject = findViewById(R.id.subjectInput);
        body = findViewById(R.id.bodyInput);

        send = findViewById(R.id.sendBtn);

        send.setOnClickListener(v->{
            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to.getText().toString()});
            mail.putExtra(Intent.EXTRA_CC,new String[]{cc.getText().toString()});
            mail.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
            mail.putExtra(Intent.EXTRA_TEXT,body.getText().toString());

            mail.setType("message/rfc822");
            startActivity(Intent.createChooser(mail,"Select email user"));
        });
    }
}
