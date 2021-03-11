package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class bigExpensePage1 extends AppCompatActivity {
    double bigCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_expense_page1);

        EditText inputCost = findViewById(R.id.txtBigCostInput);

        Button btnBigCost = findViewById(R.id.btnBigExpenseSubmit);

        btnBigCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigCost = Double.parseDouble(inputCost.getText().toString());
                //if bigcost <= personal account amount
               startActivity(new Intent(bigExpensePage1.this,bigExpensePage2.class));

                //if bigcost > personal account amount
               // Intent i2 = new Intent(BigExpensePage1.this,BigExpensePage3.class);
               // startActivity(i2);
            }
        });

    }

}