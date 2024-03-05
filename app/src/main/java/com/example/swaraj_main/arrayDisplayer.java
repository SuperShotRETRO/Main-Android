package com.example.swaraj_main;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class arrayDisplayer extends AppCompatActivity {

    StringBuffer sb;

    AlertDialog alertdialogue;

    TextView cityDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.arraydisplay);

        sb = new StringBuffer();
        cityDisplay = findViewById(R.id.array);

        Resources resources = getResources();
        String[] cities = resources.getStringArray(R.array.city);

        for(int i = 0;i <= cities.length;i++){
            sb.append(cities[i]);
        }

        cityDisplay.setText(sb);

        alertdialogue = new AlertDialog.Builder(this).create();
    }
}
