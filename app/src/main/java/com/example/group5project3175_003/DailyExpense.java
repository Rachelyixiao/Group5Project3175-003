package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.effect.Effect;
import android.media.effect.EffectFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;

import java.util.Calendar;

public class DailyExpense extends AppCompatActivity {
    UserDatabase userdatabase;
    DatePickerDialog datePickerDialog;

    String exName;
    String exCate;
    String exDate;
    Double exAmount;
    int dayRemain;
    double todayExpense;
    double dailyAllowed;
   // String lastRecordDate;
    double totalOverEx;
    double totalSaveEx;
    double Saving;
    double Balance;
    double newDailyAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_expense);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
      //  SharedPreferences Dailyallow = getSharedPreferences("Dailyallow ",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");
        int useId = Integer.parseInt(loginId.getString("loginId",""));
        int positionId = Integer.parseInt(loginID)-1;

        SQLiteDatabase sqLiteDatabase = userdatabase.getReadableDatabase();
        Cursor Userinf = userdatabase.viewUserData(loginID);
        Cursor DE = userdatabase.viewDE(loginID);
        if(Userinf!=null && Userinf.getCount()>0){
            Userinf.moveToFirst();
            Balance = Userinf.getDouble(Userinf.getColumnIndex("Balance"));
            dailyAllowed = Userinf.getDouble(Userinf.getColumnIndex("DailyAllow"));
            Saving = Userinf.getDouble(Userinf.getColumnIndex("Saving"));
        }

/*
        try {
            while(DE.moveToNext()){
                lastRecordDate = DE.getString(2);
            }
        } catch (Exception e) {
            lastRecordDate = "";
        }
*/
        EditText dailyDate = findViewById(R.id.txtExDate);
        EditText dailyEname = findViewById(R.id.txtEname);
        Spinner dailyCatGroup = findViewById(R.id.expenseGroup);
        EditText dailyAm = findViewById(R.id.txtEAmount);
        Button btnDAdd = findViewById(R.id.btnEadd);
        Button btnDView = findViewById(R.id.btnEView);

                final Calendar ce = Calendar.getInstance();
                int exyear = ce.get(Calendar.YEAR);
                int exMonth = ce.get(Calendar.MONTH);
                int exday = ce.get(Calendar.DAY_OF_MONTH);

                // get the last day of the month
                int last = ce.getActualMaximum(ce.DAY_OF_MONTH);

                dayRemain = last-exday+1;

                dailyDate.setText(exyear+"/"+(exMonth+1)+"/"+exday);


        btnDAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exName = dailyEname.getText().toString();
                exCate = dailyCatGroup.getSelectedItem().toString();
                exAmount = Double.parseDouble(dailyAm.getText().toString());
                exDate = dailyDate.getText().toString();

                if(exAmount>dailyAllowed){
                    Balance = Balance - exAmount;
                    newDailyAllowed = Balance/dayRemain;
                    userdatabase.updateDailyAllow(useId,newDailyAllowed);
                    userdatabase.updateUserData(loginID,Balance);
                }
                else {
                    Saving = Saving+(dailyAllowed-exAmount);
                    userdatabase.updateUserSavingData(loginID,Saving);
                }

                boolean isInserted = userdatabase.addEx(exName,exDate,exCate,exAmount,useId);
                if(isInserted){
                    Toast.makeText(DailyExpense.this,"Daily expense add",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(DailyExpense.this,"Daily expense not add",Toast.LENGTH_SHORT).show();
            }
        });

        btnDView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = userdatabase.viewDE(loginID);
                StringBuilder stringBuilder = new StringBuilder();
                while(c.moveToNext()){
                    stringBuilder.append(
                                    " DEname :"+c.getString(1)+
                                    " Date :"+c.getString(2)+
                                    " DE_Category :"+c.getString(3)
                                    +"DE_AMOUNT :"+c.getDouble(4));

                }
                Toast.makeText(DailyExpense.this,stringBuilder,Toast.LENGTH_SHORT).show();
            }
        });














