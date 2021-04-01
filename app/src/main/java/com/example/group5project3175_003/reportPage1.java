package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class reportPage1 extends AppCompatActivity {
    double totalBill;
    double totalDailyExpense;
    double totalMExpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page1);

        TextView userFullname= findViewById(R.id.txtUname);
        TextView monthSaving = findViewById(R.id.txtMonthSavingOutput);
        TextView monthIncomeBalance = findViewById(R.id.txtMonthInOutput);
        TextView monthExpense = findViewById(R.id.txtMonthExOutput);
        TextView monthBill = findViewById(R.id.txtBill);
        TextView monthDEX = findViewById(R.id.txtExOut);

        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");
        UserDatabase userdatabase = new UserDatabase(this);

        int positionId = Integer.parseInt(loginID)-1;
        Cursor c = userdatabase.viewData();
        c.moveToPosition(positionId);

        String userFName = c.getString(1);
        String userLname = c.getString(2);
        double UserBalance = c.getDouble(10);
        double UserSaving = c.getDouble(9);

        //get the monthly bill total amount of the login user
        SQLiteDatabase sqLiteDatabase = userdatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("MB",null,"Bill_UID=?",new String[]{loginID},null,null,null);
        if(cursor.moveToFirst()){
            totalBill = 0;
            do{
                int billid = cursor.getInt(cursor.getColumnIndex("BillID"));
                String name = cursor.getString(cursor.getColumnIndex("Billname"));
                String date =cursor.getString(cursor.getColumnIndex("BillDate"));
                double amount = cursor.getDouble(cursor.getColumnIndex("BillAmount"));
                int uid = cursor.getInt(cursor.getColumnIndex("Bill_UID"));
                totalBill +=amount;
            }while(cursor.moveToNext());
            Toast.makeText(reportPage1.this,"totalbill:"+totalBill,Toast.LENGTH_LONG).show();
        }
        cursor.close();

        //get the daily expense total amount of the login user
        Cursor cursor1 = sqLiteDatabase.query("DE",null,"DE_UID=?",new String[]{loginID},null,null,null,null);
        if(cursor1.moveToFirst()){
            totalDailyExpense = 0;
            do{
                int DEid = cursor1.getInt(cursor1.getColumnIndex("DEid"));
                String dename = cursor1.getString(cursor1.getColumnIndex("DEname"));
                String dedate = cursor1.getString(cursor1.getColumnIndex("DEDate"));
                String de_cate = cursor1.getString(cursor1.getColumnIndex("DE_Category"));
                double deAmount = cursor1.getDouble(cursor1.getColumnIndex("DE_amount"));
                int DE_UID = cursor1.getInt(cursor1.getColumnIndex("DE_UID"));
                totalDailyExpense+=deAmount;
            }while(cursor1.moveToNext());
        }
        cursor1.close();

        totalMExpense = totalBill+totalDailyExpense;

        userFullname.setText("Hello! "+userFName +" "+userLname);
        monthIncomeBalance.setText("You balance is :"+UserBalance);
        monthSaving.setText("Your saving is :"+UserSaving);
        monthExpense.setText("Your monthly total Expense is "+totalMExpense);
        monthBill.setText("Your monthly bill is "+ totalBill );
        monthDEX.setText("Your month expense is "+totalDailyExpense);


        ImageView btnTracker_rpt1 = findViewById(R.id.btnTracker_rpt1);
        ImageView btnbig_rpt1 = findViewById(R.id.btnbig_rpt1);
        ImageView btnReport_rpt1 = findViewById(R.id.btnReport_rpt1);
        ImageView btnSetting_rpt1 = findViewById(R.id.btnSetting_rpt1);



        btnTracker_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage1.this, MainActivity.class));
            }
        });

        btnbig_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage1.this, big1.class));
            }
        });

        btnReport_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage1.this, reportMain.class));
            }
        });

        btnSetting_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage1.this, SettingPage1.class));
            }
        });









    }
}