package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class transactionR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_r);

        Button btnTrack1 = findViewById(R.id.btnTrace1);
        Button btnTrack2 = findViewById(R.id.btnTrace2);

        btnTrack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, RecurrintBill.class));
            }
        });

        btnTrack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(transactionR.this, DailyExpense.class));
            }
        });


    }
}