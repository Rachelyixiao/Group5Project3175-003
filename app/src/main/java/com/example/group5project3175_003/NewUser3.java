package com.example.group5project3175_003;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class NewUser3 extends AppCompatActivity {
    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);
        setContentView(R.layout.activity_new_user3);
        userDatabase = new UserDatabase(this);
        TextView acName = findViewById(R.id.acName);
//        Spinner budgetType = findViewById(R.id.budgettype);
        TextView salary = findViewById(R.id.salary);
        TextView adIncome = findViewById(R.id.adIncome);
        TextView saving = findViewById(R.id.saving);
        Button button = findViewById(R.id.btn3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted;

                String sacName = acName.getText().toString();
//                String sbudgetType = budgetType.getSelectedItem().toString();
                String fName = user.getString("fName","");
                String lName = user.getString("lName","");
                String email = user.getString("email","");
                String psw = user.getString("psw","");
                String currency = user.getString("currency","");
//                String language = user.getString("language","");
                String alarm = user.getString("alarm","");
//                String theme = user.getString("theme","");
                double sSalary = Integer.parseInt(salary.getText().toString());
                double sAdIncome = Integer.parseInt(adIncome.getText().toString());
                double sIncome = sSalary+sAdIncome;
                double sSaving = Integer.parseInt(saving.getText().toString());
                double sBalance = sIncome;


                final Calendar ce = Calendar.getInstance();
                int exyear = ce.get(Calendar.YEAR);
                int exMonth = ce.get(Calendar.MONTH);
                int exday = ce.get(Calendar.DAY_OF_MONTH);
                int last = ce.getActualMaximum(ce.DAY_OF_MONTH);

                int dayRemain = last - exday + 1;

                double dailyInitial = sBalance/dayRemain;
                Toast.makeText(NewUser3.this,"dailyRemain "+dailyInitial,Toast.LENGTH_SHORT).show();



                isInserted = userDatabase.add(fName,
                        lName,
                        email,
                        psw,
                        currency,
                        alarm,
                        sacName,
                        sIncome,
                        sSaving,
                        sBalance,
                        dailyInitial);
                    if (isInserted){
                        Toast.makeText(NewUser3.this,"Data added",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(NewUser3.this,CheckAccount.class));
                    }
                    else{
                        Toast.makeText(NewUser3.this,"Data not added",Toast.LENGTH_LONG).show();
                    }

            }
        });


    }
}