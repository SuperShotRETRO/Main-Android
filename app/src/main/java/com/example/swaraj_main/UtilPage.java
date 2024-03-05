package com.example.swaraj_main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
            String[] text = searchInput.getText().toString().split(" ");
            String type = text[0].toLowerCase();
            String content = text[1];
            System.out.println(type);

            switch (type){
                case "search":
                    if(!content.equals("")){
                        Log.i("content",content);
                        Intent searchIntent = new Intent(Intent.ACTION_VIEW);
                        searchIntent.setData(Uri.parse(String.format("https://www.google.com/search?q=%s",content)));
                        startActivity(searchIntent);
                        break;
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No Search Text", Toast.LENGTH_LONG).show();
                        break;
                    }

                case "locate":
                    if(!content.equals("")){
                        Intent locateIntent = new Intent(Intent.ACTION_VIEW);
                        locateIntent.setData(Uri.parse(String.format("https://www.google.com/maps/place/%s,",content)));
                        startActivity(locateIntent);
                        break;
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No Search Text", Toast.LENGTH_LONG).show();
                        break;
                    }

                case "dial":
                    if(!content.equals("")){
                        try {
                            double validate = Double.parseDouble(content);
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse(String.format("tel:%s",content)));
                            startActivity(callIntent);
                            break;
                        }
                        catch (NumberFormatException e){

                        }
                    }
                default:
                    Toast.makeText(getApplicationContext(),"No Search Text", Toast.LENGTH_LONG).show();

            }

        });

    }
}
