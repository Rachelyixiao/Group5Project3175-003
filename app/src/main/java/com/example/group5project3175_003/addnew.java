package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class addnew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);

        EditText txtAddNew = findViewById(R.id.txtAddNew);
        Spinner spinnerCategory = findViewById(R.id.spinnerCategory);
        Spinner spinnerDate = findViewById(R.id.spinnerDate);
        ImageView btnsave_addnew = findViewById(R.id.btnsave_addnew);



    }
}