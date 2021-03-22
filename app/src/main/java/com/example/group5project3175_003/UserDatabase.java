package com.example.group5project3175_003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class UserDatabase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Userinfor.db";
    final static int DATABASE_VERSION = 4;
    final static String TABLE1_NAME = "Userinf";
    final static String T1COL_0 = "Id";
    final static String T1COL_1 = "FName";
    final static String T1COL_2 = "LName";
    final static String T1COL_3 = "Email";
    final static String T1COL_4 = "Password";
    final static String T1COL_5 = "Currency";
//    final static String T1COL_6 = "Language";
    final static String T1COL_6 = "Alarm";
//    final static String T1COL_7 = "Dark_mode";
    final static String T1COL_7 = "Account_Name";
    final static String T1COL_8 = "Salary";
    final static String T1COL_9 = "Additional_Income";
    final static String T1COL_10 = "Saving";

    final static String TABLE2_NAME = "BigExpense";
    final static String T2COL_0 ="Id";
    final static String T2COL_1 ="BID";
    final static String T2COL_2 ="FinishDate";
    final static String T2COL_3 = "Category";
    final static String T2COL_4 = "Description";

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
                T1COL_4 + " TEXT,"+
                T1COL_5 + " TEXT,"+
                T1COL_6 + " TEXT,"+
                T1COL_7 + " TEXT,"+
                T1COL_8 + " INTEGER,"+
                T1COL_9 + " INTEGER,"+
                T1COL_10 + " INTEGER)";
        db.execSQL(query);

        String bquery = "CREATE TABLE "+TABLE2_NAME+"("+
                T2COL_0 + " INTEGER,"+
                T2COL_1 + " INTEGER,"+
                T2COL_2 + " TEXT,"+
                T2COL_3 + " TEXT,"+
                T2COL_4 + " TEXT,"+
                "PRIMARY KEY ("+T2COL_0+","+T2COL_1+"),"+
                "FOREIGN KEY ("+T2COL_0+")"+" REFERENCES "+TABLE1_NAME+"("+T1COL_0+"))";

        db.execSQL(bquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+TABLE2_NAME);
            onCreate(db);
    }
    public boolean add(String fn,String ln,String email, String psw,String curr,String ala,String acname,int Salary,int Additional_Income ,int Saving){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_1,fn);
        values.put(T1COL_2,ln);
        values.put(T1COL_3,email);
        values.put(T1COL_4,psw);
        values.put(T1COL_5,curr);
        values.put(T1COL_6,ala);
        values.put(T1COL_7,acname);
        values.put(T1COL_8,Salary);
        values.put(T1COL_9,Additional_Income);
        values.put(T1COL_10,Saving);

        long r = sqLiteDatabase.insert(TABLE1_NAME, null, values);
        return r > 0;
    }

    public boolean addBig(Date fd, String categ, String desB){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2COL_2, String.valueOf(fd));
        values.put(T2COL_3,categ);
        values.put(T2COL_4,desB);

        long r = sqLiteDatabase.insert(TABLE2_NAME,null,values);
        return r >0;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE1_NAME;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }
//    public Cursor changeData(){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        String query = "SELECT * FROM "+ TABLE1_NAME;
//        Cursor a = sqLiteDatabase.replace(TABLE1_NAME,"");
}
