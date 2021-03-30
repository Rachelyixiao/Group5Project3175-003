package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class reportPage2 extends AppCompatActivity {
    private PieChart pieChart;
    UserDatabase userdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page2);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");
        int useId = Integer.parseInt(loginId.getString("loginId",""));
    //    int positionId = Integer.parseInt(loginID)-1;

        //     exOutput.setText(stringBuilder);

        Cursor c = userdatabase.viewBill(useId);
        ArrayList<String> billName = new ArrayList<>();
        ArrayList<String> billAmount = new ArrayList<>();
        while(c.moveToNext()){
            billName.add(c.getString(1));
            billAmount.add(c.getString(3));
        }

        double totalBill = getTotal(billAmount);

       // Toast.makeText(reportPage2.this, (int) totalBill,Toast.LENGTH_LONG).show();
   //     for(String i : billAmount){
     //       Toast.makeText(reportPage2.this,i,Toast.LENGTH_LONG).show();
       // }

    //    double totalBill = getTotal(billAmount);

   /*     HashMap<String,String> bill = new HashMap<>();

        while(c.moveToNext()){
            bill.put(c.getString(1),c.getString(3));
        }

        for(String i : bill.keySet()){
            Toast.makeText(reportPage2.this,i,Toast.LENGTH_LONG).show();
        }

*/

        pieChart= (PieChart) findViewById(R.id.report_pie_chart);
        pieChart.setUsePercentValues(true);
        pieChart.setDescription("Fixed Spending over a month");
        pieChart.setDescriptionColor(Color.WHITE);
        pieChart.setDescriptionTextSize(50);

        pieChart.setExtraOffsets(5,5,5,5);

        pieChart.setDrawCenterText(true);
        pieChart.setCenterTextColor(Color.RED);
        pieChart.setCenterTextSize(30);

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
        pieChart.setEntryLabelTextSize(20f);

        // pieChart.setOnChartValueSelectedListener(this);
        pieChart.animateY(3400, Easing.EasingOption.EaseInQuad);
        ArrayList<PieEntry> pieEntries = new ArrayList<PieEntry>();

        for(int i = 0;i<billName.size();i++){
            pieEntries.add(new PieEntry((float) (Double.parseDouble(billAmount.get(i))/totalBill), billName.get(i)));
        }
/*
        pieEntries.add( new PieEntry(24,"Income"));//can change the value and label
        pieEntries.add( new PieEntry(25,"Expense"));
        pieEntries.add( new PieEntry(28,"Saving"));
        pieEntries.add( new PieEntry(22,"Others"));
*/
        String centerText = String.valueOf(totalBill);//this is the central text, can be changed
        pieChart.setCenterText(centerText);
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // COLOR
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(22,168,233));
        pieDataSet.setColors(colors);

        pieDataSet.setSliceSpace(0f);
        pieDataSet.setSelectionShift(5f);
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        //
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(25f);
        pieData.setValueTextColor(Color.BLACK);

        pieChart.setData(pieData);
        // undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();



        //botton navigator
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

    public double getTotal(ArrayList<String> arrayList){
        double sum = 0;
        for(int i=0;i<arrayList.size();i++){
            sum+=Double.parseDouble(arrayList.get(i));
        }
        return sum;
    }
}