package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_account);

      UserDatabase  userdatabase = new UserDatabase(this);
        Button button = findViewById(R.id.loginBtn1);
        TextView userName = findViewById(R.id.userName);
        TextView psw = findViewById(R.id.password);
        TextView output = findViewById(R.id.test);
        Button button2 = findViewById(R.id.Newbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = userdatabase.viewData();
                String test = "";
                String sUserName= userName.getText().toString();
                String sPsw = psw.getText().toString();
                int userid = 1;
                if (c.getCount()>0){
                    while(c.moveToNext()){

                       if (sUserName.equals(c.getString(3))){

                           if (sPsw.equals(c.getString(4))){
                               test = "Wellcome"+c.getString(2) + c.getString(1);
                               Intent intent = new Intent(CheckAccount.this,MainActivity.class);
                               intent.putExtra("userId",c.getString(0));
                               startActivity(intent);

                           }
                           else{
                               test = "Password incorrect!";
                           }
                           break;
                       }
                       userid ++;
                          test = "Username not found";

                    }
                    output.setText(test);
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