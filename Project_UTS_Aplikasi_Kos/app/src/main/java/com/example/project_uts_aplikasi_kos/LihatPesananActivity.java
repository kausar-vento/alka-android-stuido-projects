package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LihatPesananActivity extends AppCompatActivity {
    TextView idKost, namaLengkapKost, jklKost, namaKost, jenisKamarkost, lamaSewaKost;
    DataHelper dHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pesanan);
        dHelper = new DataHelper(this);
        idKost = (TextView) findViewById(R.id.idKost);
        namaLengkapKost = (TextView) findViewById(R.id.namaLengkapKost);
        jklKost = (TextView) findViewById(R.id.jklKost);
        namaKost = (TextView) findViewById(R.id.namaKost);
        jenisKamarkost = (TextView) findViewById(R.id.jenisKamarKost);
        lamaSewaKost = (TextView) findViewById(R.id.lamaSewaKost);
        SQLiteDatabase db = dHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kosts WHERE nama_lengkap = '"+getIntent().getStringExtra("nama_lengkap")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0)
        {
            cursor.moveToPosition(0);
            idKost.setText("ID Anda:                    "+cursor.getString(0).toString());
            namaLengkapKost.setText("Nama Anda:         "+cursor.getString(1).toString());
            jklKost.setText("Kelamin Anda:              "+cursor.getString(2).toString());
            namaKost.setText("Nama Tempat Kos Anda: "+cursor.getString(3).toString());
            jenisKamarkost.setText("Jenis Kos Anda:     "+cursor.getString(4).toString());
            lamaSewaKost.setText("Lama Sewa Kos Anda:   "+cursor.getString(5).toString()+" Bulan");
        }

    }

    public void kemListPesanan(View view) {
        Intent inte = new Intent(LihatPesananActivity.this, ListPesananActivity.class);
        startActivity(inte);
    }
}