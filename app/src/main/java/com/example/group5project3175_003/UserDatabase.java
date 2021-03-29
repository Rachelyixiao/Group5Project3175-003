package com.example.group5project3175_003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import java.util.Date;
import java.util.concurrent.Callable;

public class UserDatabase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Userinfor.db"; //database name
    final static int DATABASE_VERSION = 2;              //database version
    final static String TABLE1_NAME = "Userinf";        //table 1 user table
    //User table columns name
    final static String T1COL_0 = "UID";
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


    final static String TABLE2_NAME = "TransactionTable";  // table 2 transaction table
    //Transaction table columns name
    final static String T2COL_0 = "TID";
    final static String T2COL_1 = "Type";
    final static String T2COL_2 = "T_Category";
    final static String T2COL_3 = "Amount";
    final static String T2COL_4 = "Balance";
    final static String T2COL_5 = "Frequency";
    final static String T2COL_6 = "Date";
    final static String T2COL_7 = "Description";
    final static String T2COL_8 = "T_UID";


    final static String TABLE3_NAME = "BigExpense";  // table 3 big expense table
    final static String T3COL_0 ="BID";
    final static String T3COL_1 ="FinishDate";
    final static String T3COL_2 = "Category";
    final static String T3COL_3 = "Description";
    final static String T3COL_4 = "B_UID";

    //table 4 daily expense table
    final static String TABLE4_NAME = "DE";
    final static String T4COL_0 ="DEid";
    final static String T4COL_1 = "DEname";
    final static String T4COL_2 = "DEDate";
    final static String T4COL_3 = "DE_Category";
    final static String T4COL_4 = "DE_amount";
    final static String T4COL_5 = "DE_UID";


    //Table 5 monthly bill table
    final static String TABLE5_NAME = "MB";
    final static String T5COL_0 = "BillID";
    final static String T5COL_1 = "Billname";
    final static String T5COL_2 = "BillDate";
    final static String T5COL_3 = "BillAmount";
    final static String T5COL_4 = "Bill_UID";

    //Table 6 account table
    final static String TABLE6_NAME = "Account";
    final static String T6COL_0 = "ACC_ID";
    final static String T6COL_1 = "AName";
    final static String T6COL_2 = "AAmount";
    final static String T6COL_3 = "A_UID";



    public UserDatabase(@Nullable Context context){
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE "+ TABLE1_NAME + "("+
                T1COL_0 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T1COL_1 + " TEXT,"+
                T1COL_2 + " TEXT,"+
                T1COL_3 + " TEXT NOT NULL,"+
                T1COL_4 + " TEXT,"+
                T1COL_5 + " TEXT,"+
                T1COL_6 + " TEXT,"+
                T1COL_7 + " TEXT,"+
                T1COL_8 + " INTERGER,"+
                T1COL_9 + " INTERGER,"+
                T1COL_10 + " INTERGER)";
        db.execSQL(query1);

        String query2 = "CREATE TABLE "+ TABLE2_NAME + "("+
                T2COL_0 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T2COL_1 + " TEXT,"+
                T2COL_2 + " TEXT,"+
                T2COL_3 + " REAL NOT NULL,"+
                T2COL_4 + " REAL,"+
                T2COL_5 + " TEXT,"+
                T2COL_6 + " TEXT,"+
                T2COL_7 + " TEXT,"+
                T2COL_8 + " INTEGER,"+
                " FOREIGN KEY ("+T2COL_8+") REFERENCES "+TABLE1_NAME+"("+T1COL_0+"));";
        db.execSQL(query2);

        String query3 = "CREATE TABLE "+ TABLE3_NAME+"("+
                T3COL_0 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T3COL_1 +" TEXT,"+
                T3COL_2 +" TEXT,"+
                T3COL_3 +" TEXT,"+
                T3COL_4 +" INTEGER,"+
                " FOREIGN KEY ("+T3COL_4+") REFERENCES "+TABLE1_NAME+"("+T1COL_0+"));";
        db.execSQL(query3);


        String query4 = "CREATE TABLE "+ TABLE4_NAME+"("+
                T4COL_0 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T4COL_1 +" TEXT,"+
                T4COL_2 +" TEXT,"+
                T4COL_3 +" TEXT,"+
                T4COL_4 +" REAL,"+
                T4COL_5 +" INTEGER,"+
                " FOREIGN KEY ("+T4COL_5+") REFERENCES "+TABLE1_NAME+"("+T1COL_0+"));";
        db.execSQL(query4);

        String query5 = "CREATE TABLE "+ TABLE5_NAME+"("+
                T5COL_0 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T5COL_1 +" TEXT,"+
                T5COL_2 +" TEXT,"+
                T5COL_3 +" REAL,"+
                T5COL_4 +" INTEGER,"+
                " FOREIGN KEY ("+T5COL_4+") REFERENCES "+TABLE1_NAME+"("+T1COL_0+"));";
        db.execSQL(query5);

        String query6 = "CREATE TABLE "+ TABLE6_NAME+"("+
                T6COL_0 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T6COL_1 +" TEXT,"+
                T6COL_2 +" REAL,"+
                T6COL_3 +" INTEGER,"+
                " FOREIGN KEY ("+T6COL_3+") REFERENCES "+TABLE1_NAME+"("+T1COL_0+"));";
        db.execSQL(query6);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE4_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE5_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE6_NAME);
        onCreate(db);
    }

    public boolean add(String fn,String ln,String email, String psw,String curr,String ala,
                       String acname,int Salary,int Additional_Income,int Saving){
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
        return r>0;
    }

    public boolean addBig(String date,String categ,String Desc,int b_uid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T3COL_1,date);
        values.put(T3COL_2,categ);
        values.put(T3COL_3,Desc);
        values.put(T3COL_4,b_uid);

        long r = sqLiteDatabase.insert(TABLE3_NAME,null,values);
        if(r>0)
            return  true;
        else
            return  false;
    }

    public boolean addEx(String n,String d,String c,double a,int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T4COL_1,n);
        values.put(T4COL_2,d);
        values.put(T4COL_3,c);
        values.put(T4COL_4,a);
        values.put(T4COL_5,id);
        long r = sqLiteDatabase.insert(TABLE4_NAME,null,values);
        if(r>0)
            return  true;
        else
            return  false;
    }

    public boolean addBill(String n,String d,double a,int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T5COL_1,n);
        values.put(T5COL_2,d);
        values.put(T5COL_3,a);
        values.put(T5COL_4,id);

        long r = sqLiteDatabase.insert(TABLE5_NAME,null,values);
        if(r>0)
            return  true;
        else
            return  false;
    }

    public boolean addAccount(String n,double a,int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T6COL_1, n);
        values.put(T6COL_2,a);
        values.put(T6COL_3,id);
        long r = sqLiteDatabase.insert(TABLE6_NAME,null,values);
        if(r>0)
            return  true;
        else
            return  false;

    }

    public Cursor aggregateExpense(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT DE_UID,SUM(DE_amount) FROM "+TABLE4_NAME+
                " GROUP BY DE_UID",null);
        return c;
    }


 /*   public boolean addTransaction(String type,String tcate,double amount,double balance,String fre,String t_date,String t_desc,int t_uid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T2COL_1,type);
        values.put(T2COL_2,tcate);
        values.put(T2COL_3,amount);
        values.put(T2COL_4,balance);
        values.put(T2COL_5,fre);
        values.put(T2COL_6,t_date);
        values.put(T2COL_7,t_desc);
        values.put(T2COL_8,t_uid);

        long r = sqLiteDatabase.insert(TABLE2_NAME,null,values);
        if(r>0)
            return  true;
        else
            return  false;
    }
*/

    //view data
    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE1_NAME;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }

    public Cursor viewBig(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE3_NAME +" WHERE B_UID = "+ id
                + " AND FinishDate LIKE '2021/3%'",null);
        return c;
    }

    public Cursor viewEx(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE4_NAME +" WHERE DE_UID = "+ id
                + " AND DEDate LIKE '2021/3%'",null);
        return c;
    }

    public Cursor viewBill(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE5_NAME+ " WHERE Bill_UID = "+id,null);
        return  c;
    }

