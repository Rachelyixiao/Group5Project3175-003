package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    double Balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
     //   SharedPreferences Dailyallow = getSharedPreferences("Dailyallow ",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");

        UserDatabase userdatabase = new UserDatabase(this);

        ImageView btnTracker = findViewById(R.id.btnTracker);
        ImageView btnBig = findViewById(R.id.btnBig);
        ImageView btnReport = findViewById(R.id.btnReport);
        ImageView btnSettings = findViewById(R.id.btnSettings);
       // ImageView btnAdd = findViewById(R.id.btnAdd);
      //  Button button = findViewById(R.id.testBtn);
//        TextView test = findViewById(R.id.test2);

            Cursor Userinf = userdatabase.viewUserData(loginID);
            Userinf.moveToLast();
           Balance = Double.parseDouble(Userinf.getString(10));


       // Get date
        final Calendar ce = Calendar.getInstance();
        int exyear = ce.get(Calendar.YEAR);
        int exMonth = ce.get(Calendar.MONTH);
        int exday = ce.get(Calendar.DAY_OF_MONTH);

        // get the last day of the month
        int last = ce.getActualMaximum(ce.DAY_OF_MONTH);


        double dayRemain = last - exday + 1;


        String DailyAllow  = Userinf.getString(11);//Dailyallow.getString("dailyAllowed", Double.toString((Balance / dayRemain)));
        double userBalance = Userinf.getDouble(10);
        double userSaving = Userinf.getDouble(9);

        Button btnGoTrans = findViewById(R.id.btnToTrans);

        TextView balance = findViewById(R.id.mainbalance);
        TextView saving = findViewById(R.id.mainsaving);
        TextView mainDEallow = findViewById(R.id.maindeallow);

        balance.setText(Double.toString(userBalance));
        saving.setText(Double.toString(userSaving));
        mainDEallow.setText(DailyAllow);
        /*if (DailyAllow==null){
            mainDEallow.setText(Double.toString((Balance / dayRemain)));
        }
        else {
            mainDEallow.setText(DailyAllow);
        }
*/
        btnGoTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,transactionR.class));
            }
        });


        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        btnBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, big1.class));
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, reportMain.class));
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingPage1.class));
            }
        });

     /*   btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, addnew.class));
            }
        });


//    button.setOnClickListener(new View.OnClickListener() {
   //     @Override
   //     public void onClick(View v) {
  //          test.setText("I:"+userIncome+"S:"+UserSaving);



            //            String userId = loginId.getString("loginId","");

     /*       SQLiteDatabase db = userdatabase.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Account_Name","Onoeserika");
            db.update("Userinf",values,"UID=?",new String[]{userId});
            Cursor c = userdatabase.viewData();

            int id = Integer.parseInt(userId)-1;


            c.moveToPosition(id);


            test.setText(c.getString(7));

      */
//            int loginid = Integer.parseInt(userId);
   /*         String fn = "222";
            String ln="333";
            String email = "eeeeee";
            String ps = "2";
            String an = "22";
            boolean isUpdated = userdatabase.updateUserData(loginid,fn,ln,email,ps,an);
            if(isUpdated)
                Toast.makeText(MainActivity.this,"Record Updated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this,"Record not Updated",Toast.LENGTH_LONG).show();

*/


    }
}