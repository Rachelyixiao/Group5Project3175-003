package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingPage1 extends AppCompatActivity {
    String[] settings = {"Check/Modify User Info","Check User Account Info","Report History Research","PRIVACY POLICY","LOG OUT"};
    int[] settingImages = {R.drawable.settingprofile,R.drawable.settingtheme,R.drawable.settinghelp,
            R.drawable.settingprivacy,R.drawable.settinglogout,R.drawable.settingbackup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page1);

        ImageView btnTracker_set1 = findViewById(R.id.btnTracker_set1);
        ImageView btnBig_set1 = findViewById(R.id.btnBig_set1);
        ImageView btnReport_set1 = findViewById(R.id.btnReport_set1);
        ImageView btnSetting_set1 = findViewById(R.id.btnSetting_set1);

        btnTracker_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage1.this, MainActivity.class));
            }
        });

        btnBig_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage1.this, bigExpensePage1.class));
            }
        });

        btnReport_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage1.this, reportMain.class));
            }
        });

        btnSetting_set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingPage1.this, SettingPage1.class));
            }
        });




//        List<HashMap<String,String>> aListSetting = new ArrayList<>();
//
//        for(int i =0;i<5;i++){
//            HashMap<String,String> hashMapSetting = new HashMap<>();
//            hashMapSetting.put("txt",settings[i]);
//            hashMapSetting.put("images",Integer.toString(settingImages[i]));
//            aListSetting.add(hashMapSetting);
//        }
//
//        String[] fromSetting = {"images","txt"};
//        int[] toSetting = {R.id.settingImage,R.id.txtSettingList};
//
//        SimpleAdapter adapterS = new SimpleAdapter(getBaseContext(),aListSetting,
//                R.layout.setting_listview_layout,fromSetting,toSetting);
//
//        ListView listViewS = findViewById(R.id.SettinglistView);
//
//        listViewS.setAdapter(adapterS);
//
//        listViewS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 0:
//                        startActivity(new Intent(SettingPage1.this,SettingPage2.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(SettingPage1.this,CheckAccount.class));
//                        break;
//                    case 2:
//                        startActivity(new Intent(SettingPage1.this,CustomizeReport.class));
//                        break;
//                    case 3:
//                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/moneyandmanagement3175003")));
//                        break;
//                    case 4:
//                        startActivity(new Intent(SettingPage1.this,MainActivity.class));
//                }
//            }
//        });
//
//
//
//        ImageButton btnHome = findViewById(R.id.imgbtnHome);
//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  startActivity(new Intent(SettingPage1.this,MainActivity.class));
//            }
//        });
//
//        ImageButton btnSettings = findViewById(R.id.imgbtnSettings);
//        btnSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             startActivity(new Intent(SettingPage1.this,SettingPage1.class));
//            }
//        });

        




    }
}