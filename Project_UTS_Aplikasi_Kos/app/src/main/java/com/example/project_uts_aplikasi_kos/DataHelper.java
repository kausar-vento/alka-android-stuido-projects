package com.example.project_uts_aplikasi_kos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "project_kos.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table kosts" +
                "(id integer PRIMARY KEY AUTOINCREMENT, " +
                "nama_lengkap text null, " +
                "jkl text null, " +
                "nama_kos text null, " +
                "jenis_kamar text null, " +
                "lama_sewa integer null);";
        Log.d("Data", "onCreate: "+sql);

        String sql2 = "create table users" +
                "(id integer PRIMARY KEY AUTOINCREMENT, " +
                "username text null, " +
                "nama_anda text null, " +
                "password text null, " +
                "alamat text null, " +
                "jenis_kelamin text null, " +
                "status text null);";
        Log.d("Data", "onCreate: "+sql2);
        db.execSQL(sql);
        db.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS kosts");
        onCreate(db);
    }

    public boolean getUser(String user, String pass) {
        String selectQuery = "select * from  users where username = " +
                "'"+user+"'" + " and password = " + "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }
}
