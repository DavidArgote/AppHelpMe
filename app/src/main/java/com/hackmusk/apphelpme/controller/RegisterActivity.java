package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.ManagerHelper;
import com.hackmusk.apphelpme.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText editName, editCell, editUser, editPass, editConfirmPass;
    private ImageView btnRegister;
    private ImageButton btnReturn;
    private Spinner spCitys;
    private User user;
    private ManagerHelper managerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        initVews();

    }

    private void initVews() {

        editName = findViewById(R.id.editNameRegister);
        editCell = findViewById(R.id.editCellphoneRegister);
        editUser = findViewById(R.id.editUserRegister);
        editPass = findViewById(R.id.editPassRegister);
        editConfirmPass = findViewById(R.id.editConfirmPassRegister);

        spCitys = findViewById(R.id.spCitys);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        btnReturn = findViewById(R.id.btnCloseRegister);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void save() {

        user = new User();
        managerHelper = new ManagerHelper(RegisterActivity.this);

        user.setNombre(editName.getText().toString());
        user.setTelefono(editCell.getText().toString());
        user.setId_ciudad(spCitys.getSelectedItemPosition());
        user.setUserName(editUser.getText().toString());
        user.setPassword(editPass.getText().toString());

        if (user.getPassword().equals(editConfirmPass.getText().toString())) {

            if (user.getNombre().equals("") && user.getId_ciudad() != 0 && user.getUserName().equals("")) {

                Toast.makeText(RegisterActivity.this, "Tienes algun campo vacio", Toast.LENGTH_SHORT).show();

            } else {

                long insert = managerHelper.insertUser(user);

                if (insert > 0) {
                    ejectDialogCorrect();
                } else {
                    Toast.makeText(RegisterActivity.this, "Error en la base de datos", Toast.LENGTH_SHORT).show();
                }
            }

        } else {
            editConfirmPass.setError("Escribe la confirmación de la contraseña");
        }

    }

    private void ejectDialogCorrect() {

        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setIcon(R.drawable.logo_solo_mini);
        builder.setTitle("Exito!");
        builder.setMessage("Tus datos se han almacenado correctamente.");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        builder.show();

    }

}
