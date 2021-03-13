package com.example.group5project3175_003;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser1 extends AppCompatActivity {
    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user1);

        userDatabase = new UserDatabase(this);
        EditText fName = findViewById(R.id.fn);
        EditText lName = findViewById(R.id.ln);
        EditText email = findViewById(R.id.email);
        EditText psw1 = findViewById(R.id.psw1);
        EditText psw2 = findViewById(R.id.psw2);
        Button button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                if (psw1.getText().toString().equals(psw2.getText().toString())){
//                    isInserted = userDatabase.add(fName.getText().toString(),
//                            lName.getText().toString(),
//                            email.getText().toString(),
//                            psw1.getText().toString());
//                    if (isInserted){
//                        Toast.makeText(NewUser1.this,"Data added",Toast.LENGTH_LONG).show();
//
//                    }
//                    else{
//                        Toast.makeText(NewUser1.this,"Data not added",Toast.LENGTH_LONG).show();
//                    }

                }
                else{
                    Toast.makeText(NewUser1.this,"Password confirmation is different",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}