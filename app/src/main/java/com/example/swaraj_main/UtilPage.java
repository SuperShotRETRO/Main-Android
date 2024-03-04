package com.example.swaraj_main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UtilPage extends AppCompatActivity {

    EditText searchInput;

    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utilpage);

        searchInput = findViewById(R.id.searchInput);
        searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(v->{
            String[] text = searchInput.getText().toString().split("");
            String type = text[0].toLowerCase();
            String content = text[1];

            switch (type){
                case "search":
                    if(!content.equals("")){
                        Intent searchIntent = new Intent(Intent.ACTION_VIEW);
                        searchIntent.setData(Uri.parse(String.format("https://www.google.com/search?q=%s",content)));
                        startActivity(searchIntent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No Search Text", Toast.LENGTH_LONG).show();
                    }

                case "locate":
                    if(!content.equals("")){
                        Intent locateIntent = new Intent(Intent.ACTION_VIEW);
                        locateIntent.setData(Uri.parse(String.format("https://www.google.com/maps/place/%s,",content)));
                        startActivity(locateIntent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No Search Text", Toast.LENGTH_LONG).show();
                    }

                case "dial":
                    if(!content.equals("")){
                        try {
                            int validate = Integer.parseInt(content);
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse(String.format("tel:%s",content)));
                            startActivity(callIntent);
                        }
                        catch (NumberFormatException e){

                        }
                    }
            }

        });

    }
}
