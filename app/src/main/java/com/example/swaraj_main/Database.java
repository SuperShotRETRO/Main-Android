package com.example.swaraj_main;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Database extends AppCompatActivity {

    TextView result;
    EditText name,email,password,rollno,course,courseId,city;

    Button regBtn, searchStdBtn, searchallbtn, updateBtn, deleteBtn;

    DatabaseUtils db;

    Spinner tableSelector;

    private String tableName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        result = findViewById(R.id.result);

        name = findViewById(R.id.regName);
        email = findViewById(R.id.regEmail);
        password = findViewById(R.id.regPassword);
        rollno = findViewById(R.id.rollText);
        course = findViewById(R.id.course);
        courseId = findViewById(R.id.courseid);
        city = findViewById(R.id.city);

        regBtn = findViewById(R.id.regBtn);
        searchStdBtn = findViewById(R.id.searchStdBtn);
        searchallbtn = findViewById(R.id.searchAllBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        tableSelector = findViewById(R.id.tableSelector);

        db = new DatabaseUtils(this);
        Toast.makeText(getApplicationContext(),"Database", Toast.LENGTH_LONG).show();

        ArrayList<String> items = db.fetchTables();
        items.remove(0);
        items.remove("sqlite_sequence");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_gallery_item,items);
        tableSelector.setAdapter(adapter);

        tableSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tableName = items.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        regBtn.setOnClickListener(v->{

            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String courseText = course.getText().toString();
            String courseIdText = courseId.getText().toString();
            String cityText = city.getText().toString();

            if(!(nameText.isEmpty() && emailText.isEmpty() && passwordText.isEmpty() && courseText.isEmpty() && courseIdText.isEmpty() && cityText.isEmpty())){
                boolean res = db.register(tableName,nameText,emailText,passwordText,courseText,courseIdText,cityText);
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

        searchStdBtn.setOnClickListener(v->{
                Cursor record = db.searchRecord(rollno.getText(),email.getText(),course.getText(), courseId.getText(), city.getText());
                if (!(record.getCount() == 0)) {
                    while (record.moveToNext()) {
                        result.setText(String.format("Search result:\nRoll no: %s\nName: %s\nEmail:  %s", record.getInt(0), record.getString(1), record.getString(2)));
                    }
                } else {
                    result.setText("No record found");
                }

        });

        searchallbtn.setOnClickListener(v -> {
            Cursor record  = db.getRecords(tableName);
            if (!(record.getCount() == 0)) {
                while (record.moveToNext()) {
                    result.setText(String.format("Search result:\nRoll no: %s\nName: %s\nEmail:  %s", record.getInt(0), record.getString(1), record.getString(2)));
                }
            } else {
                result.setText("No record found");
            }
        });

        updateBtn.setOnClickListener(v -> {
            String rollText = rollno.getText().toString();
            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String courseText = course.getText().toString();
            String courseIdText = courseId.getText().toString();
            String cityText = city.getText().toString();

            if(!(rollText.isEmpty() && nameText.isEmpty() && emailText.isEmpty() && passwordText.isEmpty() && courseText.isEmpty() && courseIdText.isEmpty() && cityText.isEmpty())){
                boolean res = db.updateRecord(tableName,Integer.parseInt(rollText),nameText,emailText,passwordText,courseText,courseIdText,cityText);
                if (res){
                    Toast.makeText(getApplicationContext(),"User Updated", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(),"Fields empty", Toast.LENGTH_LONG).show();
            }
        });

        deleteBtn.setOnClickListener(v -> {
            String rollText = rollno.getText().toString();

            if(!(rollText.isEmpty())){
                boolean res = db.deleteRecord(tableName,Integer.parseInt(rollText));
                if (res){
                    Toast.makeText(getApplicationContext(),"User Updated", Toast.LENGTH_LONG).show();
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
