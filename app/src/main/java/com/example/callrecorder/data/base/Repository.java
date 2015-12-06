package com.example.callrecorder.data.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.callrecorder.domain.entities.Calls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class Repository {
    private SQLiteDatabase database;
    private Context context;

    public Repository(Context context) {
        this.context = context;
    }


    public void openDatabase() {
        database = DatabaseFactory.getInstance(context).open();
    }

    public void closeDatabase() {
        DatabaseFactory.getInstance(context).close();
        database = null;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public List<Calls> getCalls() {
        List<Calls> list = new ArrayList<>();
        final String SELECT = "SELECT * FROM " + TABLE.CALLS.TABLE_NAME;

        openDatabase();
        Cursor cursor = database.rawQuery(SELECT, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(TABLE.CALLS.getCalls(cursor));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public Calls getAlbum(long id) {
        Calls calls = null;
        final String SELECT = " select * from " + TABLE.CALLS.TABLE_NAME + " as t " +
                " where t." + TABLE.CALLS.ID + " = " + id;

        openDatabase();

        Cursor cursor = getDatabase().rawQuery(SELECT, null);

        if (cursor.moveToFirst()) {
            calls = TABLE.CALLS.getCalls(cursor);
        }

        closeDatabase();
        return calls;
    }


    public void insertCalls(Calls calls) {
        openDatabase();

        long id = getDatabase().insert(TABLE.CALLS.TABLE_NAME, null, TABLE.CALLS.getContentValues(calls, false));
        calls.setId(id);
        closeDatabase();
    }
}
