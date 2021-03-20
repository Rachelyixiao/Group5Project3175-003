package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class siguupOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguup_option);

        ImageView btnsignup1 = findViewById(R.id.btnsignup1);
        ImageView btnsignup2 = findViewById(R.id.btnsignup2);

        btnsignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(siguupOption.this, guestRegistration1.class));
            }
        });

        btnsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(siguupOption.this, NewUser1.class));
            }
        });


    }
}