package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RecurrintBill extends AppCompatActivity {
    UserDatabase userdatabase;
    DatePickerDialog datePickerDialog;

    String billName;
    String billDate;
    Double billAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurrint_bill);

        userdatabase = new UserDatabase(this);
        SharedPreferences loginId = getSharedPreferences("loginId",MODE_PRIVATE);
        String loginID = loginId.getString("loginId","");
        Cursor Userinf = userdatabase.viewUserData(loginID);

        EditText bName = findViewById(R.id.txtBillName);
        EditText bDate = findViewById(R.id.txtBilldate);
        EditText bAmount = findViewById(R.id.txtBillAmount);

        Button btnAddBill = findViewById(R.id.btnBillAdd);
        Button btnViewBill = findViewById(R.id.btnBillView);

        bDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int billyear = c.get(Calendar.YEAR);
                int billMonth = c.get(Calendar.MONTH);
                int billday = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(RecurrintBill.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                bDate.setText(year + "/"
                                        + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, billyear, billMonth, billday);
                datePickerDialog.show();
            }
        });

        int MB_UID = Integer.parseInt(loginId.getString("loginId",""));

        btnAddBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted;

                billName = bName.getText().toString();
                billDate = bDate.getText().toString();
                billAmount= Double.parseDouble(bAmount.getText().toString());

                int positionId = Integer.parseInt(loginID)-1;
                Cursor c = userdatabase.viewData();
                c.moveToPosition(positionId);
               // double UserIncome=c.getInt(8);
               // double UserAddIncome=c.getInt(9);
                double userInitialBalance = c.getDouble(10);
                double dailyAllow = c.getDouble(11);

                double newdailyAllow = dailyAllow - billAmount;

                isInserted = userdatabase.addBill(billName,billDate,billAmount,MB_UID);
                if(isInserted){
                    Toast.makeText(RecurrintBill.this,"Monthly bill added",Toast.LENGTH_LONG).show();
                    userdatabase.updateUserData(loginId.getString("loginId",""),(userInitialBalance-billAmount));
                    userdatabase.updateDailyAllow(Integer.parseInt(loginID),newdailyAllow);
                }
                else {
                    Toast.makeText(RecurrintBill.this, "Monthly bill not added", Toast.LENGTH_LONG).show();
                }

            }
        });

        TextView Output = findViewById(R.id.billout);

        btnViewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = userdatabase.viewBill(Integer.parseInt(loginID));
                StringBuilder stringBuilder = new StringBuilder();
                while(c.moveToNext()){
                    stringBuilder.append(
                            " Bill name :"+c.getString(1)+
                            " Date :"+c.getString(2)+
                            "Bill AMOUNT :"+c.getDouble(3));
                }
                Output.setText(stringBuilder);
            }
        });



        ImageView btnTracker_RB1 = findViewById(R.id.btnTracker_rb1);
        ImageView btnbig_RB1 = findViewById(R.id.btnbig_rb1);
        ImageView btnReport_RB1 = findViewById(R.id.btnReport_rb1);
        ImageView btnSetting_RB1 = findViewById(R.id.btnSetting_rb1);



        btnTracker_RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecurrintBill.this, MainActivity.class));
            }
        });

        btnbig_RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecurrintBill.this, big1.class));
            }
        });

        btnReport_RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecurrintBill.this, reportMain.class));
            }
        });

        btnSetting_RB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecurrintBill.this, SettingPage1.class));
            }
        });




    }
}