/*
    public Cursor viewCombineData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT FName,LName,Account_Name,FinishDate " +
                "FROM Userinf INNER JOIN BigExpense ON Userinf.UID = BigExpense.B_UID",null);
        return c;
    }

 */
    public boolean deleteUserData(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int d = sqLiteDatabase.delete(TABLE1_NAME,"UID=?",new String[]{Integer.toString(id)});
        if(d>0)
            return true;
        else
            return false;
    }


    public boolean deleteBig(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int d = sqLiteDatabase.delete(TABLE3_NAME,"BID=?",new String[]{Integer.toString(id)});
        if(d>0)
            return true;
        else
            return false;
    }

    public boolean deleteTranscation(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int d = sqLiteDatabase.delete(TABLE2_NAME,"TID=?",new String[]{Integer.toString(id)});
        if(d>0)
            return true;
        else
            return false;
    }

    public boolean updateUserData(String loginID,String sAcName,String sFName,String sLName,String sEmail,String sPsw,String setAlarm){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        if (!sAcName.isEmpty()) {
            values.put(T1COL_7, sAcName);
        }
        if (!sFName.isEmpty()) {
            values.put(T1COL_1, sFName);
        }
        if (!sLName.isEmpty()) {
            values.put(T1COL_2, sLName);
        }
        if (!sEmail.isEmpty()) {
            values.put(T1COL_3, sEmail);
        }
        if (!sPsw.isEmpty()) {
            values.put(T1COL_4, sPsw);
        }
        if (setAlarm.equals("On")) {
            values.put(T1COL_6,"On");
        }
        else{
            values.put(T1COL_6,"Off");
        }
        int d =sqLiteDatabase.update("Userinf",values,"UID=?",new String[]{loginID});


            return d>0;


    }

    public  boolean updateBigDate(int id,String date,String cate,String des){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T3COL_1,date);
        values.put(T3COL_2,cate);
        values.put(T3COL_3,des);
        int d = sqLiteDatabase.update(TABLE3_NAME,values,"BID=?",new String[]{Integer.toString(id)});
        if(d>0)
            return true;
        else
            return false;
    }
}
