package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingPage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page3);


        ImageView btnTracker_set1 = findViewById(R.id.btnTracker_set1);
        ImageView btnBig_set1 = findViewById(R.id.btnBig_set1);
        ImageView btnReport_set1 = findViewById(R.id.btnReport_set1);
        ImageView btnSetting_set1 = findViewById(R.id.btnSetting_set1);

        btnTracker_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage3.this, MainActivity.class));
            }
        });

        btnBig_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage3.this, bigExpensePage1.class));
            }
        });

        btnReport_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage3.this, reportMain.class));
            }
        });

        btnSetting_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage3.this, SettingPage1.class));
            }
        });

    }
}