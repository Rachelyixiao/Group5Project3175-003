package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class transactionR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_r);

        Button btnTrack1 = findViewById(R.id.btnTrace1);
        Button btnTrack2 = findViewById(R.id.btnTrace2);

        btnTrack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, RecurrintBill.class));
            }
        });

        btnTrack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, DailyExpense.class));
            }
        });



        ImageView btnTracker_R = findViewById(R.id.btnTrackerR);
        ImageView btnbig_R = findViewById(R.id.btnBigR);
        ImageView btnReport_R = findViewById(R.id.btnReportR);
        ImageView btnSetting_R = findViewById(R.id.btnSettingsR);



        btnTracker_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, MainActivity.class));
            }
        });

        btnbig_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, big1.class));
            }
        });

        btnReport_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, reportMain.class));
            }
        });

        btnSetting_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, SettingPage1.class));
            }
        });



    }
}