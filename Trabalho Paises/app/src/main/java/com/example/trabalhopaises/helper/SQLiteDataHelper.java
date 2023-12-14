package com.example.trabalhopaises.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {

    public SQLiteDataHelper(@Nullable Context context, @Nullable String name,  @Nullable SQLiteDatabase.CursorFactory factory,  int version) {
        super(context, name, factory, version);
    }
    @Override
    public  void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE PAIS (CODIGO INTEGER, DESCRICAO VARCHAR(100))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
