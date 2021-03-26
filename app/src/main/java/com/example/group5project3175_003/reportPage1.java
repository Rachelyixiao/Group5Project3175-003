package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class reportPage1 extends AppCompatActivity {
 //   private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page1);


     /*   barChart = (BarChart) findViewById(R.id.barchart_report);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(8f, 0));
        entries.add(new BarEntry(2f, 1));
        entries.add(new BarEntry(5f, 2));
        entries.add(new BarEntry(20f, 3));
        entries.add(new BarEntry(15f, 4));
        entries.add(new BarEntry(19f, 5));

        BarDataSet bardataset = new BarDataSet(entries, "Expenses");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Bill");
        labels.add("Transportation");
        labels.add("Cell");
        labels.add("Rental");
        labels.add("Utility");
        labels.add("Others");

        BarData data = new BarData((IBarDataSet) labels, bardataset);
        barChart.setData(data); // set the data and list of labels into chart
        barChart.setDescription("Fixed Expenses");  // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(5000);
*/
      //  entries.add(new BarEntry(8f, 0));

      //  labels.add("2016");


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