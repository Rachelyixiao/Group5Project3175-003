package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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

public class big1 extends AppCompatActivity {
    UserDatabase userdatabase;
    DatePickerDialog datePickerDialog;

    double bigcost;
    String bdate;
    String bcate;
    String bdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_expense_page1);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");


        EditText inputCost = findViewById(R.id.txtGetInput_big);
        EditText bigdate = findViewById(R.id.txtBigDate);
        Spinner bigcateGroup = findViewById(R.id.spnBigCate);
        EditText bigDes = findViewById(R.id.txtBigDes);

        int positionId = Integer.parseInt(loginID)-1;
        Cursor c = userdatabase.viewData();
        c.moveToPosition(positionId);
        double userIncome = c.getDouble(10);
        double UserSaving = c.getDouble(9);
        double TotalBalance = userIncome+UserSaving;

        //The user can choose the big expense date
        bigdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar ca = Calendar.getInstance();
                int bigyear = ca.get(Calendar.YEAR);
                int bigMonth = ca.get(Calendar.MONTH);
                int bigday = ca.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(big1.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                bigdate.setText(year + "/"
                                        + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, bigyear, bigMonth, bigday);

                datePickerDialog.show();
            }
        });


        int b_uid = Integer.parseInt(loginId.getString("loginId",""));
        ImageView btnSubmit_big = findViewById(R.id.btnadd_big);

        //Get the user input and insert data into bigexpense table
        //Give the user some suggestions based on his/her balance
        btnSubmit_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigcost = Double.parseDouble(inputCost.getText().toString());
                //bigoutput.setText("Your big cost is "+bigcost);

                bcate = bigcateGroup.getSelectedItem().toString();
                bdate = bigdate.getText().toString();
                bdes = bigDes.getText().toString();

                if(bigcost>TotalBalance){
                    Intent i = new Intent(big1.this,big2.class);
                    i.putExtra("bigcost",bigcost);
                    i.putExtra("totalBalance",TotalBalance);
                    i.putExtra("balance",userIncome);
                    i.putExtra("saving",UserSaving);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(big1.this,big3.class);
                    i.putExtra("bigcost",bigcost);
                    i.putExtra("balance",userIncome);
                    i.putExtra("saving",UserSaving);
                    startActivity(i);
                }

                boolean isInserted = userdatabase.addBig(bdate,bcate,bdes,b_uid);

                if(isInserted){
                    Toast.makeText(big1.this,"Big expense added",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(big1.this, "Big expenses not added", Toast.LENGTH_LONG).show();
                }

            }
        });

        //View the result of big expense
        Button btnViewbig = findViewById(R.id.btnViewBig);
        TextView bigout = findViewById(R.id.txtBigOut);

        btnViewbig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cbig = userdatabase.viewBig(b_uid);
                StringBuilder stringBuilder = new StringBuilder();
                while(cbig.moveToNext()){
                    stringBuilder.append("\nBID :"+cbig.getInt(0)+
                            "\nFinishDate :"+cbig.getString(1)+
                            "\nCategory :"+cbig.getString(2)+
                            "\nDescription :"+cbig.getString(3)+
                            "\nUserID :"+cbig.getInt(4));
                }
                bigout.setText(stringBuilder);

            }
        });



        //bottom navigator button
        ImageView btnTracker_big = findViewById(R.id.btnTracker_big1);
        ImageView btnBig_big = findViewById(R.id.btnBig_big1);
        ImageView btnReport_big = findViewById(R.id.btnReport_big1);
        ImageView btnSetting_big = findViewById(R.id.btnSetting_big1);


        btnTracker_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big1.this, MainActivity.class));
            }
        });

        btnBig_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big1.this, big1.class));
            }
        });

        btnReport_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big1.this, reportMain.class));
            }
        });

        btnSetting_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big1.this, SettingPage1.class));
            }
        });


//        EditText inputCost = findViewById(R.id.txtBigCostInput);
//
//        Button btnBigCost = findViewById(R.id.btnSubmit_big);
//
//        btnBigCost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bigCost = Double.parseDouble(inputCost.getText().toString());
//                //if bigcost <= personal account amount
//               startActivity(new Intent(bigExpensePage1.this,bigExpensePage2.class));
//
//                //if bigcost > personal account amount
//               // Intent i2 = new Intent(BigExpensePage1.this,BigExpensePage3.class);
//               // startActivity(i2);
//            }
//        });
//


    }

}