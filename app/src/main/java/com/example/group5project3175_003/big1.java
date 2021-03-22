package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class big1 extends AppCompatActivity {
    UserDatabase mydatabase;
    double bigcost;
    Date bdate;
    String bcate;
    String bdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_expense_page1);

        mydatabase = new UserDatabase(this);

        EditText inputCost = findViewById(R.id.txtGetInput_big);

        EditText bigdate = findViewById(R.id.txtBigDate);
        Spinner bigcateGroup = findViewById(R.id.spnBigCate);
        EditText bigDes = findViewById(R.id.txtBigDes);

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        SharedPreferences bigEx = getSharedPreferences("bigExpense",MODE_PRIVATE);

        ImageView btnTracker_big = findViewById(R.id.btnTracker_big1);
        ImageView btnBig_big = findViewById(R.id.btnBig_big1);
        ImageView btnReport_big = findViewById(R.id.btnReport_big1);
        ImageView btnSetting_big = findViewById(R.id.btnSetting_big1);
        ImageView btnSubmit_big = findViewById(R.id.btnSubmit_big);

        TextView bigoutput = findViewById(R.id.txtBigOuttest);

        btnSubmit_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigcost = Double.parseDouble(inputCost.getText().toString());
                bigoutput.setText("Your big cost is "+bigcost);
                bcate = bigcateGroup.getSelectedItem().toString();


                try {
                    bdate = df.parse(bigdate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                bdes = bigDes.getText().toString();

                boolean isInserted = mydatabase.addBig(bdate,bcate,bdes);
                if(isInserted){
                    Toast.makeText(big1.this,"Big expense added",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(big1.this,"Big expenses not added",Toast.LENGTH_LONG).show();


                //startActivity(new Intent(big1.this, big2.class));
            }
        });

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
//        ImageButton btnHome = findViewById(R.id.imgbtnHome);
//
//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(bigExpensePage1.this,MainActivity.class));
//            }
//        });
//
//        ImageButton btnSettings = findViewById(R.id.imgbtnSettings);
//        btnSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(bigExpensePage1.this,SettingPage1.class));
//            }
//        });

    }

}