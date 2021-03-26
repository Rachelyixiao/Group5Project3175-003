package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class reportPage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page3);















        ImageView btnTracker_rpt3 = findViewById(R.id.btnTracker_rpt3);
        ImageView btnbig_rpt3 = findViewById(R.id.btnbig_rpt3);
        ImageView btnReport_rpt3 = findViewById(R.id.btnReport_rpt3);
        ImageView btnSetting_rpt3 = findViewById(R.id.btnSetting_rpt3);

        btnTracker_rpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage3.this, MainActivity.class));
            }
        });

        btnbig_rpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage3.this, big1.class));
            }
        });

        btnReport_rpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage3.this, reportMain.class));
            }
        });

        btnSetting_rpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage3.this, SettingPage1.class));
            }
        });
    }
}