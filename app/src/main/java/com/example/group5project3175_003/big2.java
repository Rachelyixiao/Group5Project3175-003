package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class big2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_expense_page2);

        ImageView btnTracker_big2 = findViewById(R.id.btnTracker_big2);
        ImageView btnBig_big2 = findViewById(R.id.btnBig_big2);
        ImageView btnReport_big2 = findViewById(R.id.btnReport_big2);
        ImageView btnSetting_big2 = findViewById(R.id.btnSetting_big2);

        btnTracker_big2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big2.this, MainActivity.class));
            }
        });

        btnBig_big2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big2.this, big1.class));
            }
        });

        btnReport_big2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big2.this, reportMain.class));
            }
        });

        btnSetting_big2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big2.this, SettingPage1.class));
            }
        });



    }
}