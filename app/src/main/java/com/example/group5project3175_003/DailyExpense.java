package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DailyExpense extends AppCompatActivity {
    UserDatabase userdatabase;
    DatePickerDialog datePickerDialog;

    String exName;
    String exCate;
    String exDate;
    Double exAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_expense);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);

        EditText dailyEname = findViewById(R.id.txtEname);
        EditText dailyDate = findViewById(R.id.txtExDate);
        Spinner dailyCatGroup = findViewById(R.id.expenseGroup);
        EditText dailyAm = findViewById(R.id.txtEAmount);
        Button btnDAdd = findViewById(R.id.btnEadd);
        Button btnDView = findViewById(R.id.btnEView);
        Button btnTest = findViewById(R.id.btnCalTotalExpense);


        //Use Calendar and datePickerDialog To get the date
        dailyDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar ce = Calendar.getInstance();
                int exyear = ce.get(Calendar.YEAR);
                int exMonth = ce.get(Calendar.MONTH);
                int exday = ce.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(DailyExpense.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dailyDate.setText(year + "/"
                                        + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, exyear, exMonth, exday);
                datePickerDialog.show();
            }
        });

        int DE_UID = Integer.parseInt(loginId.getString("loginId",""));

        btnDAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted;

                exName = dailyEname.getText().toString();
                exCate = dailyCatGroup.getSelectedItem().toString();
                exAmount = Double.parseDouble(dailyAm.getText().toString());
                exDate = dailyDate.getText().toString();
                int DE_UID = Integer.parseInt(loginId.getString("loginId",""));

                isInserted = userdatabase.addEx(exName,exDate,exCate,exAmount,DE_UID);
                if(isInserted){
                    Toast.makeText(DailyExpense.this,"Big expense added",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(DailyExpense.this, "Big expenses not added", Toast.LENGTH_LONG).show();
                }

            }
        });

        TextView exOutput = findViewById(R.id.exOut);

        btnDView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cEx = userdatabase.viewEx(DE_UID);
                StringBuilder stringBuilder = new StringBuilder();
                while(cEx.moveToNext()){
                    stringBuilder.append("\nDE_ID :"+cEx.getInt(0)+
                            " Name :"+cEx.getString(1)+
                            " Date :"+cEx.getString(2)+
                            " Category :"+cEx.getString(3)+
                            " Amount :"+cEx.getDouble(4));
                }
           //     exOutput.setText(stringBuilder);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c= userdatabase.aggregateExpense();
                StringBuilder stringBuilder = new StringBuilder();
                while(c.moveToNext()){
                    stringBuilder.append("\nDE_ID :"+c.getInt(0)+
                            " Name :"+c.getString(1)+
                            " Date :"+c.getString(2)+
                            " Category :"+c.getString(3)+
                            " Amount :"+c.getDouble(4));
                }
                exOutput.setText(stringBuilder);

            }
        });










    }
}