//        try {
//            Userinf.moveToLast();
//            Balance = Userinf.getDouble(10);
//        } catch (Exception e) {
//            Balance = 0;
//        }


 /*

        //get the saving and balance amount of the user
        Cursor c = userdatabase.viewData();
        c.moveToPosition(positionId);
        double UserSaving = c.getDouble(9);
        double UserBalance = c.getDouble(10);
        double UserDailyAllow = c.getDouble(11);

        Button btnSettle = findViewById(R.id.btnSettleEX);
        //Button btnTest = findViewById(R.id.btnCalTotalExpense);
        TextView exOutput = findViewById(R.id.exOut);
        final Calendar ce = Calendar.getInstance();
        int exyear = ce.get(Calendar.YEAR);
        int exMonth = ce.get(Calendar.MONTH);
        int exday = ce.get(Calendar.DAY_OF_MONTH);

        // get the last day of the month
        int last = ce.getActualMaximum(ce.DAY_OF_MONTH);

        dailyDate.setText(exyear+"/"+(exMonth+1)+"/"+exday);
        dayRemain = last - exday + 1;










/*
        try {
            dailyAllowed = c.getDouble(c.getColumnIndex("DailyAllow"));
        } catch (Exception e) {
            dailyAllowed = 0;
        }
*/

   /*     dailyAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor  c = userdatabase.viewEx(useId);
                double TotalExpense =0;
                while (c.moveToNext()){
                    TotalExpense += c.getDouble(4);
                }
                Toast.makeText(DailyExpense.this, Double.toString(TotalExpense), Toast.LENGTH_SHORT).show();
            }
        });

        //Use Calendar to get the current date
//        dailyDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar ce = Calendar.getInstance();
//                int exyear = ce.get(Calendar.YEAR);
//                int exMonth = ce.get(Calendar.MONTH);
//                int exday = ce.get(Calendar.DAY_OF_MONTH);
//
//                // get the last day of the month
//                int last = ce.getActualMaximum(ce.DAY_OF_MONTH);
//
//                dailyDate.setText(exyear+"/"+(exMonth+1)+"/"+exday);
//                dayRemain = last - exday + 1;
//           /*
//                datePickerDialog = new DatePickerDialog(DailyExpense.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//                                // set day of month , month and year value in the edit text
//                                dailyDate.setText(year + "/"
//                                        + (monthOfYear + 1) + "/" + dayOfMonth);
//                            }
//                        }, exyear, exMonth, exday);
//                datePickerDialog.show();
//             */
//            }
//        });



   /*

        int DE_UID = Integer.parseInt(loginId.getString("loginId",""));

        btnDAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exName = dailyEname.getText().toString();
                exCate = dailyCatGroup.getSelectedItem().toString();
                exAmount = Double.parseDouble(dailyAm.getText().toString());
                exDate = dailyDate.getText().toString();
*/
               /* try {
                    dailyAllowed = c.getDouble(c.getColumnIndex("DailyAllow"));
                } catch (Exception e) {
                    dailyAllowed = 0;
                }*/
/*
try {

    if (!exDate.equals(lastRecordDate) || lastRecordDate.equals("")) {
        Toast.makeText(DailyExpense.this, "New day!", Toast.LENGTH_SHORT).show();
        todayExpense = 0.0;
        //Userinf.moveToLast();
        Balance = c.getDouble(10);
        dailyAllowed = Balance / dayRemain;
        if(exAmount<=dailyAllowed){
            double newbalance1 = Balance - exAmount;
            userdatabase.updateUserData(loginID, newbalance1);
        }
        else
        {
            double newDailyAllowed = (Balance-exAmount+dailyAllowed)/dayRemain;
            userdatabase.updateUserData(loginID,Balance-dailyAllowed);
            userdatabase.updateDailyAllow(Integer.parseInt(loginID),newDailyAllowed);
        }
    //    double newBalance1 = Balance - dailyAllowed;
        todayExpense += exAmount;
    }
    else {
        dailyAllowed=c.getDouble(11);
        Balance = c.getDouble(10);
        if(exAmount<=dailyAllowed){
            double newbalance2 = Balance - exAmount;
            userdatabase.updateUserData(loginID, newbalance2);
        }
        else{
            double newDailyAllowed2 = (Balance-exAmount+dailyAllowed)/dayRemain;
            userdatabase.updateUserData(loginID,Balance-dailyAllowed);
            userdatabase.updateDailyAllow(Integer.parseInt(loginID),newDailyAllowed2);
        }
        todayExpense += exAmount;
    }

*/

    /*
    //Toast.makeText(DailyExpense.this, Double.toString(dailyAllowed), Toast.LENGTH_SHORT).show();
    if (exAmount > dailyAllowed) {
        Toast.makeText(DailyExpense.this,"Balance:"+Balance,Toast.LENGTH_SHORT).show();
        Toast.makeText(DailyExpense.this,"TODAY:"+todayExpense,Toast.LENGTH_SHORT).show();
        Toast.makeText(DailyExpense.this,"dailyAllowed:"+dailyAllowed,Toast.LENGTH_SHORT).show();
        Userinf.moveToLast();
        double newBalance2 = Double.parseDouble(Userinf.getString(10)) -exAmount+dailyAllowed;
        userdatabase.updateUserData(loginID, newBalance2);
        dailyAllowed = 0;
    } else {

        dailyAllowed -= exAmount;
    }*/


