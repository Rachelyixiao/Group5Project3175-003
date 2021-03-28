package com.example.group5project3175_003;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class reportPage4 extends AppCompatActivity {
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page4);

        EditText reportStart = findViewById(R.id.txtSDate);
        EditText reportEnd = findViewById(R.id.txtEdate);

        Button btnR4 = findViewById(R.id.btnR4submit);
        TextView outputR4 = findViewById(R.id.textOutputR4);

        reportStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c1 = Calendar.getInstance();
                int reportSYear = c1.get(Calendar.YEAR);
                int reportSMonth = c1.get(Calendar.MONTH);
                int reportSDay = c1.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(reportPage4.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                reportStart.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, reportSYear, reportSMonth, reportSDay);
                datePickerDialog.show();
            }
        });

        reportEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c2 = Calendar.getInstance();
                int reportEYear = c2.get(Calendar.YEAR);
                int reportEMonth = c2.get(Calendar.MONTH);
                int reportEDay = c2.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(reportPage4.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                reportEnd.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, reportEYear, reportEMonth, reportEDay);
                datePickerDialog.show();
            }
        });



        btnR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = reportStart.getText().toString();
                String endDate = reportEnd.getText().toString();
                outputR4.setText("Your report date is "+startDate+" "+endDate);
            }
        });



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