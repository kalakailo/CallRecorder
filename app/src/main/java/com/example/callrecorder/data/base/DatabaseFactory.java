package com.example.callrecorder.data.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFactory extends SQLiteOpenHelper{
    private static DatabaseFactory dbHelper;
         private final static String DB_NAME = "DataBase";
         private final static int DB_VERSION = 1;


    private SQLiteDatabase db;
    public DatabaseFactory(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public static DatabaseFactory getInstance(Context context){
        if (dbHelper == null){
            dbHelper = new DatabaseFactory(context);
        }
        return dbHelper;
    }
    public SQLiteDatabase open(){
        db = getWritableDatabase();
                 return db;
    }
    public void close(){
        db.close();
                 db = null;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE.CALLS.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
