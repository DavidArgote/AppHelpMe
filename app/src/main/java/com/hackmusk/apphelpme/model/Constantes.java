package com.hackmusk.apphelpme.model;

public class Constantes {

    public static String NAME_DATA_BASE = "HELPMEDB.db";
    public static int VERSION_DB = 1;

    public static String NAME_TABLE_USER = "USER";
    public static String NAME_TABLE_PUBLIC = "PUBLICATION";

    public static String USER_COLUMN_1 = "ID";
    public static String USER_COLUMN_2 = "NAME";
    public static String USER_COLUMN_3 = "CELLPHONE";
    public static String USER_COLUMN_4 = "CITY";
    public static String USER_COLUMN_5 = "USER_NAME";
    public static String USER_COLUMN_6 = "PASSWORD";

    public static String PUBLIC_COLUMN_1 = "ID";
    public static String PUBLIC_COLUMN_2 = "ID_USER";
    public static String PUBLIC_COLUMN_3 = "URL_PHOTO";
    public static String PUBLIC_COLUMN_4 = "DIRECTION";
    public static String PUBLIC_COLUMN_5 = "DESC";

    public static String CREATE_TABLE_USER = "CREATE TABLE " + NAME_TABLE_USER + "(" + USER_COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            USER_COLUMN_2 + " TEXT," + USER_COLUMN_3 + " TEXT," + USER_COLUMN_4 + " INTEGER," + USER_COLUMN_5 + " TEXT," + USER_COLUMN_6 + " TEXT)";

    public static String CREATE_TABLE_PUBLIC = "CREATE TABLE " + NAME_TABLE_PUBLIC + "(" + PUBLIC_COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PUBLIC_COLUMN_2 + " INTEGER," + PUBLIC_COLUMN_3 + " TEXT," + PUBLIC_COLUMN_4 + " TEXT," + PUBLIC_COLUMN_5 + " TEXT,"
            + " FOREIGN KEY (" + PUBLIC_COLUMN_2 + ") REFERENCES " + NAME_TABLE_USER + "(" + USER_COLUMN_1 + "))";

}
