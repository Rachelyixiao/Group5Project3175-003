package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class reportPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page1);

        TextView userFullname= findViewById(R.id.txtUname);
        TextView monthSaving = findViewById(R.id.txtMonthSavingOutput);
        TextView monthIncomeBalance = findViewById(R.id.txtMonthInOutput);
       // TextView monthExpense = findViewById(R.id.txtMonthExOutput);

        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");
        UserDatabase userdatabase = new UserDatabase(this);

        int positionId = Integer.parseInt(loginID)-1;
        Cursor c = userdatabase.viewData();
        c.moveToPosition(positionId);

        String userFName = c.getString(1);
        String userLname = c.getString(2);
        double userIncome = c.getDouble(8);
        double UserSaving = c.getDouble(9);

        userFullname.setText("Hello! "+userFName +" "+userLname);
        monthIncomeBalance.setText("You income balance is :"+userIncome);
        monthSaving.setText("Your saving is :"+UserSaving);
        //monthExpense.setText("Your expense is "+ )


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