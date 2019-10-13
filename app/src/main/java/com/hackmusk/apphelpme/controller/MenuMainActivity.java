package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hackmusk.apphelpme.R;

public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        getSupportActionBar().hide();

    }
}
