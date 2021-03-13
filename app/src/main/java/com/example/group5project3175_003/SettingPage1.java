package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingPage1 extends AppCompatActivity {
    String[] settings = {"SET PROFILE","CHOOSE THEME","HELP","PRIVACY POLICY","LOG OUT","BACK UP"};
    int[] settingImages = {R.drawable.settingprofile,R.drawable.settingtheme,R.drawable.settinghelp,
            R.drawable.settingprivacy,R.drawable.settinglogout,R.drawable.settingbackup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page1);

        List<HashMap<String,String>> aListSetting = new ArrayList<>();

        for(int i =0;i<6;i++){
            HashMap<String,String> hashMapSetting = new HashMap<>();
            hashMapSetting.put("txt",settings[i]);
            hashMapSetting.put("images",Integer.toString(settingImages[i]));
            aListSetting.add(hashMapSetting);
        }

        String[] fromSetting = {"images","txt"};
        int[] toSetting = {R.id.settingImage,R.id.txtSettingList};

        SimpleAdapter adapterS = new SimpleAdapter(getBaseContext(),aListSetting,
                R.layout.setting_listview_layout,fromSetting,toSetting);

        ListView listViewS = findViewById(R.id.SettinglistView);

        listViewS.setAdapter(adapterS);

        ImageButton btnHome = findViewById(R.id.imgbtnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  startActivity(new Intent(SettingPage1.this,MainActivity.class));
            }
        });
        
        ImageButton btnSettings = findViewById(R.id.imgbtnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(SettingPage1.this,SettingPage1.class));
            }
        });

        




    }
}