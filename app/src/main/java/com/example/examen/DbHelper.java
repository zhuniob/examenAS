package com.example.examen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBRE = "registroEmpleados.db";
    private static final int DATA_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbEmpleados.CREAR_TABLA_EMPLEADOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + DbEmpleados.TABLA_EMPLEADOS);
    }

    protected void noQuery(String nsql){ this.getWritableDatabase().execSQL(nsql);}
    protected Cursor query(String sql){ return this.getReadableDatabase().rawQuery(sql, null);}

}
