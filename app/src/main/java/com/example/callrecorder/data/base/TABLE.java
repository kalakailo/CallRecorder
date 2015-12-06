package com.example.callrecorder.data.base;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.callrecorder.domain.entities.Calls;

import java.util.Date;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class TABLE {
    public static class CALLS {
        public final static String TABLE_NAME = "CALLS";
        public final static String ID = "CALLS_ID";
        public final static String TYPE = "TYPE";
        public final static String PHONE = "PHONE";
        public final static String DATE = "DATE";
        public static String createTable() {
            return " create table " + TABLE_NAME + " ( " +
                    ID + " integer primary key autoincrement, " +
                    TYPE + " text, " +
                    PHONE + " text, " +
                    DATE + " text " +
                    " ) ";
        }
        public static String drop()
        {
            return "drop table " + TABLE_NAME;
        }

        public static ContentValues getContentValues(Calls calls, boolean addId) {
            ContentValues values = new ContentValues();
            if (addId) {
                values.put(ID, calls.getId());
            }
            values.put(TYPE, calls.getType());
            values.put(PHONE, calls.getPhone());
            values.put(DATE, ""+calls.getDate());
            return values;
        }

        public static Calls getCalls(Cursor cursor) {
            Date date = new Date();
            int indexType = cursor.getColumnIndexOrThrow(TYPE);
            int indexId = cursor.getColumnIndexOrThrow(ID);
            int indexPhone = cursor.getColumnIndexOrThrow(PHONE);
            int indexDate = cursor.getColumnIndexOrThrow(DATE);

            return new Calls(
                    cursor.getLong(indexId),
                    cursor.getString(indexType),
                    cursor.getString(indexPhone),
                    cursor.getString(indexDate));
        }
    }
}