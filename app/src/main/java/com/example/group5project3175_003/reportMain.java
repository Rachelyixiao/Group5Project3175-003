package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class reportMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_main);

        ImageView btnTracker_rpt1 = findViewById(R.id.btnTracker_rpt1);
        ImageView btnbig_rpt1 = findViewById(R.id.btnbig_rpt1);
        ImageView btnReport_rpt1 = findViewById(R.id.btnReport_rpt1);
        ImageView btnSetting_rpt1 = findViewById(R.id.btnSetting_rpt1);

        btnTracker_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, MainActivity.class));
            }
        });

        btnbig_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, bigExpensePage1.class));
            }
        });

        btnReport_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, reportMain.class));
            }
        });

        btnSetting_rpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, SettingPage1.class));
            }
        });

    }
}