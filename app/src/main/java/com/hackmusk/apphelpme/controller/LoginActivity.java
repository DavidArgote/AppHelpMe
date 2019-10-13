package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackmusk.apphelpme.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUser, editPass;
    private ImageButton btnClose;
    private ImageView btnLogin;
    private TextView btnGoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initViews();

    }

    private void initViews() {

        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnClose = findViewById(R.id.btnCloseLogin);
        btnClose.setOnClickListener(this);

        btnGoRegister = findViewById(R.id.tvGoRegister);
        btnGoRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnLogin:
                //TODO IR A MAIN
                break;

            case  R.id.btnCloseLogin:
                System.exit(0);
                break;

            case R.id.tvGoRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

        }
    }
}
