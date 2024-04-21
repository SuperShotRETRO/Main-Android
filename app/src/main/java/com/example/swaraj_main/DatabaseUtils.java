package com.example.swaraj_main;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseUtils extends SQLiteOpenHelper {

    SQLiteDatabase database;
    public DatabaseUtils(@Nullable Context context) {
        super(context, "mcaDb", null, 1);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(rollno integer primary key autoincrement, name varchar, email varchar, password varchar, course varchar, courseid varchar, city varchar)");
        db.execSQL("create table faculty(facid integer primary key autoincrement, name varchar, email varchar,password varchar);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @SuppressLint("Range")
    public ArrayList<String> fetchTables(){
        ArrayList<String> tableNAmes = new ArrayList<String>();
        Cursor tables = database.rawQuery("select name from sqlite_master where type='table'",null);
        if(tables.moveToFirst()){
            while(!tables.isAfterLast()){
                tableNAmes.add(tables.getString(tables.getColumnIndex("name")));
                tables.moveToNext();
            }
            return tableNAmes;
        }
        else {
            return null;
        }
    }

    public boolean register(String tableName,String  name,String email, String password,String course, String courseid, String city){

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("course",course);
        cv.put("courseid",courseid);
        cv.put("city",city);

        long res = database.insert(tableName,null,cv);

        if(res == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public Cursor getRecords(String tableName){

        Cursor record = database.rawQuery(String.format("select * from %s",tableName),null);
        if(!(record.getCount() == 0)){
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

    public boolean updateRecord(String tableName,Integer rollno, String name,String email, String password,String course, String courseid, String city){

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("course",course);
        cv.put("courseid",courseid);
        cv.put("city",city);

        long res = database.update(tableName,cv,"rollno=?",new String[]{rollno.toString()});

        if(res == 1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean deleteRecord(String tableName,Integer rollno){

        long res = database.delete(tableName,"rollno=?",new String[]{rollno.toString()});

        if(res == 1){
            return false;
        }
        else {
            return true;
        }
    }
}
