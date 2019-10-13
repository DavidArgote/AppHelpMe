package com.hackmusk.apphelpme.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<User> searchUserForUserName(String[] userName) {

        openDbRead();

        ArrayList<User> list = new ArrayList<>();
        String[] columns = {Constantes.USER_COLUMN_1, Constantes.USER_COLUMN_2, Constantes.USER_COLUMN_3, Constantes.USER_COLUMN_4,
                Constantes.USER_COLUMN_5, Constantes.USER_COLUMN_6};

        Cursor cursor = db.query(Constantes.NAME_TABLE_USER, columns, Constantes.USER_COLUMN_5 + "=?", userName, null, null, null);

        if (cursor.moveToFirst()) {

            do {

                User user = new User();

                user.setId(cursor.getInt(0));
                user.setNombre(cursor.getString(1));
                user.setTelefono(cursor.getString(2));
                user.setId_ciudad(cursor.getInt(3));
                user.setUserName(cursor.getString(4));
                user.setPassword(cursor.getString(5));

                list.add(user);

            } while (cursor.moveToNext());

        }

        closeDb();

        return list;

    }

    public List<User> searchUserForUserId(int id) {

        openDbRead();

        ArrayList<User> list = new ArrayList<>();

        String[] param = {String.valueOf(id)};
        String[] columns = {Constantes.USER_COLUMN_1, Constantes.USER_COLUMN_2, Constantes.USER_COLUMN_3, Constantes.USER_COLUMN_4,
                Constantes.USER_COLUMN_5, Constantes.USER_COLUMN_6};

        Cursor cursor = db.query(Constantes.NAME_TABLE_USER, columns, Constantes.USER_COLUMN_5 + "=?", param, null, null, null);

        if (cursor.moveToFirst()) {

            do {

                User user = new User();

                user.setId(cursor.getInt(0));
                user.setNombre(cursor.getString(1));
                user.setTelefono(cursor.getString(2));
                user.setId_ciudad(cursor.getInt(3));
                user.setUserName(cursor.getString(4));
                user.setPassword(cursor.getString(5));

                list.add(user);

            } while (cursor.moveToNext());

        }

        closeDb();

        return list;

    }

    public List<Publication> searchPublicationForCity(int id) {

        openDbRead();

        ArrayList<Publication> list = new ArrayList<>();
        String[] param = {String.valueOf(id)};
        String[] columns = {Constantes.PUBLIC_COLUMN_1, Constantes.PUBLIC_COLUMN_2, Constantes.PUBLIC_COLUMN_3, Constantes.PUBLIC_COLUMN_4,
                Constantes.PUBLIC_COLUMN_5, Constantes.PUBLIC_COLUMN_6, Constantes.PUBLIC_COLUMN_7};

        Cursor cursor = db.query(Constantes.NAME_TABLE_PUBLIC, columns, Constantes.PUBLIC_COLUMN_7 + "=?", param, null, null, null);

        if (cursor.moveToFirst()) {

            do {

                Publication publication = new Publication();

                publication.setId(cursor.getInt(0));
                publication.setIdUser(cursor.getString(1));
                publication.setUrlPhoto(cursor.getString(2));
                publication.setDirection(cursor.getString(3));
                publication.setDesc(cursor.getString(4));
                publication.setDate(cursor.getString(5));
                publication.setCity(Integer.parseInt(cursor.getString(6)));

                list.add(publication);

            } while (cursor.moveToNext());

        }

        closeDb();

        return list;

    }

    public long insertPublic(Publication publication){

        openDbWrite();

        values = new ContentValues();

        values.put(Constantes.PUBLIC_COLUMN_2, publication.getIdUser());
        values.put(Constantes.PUBLIC_COLUMN_3, publication.getUrlPhoto());
        values.put(Constantes.PUBLIC_COLUMN_4, publication.getDirection());
        values.put(Constantes.PUBLIC_COLUMN_5, publication.getDesc());
        values.put(Constantes.PUBLIC_COLUMN_6, publication.getDate());
        values.put(Constantes.PUBLIC_COLUMN_7, publication.getCity());

        insert = db.insert(Constantes.NAME_TABLE_PUBLIC, null, values);

        closeDb();

        return insert;

    }

    public List<Publication> searchPublication() {

        openDbRead();

        ArrayList<Publication> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.NAME_TABLE_PUBLIC, null);

        if (cursor.moveToFirst()) {

            do {

                Publication publication = new Publication();

                publication.setId(cursor.getInt(0));
                publication.setIdUser(cursor.getString(1));
                publication.setUrlPhoto(cursor.getString(2));
                publication.setDirection(cursor.getString(3));
                publication.setDesc(cursor.getString(4));
                publication.setDate(cursor.getString(5));
                publication.setCity(Integer.parseInt(cursor.getString(6)));

                list.add(publication);

            } while (cursor.moveToNext());

        }

        closeDb();

        return list;

    }

}
