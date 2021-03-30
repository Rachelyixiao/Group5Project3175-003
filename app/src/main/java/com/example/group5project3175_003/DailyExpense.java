package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.effect.Effect;
import android.media.effect.EffectFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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
    int dayRemain;
    double newdailyAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_expense);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");

        int useId = Integer.parseInt(loginId.getString("loginId",""));
        int positionId = Integer.parseInt(loginID)-1;

        Cursor c = userdatabase.viewData();
        c.moveToPosition(positionId);

        double userIncome = c.getDouble(8);
        double UserSaving = c.getDouble(9);


        EditText dailyEname = findViewById(R.id.txtEname);
        EditText dailyDate = findViewById(R.id.txtExDate);
        Spinner dailyCatGroup = findViewById(R.id.expenseGroup);
        EditText dailyAm = findViewById(R.id.txtEAmount);
        Button btnDAdd = findViewById(R.id.btnEadd);
        Button btnDView = findViewById(R.id.btnEView);
        Button btnTest = findViewById(R.id.btnCalTotalExpense);

        TextView exOutput = findViewById(R.id.exOut);


   /*     dailyAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor  c = userdatabase.viewEx(useId);
                double TotalExpense =0;
                while (c.moveToNext()){
                    TotalExpense += c.getDouble(4);
                }
                Toast.makeText(DailyExpense.this, Double.toString(TotalExpense), Toast.LENGTH_SHORT).show();
            }
        });
*/
        //Use Calendar to get the current date
        dailyDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar ce = Calendar.getInstance();
                int exyear = ce.get(Calendar.YEAR);
                int exMonth = ce.get(Calendar.MONTH);
                int exday = ce.get(Calendar.DAY_OF_MONTH);

                // get the last day of the month
                int last = ce.getActualMaximum(ce.DAY_OF_MONTH);

                dailyDate.setText(exyear+"/"+(exMonth+1)+"/"+exday);

                dayRemain = last - exday;

           /*
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
             */
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

                double dailyAllowed;
                dailyAllowed = userIncome/dayRemain;

                if(exAmount<dailyAllowed){
                    double newSaving = UserSaving + (dailyAllowed-exAmount);
                    userdatabase.updateUserSavingData(loginId.getString("loginId",""),newSaving);
                    exOutput.setText("Your daily expense allowed is: "+dailyAllowed);
                }
                else
                {
                    double newBalance = userIncome - exAmount;
                    newdailyAllowed = (userIncome - exAmount)/dayRemain;
                    userdatabase.updateUserData(loginId.getString("loginId",""),newBalance);
                    exOutput.setText("Your daily expense allowed is :"+ newdailyAllowed);
                }

                isInserted = userdatabase.addEx(exName,exDate,exCate,exAmount,DE_UID);

                if(isInserted){
                    Toast.makeText(DailyExpense.this,"Daily expense added",Toast.LENGTH_LONG).show();
                  //  userdatabase.updateUserData(loginId.getString("loginId",""),newBalance);
                   // exOutput.setText("Your daily expense allowed is :"+ newdailyAllowed);
//                    userdatabase.updateUserData(loginId.getString("loginId",""),exAmount);
                }
                else {
                    Toast.makeText(DailyExpense.this, "Daily expenses not added", Toast.LENGTH_LONG).show();
                }

            }
        });


/*
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

*/
/*
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c =userdatabase.aggregateExpense();
                StringBuilder stringBuilder = new StringBuilder();
                double amount;
                while(c.moveToNext()){
                    stringBuilder.append("\nid :"+c.getInt(0)+
                            " Amount :"+c.getDouble(1));
                    amount = c.getDouble(1);
                }
                exOutput.setText(stringBuilder);

            }
        });

*/



        ImageView btnTracker_Ex1 = findViewById(R.id.btnTracker_ex1);
        ImageView btnbig_Ex1 = findViewById(R.id.btnbig_ex1);
        ImageView btnReport_Ex1 = findViewById(R.id.btnReport_ex1);
        ImageView btnSetting_Ex1 = findViewById(R.id.btnSetting_ex1);



        btnTracker_Ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyExpense.this, MainActivity.class));
            }
        });

        btnbig_Ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyExpense.this, big1.class));
            }
        });

        btnReport_Ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyExpense.this, reportMain.class));
            }
        });

        btnSetting_Ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyExpense.this, SettingPage1.class));
            }
        });






    }
}