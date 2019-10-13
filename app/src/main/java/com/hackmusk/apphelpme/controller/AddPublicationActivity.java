package com.hackmusk.apphelpme.controller;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.frosquivel.magicalcamera.MagicalCamera;
import com.frosquivel.magicalcamera.MagicalPermissions;
import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.ManagerHelper;
import com.hackmusk.apphelpme.model.Publication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class AddPublicationActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView btnClose, btnRecordAudio, btnSend, ivPhoto, btnTakePhoto;
    private EditText editDirec, editDesc;
    private Spinner spCitys;

    private String urlPhoto = "";
    private LocalDate localDate = null;

    public static String[] PERMISSONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
            , Manifest.permission.CAMERA};

    private MagicalCamera magicalCamera;
    private MagicalPermissions permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_publication);

        getSupportActionBar().hide();

        initViews();

        permissions = new MagicalPermissions(this, PERMISSONS);
        magicalCamera = new MagicalCamera(this, 10,permissions);

    }

    private void initViews() {

        btnClose = findViewById(R.id.btnCloseAdd);
        btnClose.setOnClickListener(this);

        btnRecordAudio = findViewById(R.id.btnRecordAudio);
        btnRecordAudio.setOnClickListener(this);

        btnSend = findViewById(R.id.btnSendPublic);
        btnSend.setOnClickListener(this);

        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        btnTakePhoto.setOnClickListener(this);

        ivPhoto = findViewById(R.id.ivPhotoTake);
        editDirec = findViewById(R.id.editDirAdd);
        editDesc = findViewById(R.id.editDescAdd);
        spCitys = findViewById(R.id.spCitysAdd);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnCloseAdd:
                finish();
                break;
            case R.id.btnRecordAudio:
                //TODO API AUDIO
                break;
            case R.id.btnSendPublic:

                if (editDirec.getText().equals("")) {
                    editDirec.setError("Ingresa la dirección");
                } else {
                    save();
                }

                break;
            case R.id.btnTakePhoto:
                magicalCamera.takePhoto();
                break;

        }
    }

    private void save() {

        if (urlPhoto.equals("")) {
            Toast.makeText(this, "Toma una foto para tener evidencia", Toast.LENGTH_SHORT).show();
        } else {

            if (spCitys.getSelectedItemPosition() != 0) {

                Publication publication = new Publication();
                ManagerHelper managerHelper = new ManagerHelper(AddPublicationActivity.this);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    localDate = LocalDate.now();
                }

                publication.setIdUser(getIntent().getStringExtra("userName"));
                publication.setUrlPhoto(urlPhoto);
                publication.setDirection(editDirec.getText().toString());
                publication.setDesc(editDesc.getText().toString());
                publication.setDate(localDate.toString());
                publication.setCity(spCitys.getSelectedItemPosition());

                long insert = managerHelper.insertPublic(publication);

                if (insert > 0){

                    AlertDialog.Builder dialog = new AlertDialog.Builder(AddPublicationActivity.this);
                    dialog.setTitle("Exito!");
                    dialog.setMessage("Se ha registrad tú caso");

                    dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(AddPublicationActivity.this, MenuMainActivity.class));
                            finish();
                        }
                    });

                    dialog.show();

                }else{
                    Toast.makeText(this, "Error en la bd", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Selecciona una ciudad", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        magicalCamera.resultPhoto(requestCode, resultCode, data, MagicalCamera.ORIENTATION_ROTATE_90);

        if (magicalCamera != null){

            Bitmap bitmap = Bitmap.createScaledBitmap(magicalCamera.getPhoto(), 300,340, true);
            ivPhoto.setImageBitmap(bitmap);

            urlPhoto = magicalCamera.savePhotoInMemoryDevice(magicalCamera.getPhoto(), UUID.randomUUID().toString(), MagicalCamera.JPEG, false);
        }

    }

}
