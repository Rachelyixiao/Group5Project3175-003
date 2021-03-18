package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class guestRegistration1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_registration1);

        ImageView btncontinue_guest1 = findViewById(R.id.btncontinue_guest1);

        btncontinue_guest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(guestRegistration1.this, guestRegistration2.class));
            }
        });




    }
}