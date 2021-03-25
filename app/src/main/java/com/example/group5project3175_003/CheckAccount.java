package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_account);

      UserDatabase  userdatabase = new UserDatabase(this);
        Button button = findViewById(R.id.loginBtn1);
        TextView userName = findViewById(R.id.userName);
        TextView psw = findViewById(R.id.password);

        Button button2 = findViewById(R.id.Newbtn);
       SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = userdatabase.viewData();
                String text = "";
                String sUserName= userName.getText().toString();
                String sPsw = psw.getText().toString();

                if (c.getCount()>0){
                    while(c.moveToNext()){

                       if (sUserName.equals(c.getString(3))){

                           if (sPsw.equals(c.getString(4))){
                               text = "Welcome "+c.getString(2) + c.getString(1);
//                               Intent intent = new Intent(CheckAccount.this,MainActivity.class);
//                               intent.putExtra("userId",c.getString(0));

                               SharedPreferences.Editor editor = loginId.edit();
                               editor.putString("loginId", c.getString(0));
                               editor.commit();
                               startActivity(new Intent(CheckAccount.this,MainActivity.class));
                           }
                           else{
                               text = "Password incorrect!";
                           }
                           break;
                       }

                          text = "Username not found";

                    }
                    Toast.makeText(CheckAccount.this,text,Toast.LENGTH_LONG).show();
                }
                c.close();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckAccount.this,NewUser1.class));
            }
        });

    }
}