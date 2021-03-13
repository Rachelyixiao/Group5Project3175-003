package com.example.group5project3175_003;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Userinfor.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME = "Userinf";
    final static String T1COL_0 = "Id";
    final static String T1COL_1 = "FName";
    final static String T1COL_2 = "LName";
    final static String T1COL_3 = "Email";
    final static String T1COL_4 = "Password";

    public UserDatabase(@Nullable Context context){
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE1_NAME + "("+
                T1COL_0 + " INTEGER PRIMARY KEY,"+
                T1COL_1 + " TEXT,"+
                T1COL_2 + " TEXT,"+
                T1COL_3 + " TEXT,"+
                T1COL_4 + " TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
            onCreate(db);
    }
    public boolean add(String fn,String ln,String email, String psw){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_1,fn);
        values.put(T1COL_2,ln);
        values.put(T1COL_3,email);
        values.put(T1COL_4,psw);

        long r = sqLiteDatabase.insert(TABLE1_NAME, null, values);
        if (r>0)
            return true;
        else
            return false;
    }
}
