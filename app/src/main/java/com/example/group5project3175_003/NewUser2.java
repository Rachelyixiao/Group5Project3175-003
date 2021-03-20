package com.example.group5project3175_003;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user2);

        SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);
        Spinner currency = findViewById(R.id.currency);
//        Spinner language = findViewById(R.id.language);
        Switch alarm = findViewById(R.id.alarm);
        Switch theme = findViewById(R.id.theme);
        Button button = findViewById(R.id.btn2);

        alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    SharedPreferences.Editor editor = user.edit();
                    editor.putString("alarm","On");
                    editor.commit();

                }
                else{
                    SharedPreferences.Editor editor = user.edit();
                    editor.putString("alarm","Off");
                    editor.commit();

                }
            }
        });
        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    SharedPreferences.Editor editor = user.edit();
                    editor.putString("theme","On");
                    editor.commit();

                }
                else{
                    SharedPreferences.Editor editor = user.edit();
                    editor.putString("theme","Off");
                    editor.commit();

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String  currencyChoice = currency.getSelectedItem().toString();
//              String languageChice = language.getSelectedItem().toString();
                SharedPreferences.Editor editor = user.edit();
                editor.putString("currency",currencyChoice);
//                editor.putString("language",languageChice);
                editor.commit();

                startActivity(new Intent(NewUser2.this,NewUser3.class));


            }
        });

    }
}