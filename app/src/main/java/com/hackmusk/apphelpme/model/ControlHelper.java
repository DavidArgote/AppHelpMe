package com.hackmusk.apphelpme.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ControlHelper extends SQLiteOpenHelper {


    public ControlHelper(@Nullable Context context) {
        super(context, Constantes.NAME_DATA_BASE, null, Constantes.VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constantes.CREATE_TABLE_USER);
        db.execSQL(Constantes.CREATE_TABLE_PUBLIC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constantes.NAME_TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.NAME_TABLE_PUBLIC);

        onCreate(db);

    }
}
