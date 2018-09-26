package com.example.courbis_diaz.valeapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase  extends SQLiteOpenHelper{

    public static final int DATEBASE_VERSION=1;
    public static final String DATABASE_NAME="valeapp_db";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
