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
import android.widget.Toast;

import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.ManagerHelper;
import com.hackmusk.apphelpme.model.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUser, editPass;
    private ImageButton btnClose;
    private ImageView btnLogin;
    private TextView btnGoRegister;
    private ArrayList<User> list;
    private ManagerHelper managerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initViews();

    }

    private void initViews() {

        managerHelper = new ManagerHelper(LoginActivity.this);

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

        switch (v.getId()) {

            case R.id.btnLogin:
                if (!editUser.getText().equals("") || editPass.getText().equals("")) {
                    if (searchUser()) {
                        Intent intent = new Intent(LoginActivity.this, MenuMainActivity.class);
                        intent.putExtra("userName", list.get(0).getId());
                        startActivity(intent);
                        finish();
                    } else {
                        editPass.setError("Contraseña icorrecta");
                        editPass.setText("");
                    }
                }else if (editPass.equals("")){
                    editPass.setError("Digita la contraseña");
                }else {
                    editUser.setText("Digita tú usuario");
                }
                break;

            case R.id.btnCloseLogin:
                System.exit(0);
                break;

            case R.id.tvGoRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

        }
    }

    private boolean searchUser() {

        String[] user = {editUser.getText().toString()};
        list = new ArrayList<>(managerHelper.searchUserForUserName(user));

        if (editUser.getText().toString().equals(list.get(0).getUserName()) &&
                editPass.getText().toString().equals(list.get(0).getPassword())) {
            return true;
        }

        return false;

    }
}
