package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class reportMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_main);

        ImageView btnTracker_rpt = findViewById(R.id.btnTracker_rpt);
        ImageView btnbig_rpt = findViewById(R.id.btnbig_rpt);
        ImageView btnReport_rpt = findViewById(R.id.btnReport_rpt);
        ImageView btnSetting_rpt = findViewById(R.id.btnSetting_rpt);



        RadioButton radR1 = findViewById(R.id.radReport1);
        RadioButton radR2 = findViewById(R.id.radReport2);
        RadioButton radR3 = findViewById(R.id.radReport3);
        RadioButton radR4 = findViewById(R.id.radReport4);


        btnTracker_rpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, MainActivity.class));
            }
        });

        btnbig_rpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, big1.class));
            }
        });

        btnReport_rpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, reportMain.class));
            }
        });

        btnSetting_rpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportMain.this, SettingPage1.class));
            }
        });


    }

    public void aMethodReport(View view){

        switch (view.getId()){
            case(R.id.radReport1):
                    startActivity(new Intent(reportMain.this,reportPage1.class));
                break;

            case(R.id.radReport2):
                    startActivity(new Intent(reportMain.this,reportPage2.class));
                break;

            case(R.id.radReport3):
                    startActivity(new Intent(reportMain.this,reportPage3.class));

            case(R.id.radReport4):
                    startActivity(new Intent(reportMain.this, reportPage4.class));
                break;

        }



    }


}