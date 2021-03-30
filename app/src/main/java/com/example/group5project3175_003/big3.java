package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class big3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big3);

        TextView bigR2 = findViewById(R.id.bigcostResult2);

        Intent i = getIntent();

        if(i!=null){
            double bigcost = i.getDoubleExtra("bigcost",0);
            double balance = i.getDoubleExtra("balance",0);
            double saving = i.getDoubleExtra("saving",0);

            double option1;
            double option2;


            if(bigcost>balance&&bigcost>saving)
            {
                option1 = bigcost-saving;
                option2 = balance-option1;
                bigR2.setText("You can use you Saving of "+saving+" and "+option2+" of your Income to handle the big expense");
            }
            else if(bigcost<=balance&&bigcost<=saving)
            {
                bigR2.setText("You can choose to handle your big expense by either your saving or income balance");
            }
            else if(bigcost>balance&&bigcost<=saving)
            {
                bigR2.setText("You can user your saving to handle your big expense");

            }
            else if(bigcost>saving&&bigcost<=balance){
                bigR2.setText("You can use your income balance to handle your big expense");
            }
        }

        //bottom navigator button
        ImageView btnTracker_big3 = findViewById(R.id.btnTracker_big3);
        ImageView btnBig_big3 = findViewById(R.id.btnBig_big3);
        ImageView btnReport_big3 = findViewById(R.id.btnReport_big3);
        ImageView btnSetting_big3 = findViewById(R.id.btnSetting_big3);


        btnTracker_big3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big3.this, MainActivity.class));
            }
        });

        btnBig_big3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big3.this, big1.class));
            }
        });

        btnReport_big3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big3.this, reportMain.class));
            }
        });

        btnSetting_big3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(big3.this, SettingPage1.class));
            }
        });

    }
}