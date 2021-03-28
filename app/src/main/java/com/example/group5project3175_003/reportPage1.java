package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class reportPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page1);

        TextView monthSaving = findViewById(R.id.txtMonthSavingOutput);
        TextView monthExpense = findViewById(R.id.txtMonthExOutput);



        monthSaving.setText("You expense of ");
        monthExpense.setText("Your saving of ");










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