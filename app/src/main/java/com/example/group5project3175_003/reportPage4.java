package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class reportPage4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page4);














        ImageView btnTracker_rpt4 = findViewById(R.id.btnTracker_rpt4);
        ImageView btnbig_rpt4 = findViewById(R.id.btnbig_rpt4);
        ImageView btnReport_rpt4 = findViewById(R.id.btnReport_rpt4);
        ImageView btnSetting_rpt4 = findViewById(R.id.btnSetting_rpt4);

        btnTracker_rpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage4.this, MainActivity.class));
            }
        });

        btnbig_rpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage4.this, big1.class));
            }
        });

        btnReport_rpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage4.this, reportMain.class));
            }
        });

        btnSetting_rpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage4.this, SettingPage1.class));
            }
        });


    }
}