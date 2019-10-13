package com.hackmusk.apphelpme.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hackmusk.apphelpme.R;
import com.hackmusk.apphelpme.model.AdapterListPublic;
import com.hackmusk.apphelpme.model.ManagerHelper;
import com.hackmusk.apphelpme.model.Publication;
import com.hackmusk.apphelpme.model.User;

import java.util.ArrayList;

public class MenuMainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcList;
    private ImageView btnClose, btnPerfil, btnMenu, btnGoAdd, btnGoMyList;
    private TextView tvMenssage;
    private ManagerHelper managerHelper;
    private ArrayList<Publication> listPublications;
    private ArrayList<User> user;
    private SharedPreferences preferences;

    public static String NAME_PREFERENCES = "PREFERENCES";
    public static String MY_KEY_USER = "id";

    boolean bandera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        getSupportActionBar().hide();
        managerHelper = new ManagerHelper(this);


        preferences = getSharedPreferences(NAME_PREFERENCES, MODE_PRIVATE);
        preferences.getInt(MY_KEY_USER, getIntent().getIntExtra("userId", 0));

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MY_KEY_USER, getIntent().getIntExtra("userId", 0));
        editor.apply();

        initViews();
        fillList();

    }

    private void initViews() {

        rcList = findViewById(R.id.rcListPublicMain);
        rcList.setLayoutManager(new LinearLayoutManager(MenuMainActivity.this));
        rcList.setHasFixedSize(true);

        tvMenssage = findViewById(R.id.tvMensaggeRc);

        btnClose = findViewById(R.id.ivCloseMain);
        btnClose.setOnClickListener(this);

        btnPerfil = findViewById(R.id.ivPerfil);
        btnPerfil.setOnClickListener(this);

        btnMenu = findViewById(R.id.ivPlusMenu);
        btnMenu.setOnClickListener(this);

        btnGoAdd = findViewById(R.id.btnGoAdd);
        btnGoAdd.setOnClickListener(this);

        btnGoMyList = findViewById(R.id.btnGoMiList);
        btnGoMyList.setOnClickListener(this);

    }

    private void fillList() {

        user = new ArrayList<>(managerHelper.searchUserForUserId(preferences.getInt("id", 0)));

        if (user != null && user.size() != 0) {

            listPublications = new ArrayList<>(managerHelper.searchPublicationForCity(user.get(0).getId_ciudad()));

            if (listPublications != null && listPublications.size() != 0) {

                AdapterListPublic adapter = new AdapterListPublic(MenuMainActivity.this, listPublications);
                rcList.setAdapter(adapter);

                tvMenssage.setVisibility(View.VISIBLE);

            } else {
                rcList.setVisibility(View.INVISIBLE);
                tvMenssage.setVisibility(View.VISIBLE);
            }

        } else {
            tvMenssage.setText("No se han encontrado publicaciones en tú ciudad");
            tvMenssage.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ivCloseMain:
                System.exit(0);
                break;

            case R.id.ivPerfil:
                break;

            case R.id.ivPlusMenu:

                if (bandera == false) {
                    btnGoAdd.setVisibility(View.VISIBLE);
                    btnGoMyList.setVisibility(View.VISIBLE);
                    bandera = true;
                }else {
                    btnGoAdd.setVisibility(View.INVISIBLE);
                    btnGoMyList.setVisibility(View.INVISIBLE);
                    bandera = false;
                }
                break;

            case R.id.btnGoAdd:
                break;

            case R.id.btnGoMiList:
                break;

        }
    }
}
