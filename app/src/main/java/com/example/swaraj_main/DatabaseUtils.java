package com.example.swaraj_main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseUtils extends SQLiteOpenHelper {

    SQLiteDatabase database;
    public DatabaseUtils(@Nullable Context context) {
        super(context, "mca.db", null, 1);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(rollno integer primary key autoincrement, name varchar, email varchar, password varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean register(String name,String email, String password){

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("password",password);

        long res = database.insert("users",null,cv);

        if(res == 1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getRecords(){

        return database.query("users",);
    }
}
