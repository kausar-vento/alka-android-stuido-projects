package com.example.uts_alkausar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "latihan.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table users(no integer primary key AUTOINCREMENT NOT NULL, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: "+sql);
        db.execSQL(sql);
        sql = "INSERT INTO users (nama, tgl, jk, alamat) VALUES('Tamvan', '1996-07-12', 'Laki-laki', 'Indramayu');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        // TODO Auto-generated method stub
    }
}
