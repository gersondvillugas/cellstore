package com.example.gerson.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseCel extends SQLiteOpenHelper {
    public DatabaseCel(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Cell.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