/*
    boolean isInserted;
    userdatabase.addEx(exName, exDate, exCate, exAmount, DE_UID);
    isInserted = userdatabase.updateDailyAllow(DE_UID, dailyAllowed);
    if (isInserted) {
        //  Toast.makeText(DailyExpense.this, Double.toString(todayExpense), Toast.LENGTH_LONG).show();
        lastRecordDate = exDate;
//                    SharedPreferences.Editor editor = Dailyallow.edit();
//                    editor.putString("dailyAllowed",Double.toString(dailyAllowed));
//                    editor.commit();
    } else {
        Toast.makeText(DailyExpense.this, "Daily expenses not added", Toast.LENGTH_LONG).show();
    }
}  catch (Exception e) {
    exOutput.setText(e.getMessage());
}
            }
        });

        btnSettle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dailyAllowed = c.getDouble(11);
                if(todayExpense>dailyAllowed){
                    totalOverEx = todayExpense -dailyAllowed;
                    userdatabase.updateUserData(loginID,(UserBalance-totalOverEx));
                    dailyAllowed = (UserBalance-totalOverEx)/dayRemain;
                }
                else {
                    totalSaveEx = dailyAllowed - todayExpense;
                    userdatabase.updateUserData(loginID,(UserSaving+totalSaveEx));
                }
                exOutput.setText("Your daily expense allowed is: "+ dailyAllowed);

            }
        });



        btnDView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DailyExpense.this, Double.toString(dailyAllowed), Toast.LENGTH_SHORT).show();
//                Cursor cEx = userdatabase.viewEx(DE_UID);
//                StringBuilder stringBuilder = new StringBuilder();
//                while(cEx.moveToNext()){
//                    stringBuilder.append("\nDE_ID :"+cEx.getInt(0)+
//                            " Name :"+cEx.getString(1)+
//                            " Date :"+cEx.getString(2)+
//                            " Category :"+cEx.getString(3)+
//                            " Amount :"+cEx.getDouble(4));
//                }
           //     exOutput.setText(stringBuilder);
            }
        });


/*
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c =userdatabase.aggregateExpense();
                StringBuilder stringBuilder = new StringBuilder();
                double amount;
                while(c.moveToNext()){
                    stringBuilder.append("\nid :"+c.getInt(0)+
                            " Amount :"+c.getDouble(1));
                    amount = c.getDouble(1);
                }
                exOutput.setText(stringBuilder);

            }
        });

*/


                ImageView btnTracker_Ex1 = findViewById(R.id.btnTracker_ex1);
                ImageView btnbig_Ex1 = findViewById(R.id.btnbig_ex1);
                ImageView btnReport_Ex1 = findViewById(R.id.btnReport_ex1);
                ImageView btnSetting_Ex1 = findViewById(R.id.btnSetting_ex1);


                btnTracker_Ex1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DailyExpense.this, MainActivity.class));
                    }
                });

                btnbig_Ex1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DailyExpense.this, big1.class));
                    }
                });

                btnReport_Ex1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DailyExpense.this, reportMain.class));
                    }
                });

                btnSetting_Ex1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DailyExpense.this, SettingPage1.class));
                    }
                });


        }
    }



