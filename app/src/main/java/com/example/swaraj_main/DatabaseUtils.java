package com.example.swaraj_main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

public class DatabaseUtils extends SQLiteOpenHelper {

    SQLiteDatabase database;
    public DatabaseUtils(@Nullable Context context) {
        super(context, "mca.db", null, 1);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(rollno integer primary key autoincrement, name varchar, email varchar, password varchar, course varchar, courseid varchar, city varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean register(String  name,String email, String password,String course, String courseid, String city){

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("course",course);
        cv.put("courseid",courseid);
        cv.put("city",city);

        long res = database.insert("users",null,cv);

        if(res == 1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getRecords(){

        Cursor record = database.rawQuery("select * from users",null);
        if(!(record.getCount() == 0)){
            return record;
        }
        else {
            return null;
        }
    }

    public Cursor searchRecord(int rollno){

        Cursor record = database.rawQuery(String.format("select * from users where rollno = %s",rollno),null);
        if(record.getCount() > 0){
            return record;
        }
        else {
            return null;
        }
    }
    public Cursor searchRecord(Editable rollno, Editable email, Editable course, Editable courseid, Editable city){

        String rollnoQ = rollno.toString().isEmpty()?"":String.format("rollno = %s and",rollno.toString());
        String emailQ = email.toString().isEmpty()?"":String.format("email = '%s' and",email.toString());
        String courseQ = course.toString().isEmpty()?"":String.format("course = '%s' and",course.toString());
        String courseidQ = courseid.toString().isEmpty()?"":String.format("courseid = '%s' and",courseid.toString());
        String cityQ = city.toString().isEmpty()?"":String.format("city = '%s'",city.toString());


        Cursor record = database.rawQuery(String.format("select * from users where email = '%s'",email),null);
        if(record.getCount() > 0){
            return record;
        }
        else {
            return null;
        }
    }
}
