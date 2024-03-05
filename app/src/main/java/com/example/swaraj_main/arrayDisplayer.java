package com.example.swaraj_main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class arrayDisplayer extends AppCompatActivity {

    StringBuffer sb;

    AlertDialog alertdialogue;

    TextView cityDisplay;

    Button alertDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arraydisplay);

        sb = new StringBuffer();
        cityDisplay = findViewById(R.id.array);

        alertDisplay = findViewById(R.id.alertDisplayBtn);

        Resources resources = getResources();
        String[] cities = resources.getStringArray(R.array.city);

        for(int i = 0;i < cities.length;i++){
            sb.append(String.format("%s\n",cities[i]));
        }
        cityDisplay.setText(sb);


        alertdialogue = new AlertDialog.Builder(this).create();

        alertDisplay.setOnClickListener(v->{
            alertdialogue.setTitle("Confirmation Alert Dialogue");
            alertdialogue.setMessage(sb);
            alertdialogue.setCancelable(true);
            alertdialogue.setButton(AlertDialog.BUTTON_NEGATIVE,"cancel",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    alertdialogue.dismiss();
                }
            });

            alertdialogue.setButton(AlertDialog.BUTTON_POSITIVE,"ok",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    onRestart();
                }
            });

            alertdialogue.show();
        });

    }
}
