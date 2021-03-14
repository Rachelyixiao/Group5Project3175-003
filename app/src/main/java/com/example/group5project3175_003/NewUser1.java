package com.example.group5project3175_003;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser1 extends AppCompatActivity {

    String sFName,sLName,sEmail,sPsw1,sPsw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user1);


        EditText fName = findViewById(R.id.fn);
        EditText lName = findViewById(R.id.ln);
        EditText email = findViewById(R.id.email);
        EditText psw1 = findViewById(R.id.psw1);
        EditText psw2 = findViewById(R.id.psw2);
        Button button = findViewById(R.id.btn1);

        SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sFName = fName.getText().toString();
                sLName = lName.getText().toString();
                sEmail = email.getText().toString();
                sPsw1 = psw1.getText().toString();
                sPsw2 = psw2.getText().toString();
              boolean  isUnfill = sFName.isEmpty()||sLName.isEmpty()||sEmail.isEmpty()||sPsw1.isEmpty()||sPsw2.isEmpty();
                if (sPsw1.equals(sPsw2)&&!isUnfill){
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
                    if (psw1.length()>8){
                        Toast.makeText(NewUser1.this,"The password maximum can only be up to eight digits",Toast.LENGTH_LONG).show();

                    }
                    else {
                        SharedPreferences.Editor editor = user.edit();
                        editor.putString("fName", sFName);
                        editor.putString("lName", sLName);
                        editor.putString("email", sEmail);
                        editor.putString("psw", sPsw1);
                        editor.putString("alarm","On");
                        editor.putString("theme","On");
                        editor.commit();
                        startActivity(new Intent(NewUser1.this, NewUser2.class));
                    }
                }
                else if (isUnfill){
                    Toast.makeText(NewUser1.this,"The information is not completed",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(NewUser1.this,"Password confirmation is different",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}