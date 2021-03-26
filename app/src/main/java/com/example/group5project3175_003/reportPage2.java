package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class reportPage2 extends AppCompatActivity {
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page2);

        pieChart= (PieChart) findViewById(R.id.report_pie_chart);
        pieChart.setUsePercentValues(true);
        pieChart.setDescription("Fixed Spending over a month");
        pieChart.setDescriptionColor(Color.WHITE);
        pieChart.setDescriptionTextSize(30);

        pieChart.setExtraOffsets(5,5,5,5);

        pieChart.setDrawCenterText(true);
        pieChart.setCenterTextColor(Color.RED);
        pieChart.setCenterTextSize(15);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setHoleRadius(40f);

        pieChart.setTransparentCircleColor(Color.BLACK);
        pieChart.setTransparentCircleAlpha(100);
        pieChart.setTransparentCircleRadius(40f);

        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setRotationAngle(10);

        pieChart.setHighlightPerTapEnabled(true);

        // entry label styling
        pieChart.setDrawEntryLabels(true);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(10f);

        // pieChart.setOnChartValueSelectedListener(this);
        pieChart.animateY(3400, Easing.EasingOption.EaseInQuad);
        ArrayList<PieEntry> pieEntries = new ArrayList<PieEntry>();
        pieEntries.add( new PieEntry(24,"Income"));//can change the value and label
        pieEntries.add( new PieEntry(25,"Expense"));
        pieEntries.add( new PieEntry(28,"Saving"));
        pieEntries.add( new PieEntry(22,"Others"));

        String centerText = "2020 March\n$"+12000;//this is the central text, can be changed
        pieChart.setCenterText(centerText);
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // COLOR
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        pieDataSet.setColors(colors);

        pieDataSet.setSliceSpace(0f);
        pieDataSet.setSelectionShift(5f);
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        //
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(15f);
        pieData.setValueTextColor(Color.BLUE);

        pieChart.setData(pieData);
        // undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();














        ImageView btnTracker_rpt2 = findViewById(R.id.btnTracker_rpt2);
        ImageView btnbig_rpt2 = findViewById(R.id.btnbig_rpt2);
        ImageView btnReport_rpt2 = findViewById(R.id.btnReport_rpt2);
        ImageView btnSetting_rpt2 = findViewById(R.id.btnSetting_rpt2);

        btnTracker_rpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage2.this, MainActivity.class));
            }
        });

        btnbig_rpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage2.this, big1.class));
            }
        });

        btnReport_rpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage2.this, reportMain.class));
            }
        });

        btnSetting_rpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportPage2.this, SettingPage1.class));
            }
        });
    }
}