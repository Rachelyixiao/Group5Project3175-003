package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class bigExpensePage1 extends AppCompatActivity {
    double bigCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_expense_page1);

        EditText inputCost = findViewById(R.id.txtGetInput_big);

        ImageView btnTracker_big = findViewById(R.id.btnTracker_big);
        ImageView btnBig_big = findViewById(R.id.btnBig_big);
        ImageView btnReport_big = findViewById(R.id.btnReport_big);
        ImageView btnSetting_big = findViewById(R.id.btnSetting_big);
        ImageView btnSubmit_big = findViewById(R.id.btnSubmit_big);

        bigCost = Double.parseDouble(inputCost.getText().toString());

        btnSubmit_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bigExpensePage1.this, bigExpensePage2.class));
            }
        });

        btnTracker_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bigExpensePage1.this, MainActivity.class));
            }
        });

        btnBig_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bigExpensePage1.this, bigExpensePage1.class));
            }
        });

        btnReport_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bigExpensePage1.this, reportMain.class));
            }
        });

        btnSetting_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bigExpensePage1.this, SettingPage1.class));
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