package com.example.swaraj_main;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RadioNCheckbox extends AppCompatActivity {

    EditText dobInput;
    AutoCompleteTextView cityInput;

    MultiAutoCompleteTextView degreeInput;

    RadioGroup rg;

    CheckBox carInput,bikeInput,footInput;

    TextView res;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radioncheckbox);

        dobInput = findViewById(R.id.dobInput);
        cityInput = findViewById(R.id.cityInput);
        degreeInput = findViewById(R.id.degreeInput);

        rg = findViewById(R.id.radioGrp);
        carInput = findViewById(R.id.carCB);
        bikeInput = findViewById(R.id.bikeCB);
        footInput = findViewById(R.id.footCB);

        res = findViewById(R.id.resView);

        submit = findViewById(R.id.submitBtn);

        submit.setOnClickListener(v -> {
            StringBuffer to = new StringBuffer();
            StringBuffer food = new StringBuffer();
            if (carInput.isChecked()){
                to.append("Car\t");
            }
            if (bikeInput.isChecked()){
                to.append("Bike\t");
            }
            if (footInput.isChecked()){
                to.append("Foot\t");
            }

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.vegBtn) {
                        food.append("Veg");
                    } else if (checkedId == R.id.nonvegBtn) {
                        food.append("Non-Veg");
                    } else if (checkedId == R.id.bothBtn) {
                        food.append("Both");
                    }

                }
            });

            res.setText(String.format("Date of birth: %s\nCity: %s\nDegree: %s\nMode of transport: %s\n",dobInput.getText().toString(),cityInput.getText().toString(),degreeInput.getText().toString(),to));
        });

    }
}
