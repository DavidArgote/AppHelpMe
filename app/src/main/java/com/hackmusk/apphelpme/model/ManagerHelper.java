package com.hackmusk.apphelpme.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ManagerHelper {

    private Context context;
    private ControlHelper controlHelper;
    private SQLiteDatabase db;
    private ContentValues values;
    private long insert;

    public ManagerHelper(Context context) {
        this.controlHelper = new ControlHelper(context);
    }

    public void openDbWrite() {
        db = controlHelper.getWritableDatabase();
    }

    public void openDbRead() {
        db = controlHelper.getReadableDatabase();
    }

    public void closeDb() {
        if (db != null) db.close();
    }

    public long insertUser(User user) {

        openDbWrite();

        values = new ContentValues();

        values.put(Constantes.USER_COLUMN_2, user.getNombre());
        values.put(Constantes.USER_COLUMN_3, user.getTelefono());
        values.put(Constantes.USER_COLUMN_4, user.getId_ciudad());
        values.put(Constantes.USER_COLUMN_5, user.getUserName());
        values.put(Constantes.USER_COLUMN_6, user.getPassword());

        insert = db.insert(Constantes.NAME_TABLE_USER, null, values);

        closeDb();

        return insert;

    }


}
