package com.example.group5project3175_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class cover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        TimerTask task = new TimerTask() {  //task가 할일! 끝내기, 끝내고 나서 다른 페이지 열기
            @Override
            public void run() {
                finish();
                startActivity(new Intent(cover.this,siguupOption.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task,2500);

    }
}