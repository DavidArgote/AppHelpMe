package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.ManagerHelper;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        ManagerHelper managerHelper = new ManagerHelper(this);
        managerHelper.openDbWrite();
        managerHelper.closeDb();

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        };

        timer.schedule(task, 3000);

    }
}
