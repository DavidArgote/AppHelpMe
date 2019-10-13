package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.ManagerHelper;
import com.hackmusk.apphelpme.model.User;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {

    private int id;
    private EditText editName, editCell, editEmail, editPass;
    private ImageView ivClose, ivSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        getSupportActionBar().hide();
        id = getIntent().getIntExtra("user", 0);

        initViews();
        
    }

    private void initViews() {

        ManagerHelper managerHelper = new ManagerHelper(PerfilActivity.this);
        ArrayList<User> users = new ArrayList<>(managerHelper.searchUserForUserId(id));

        editName = findViewById(R.id.editNamePerfil);
        editCell = findViewById(R.id.editCellphonePerfil);
        editEmail = findViewById(R.id.editCorreoPerfil);
        editPass = findViewById(R.id.editPasswordPerfil);
        ivClose = findViewById(R.id.btnClosePerfil);
        ivSave = findViewById(R.id.btnSavePerfil);

       if (users.size() != 0){
           editName.setText(users.get(0).getNombre());
           editCell.setText(users.get(0).getTelefono());
           editEmail.setText(users.get(0).getUserName());
           editPass.setText(users.get(0).getPassword());
       }


        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ivSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

    }

    private void save() {

    }
}
