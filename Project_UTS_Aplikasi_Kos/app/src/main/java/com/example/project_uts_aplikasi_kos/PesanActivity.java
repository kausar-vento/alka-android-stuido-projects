package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PesanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText namaLengkap, lamaSewa;
RadioGroup jenisKelamin, jenisKamar;
RadioButton kelaminPria, kelaminWanita, kamarMewah, kamarSederhana;
Spinner namaKos;
TextView nKos;
DataHelper dbHelper;
protected Cursor cursor;
Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        dbHelper = new DataHelper(this);
        namaLengkap = (EditText) findViewById(R.id.nama);
        lamaSewa = (EditText) findViewById(R.id.lamaSewa);
        // Jenis Kelamin
        jenisKelamin = (RadioGroup) findViewById(R.id.rg);
        // Jenis Kamar
        jenisKamar = (RadioGroup) findViewById(R.id.rk);
        // Nama Kos
        namaKos = (Spinner) findViewById(R.id.spNamaKos);
        nKos = (TextView) findViewById(R.id.tvw);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.namaTempatKos, android.R.layout.simple_spinner_dropdown_item);
        namaKos.setAdapter(adapter);
        namaKos.setOnItemSelectedListener(this);
    }

    public void backHome(View view) {
        Intent inte = new Intent(PesanActivity.this, MainActivity.class);
        startActivity(inte);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String kos = parent.getItemAtPosition(i).toString();
        nKos.setText(String.valueOf(kos));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void kirimData(View view) {
        int kelamin = jenisKelamin.getCheckedRadioButtonId();
        kelaminPria = findViewById(kelamin);
        int kamar = jenisKamar.getCheckedRadioButtonId();
        kamarMewah = findViewById(kamar);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into kosts(nama_lengkap, jkl, nama_kos, jenis_kamar, lama_sewa" +
                ") values('" +
                namaLengkap.getText().toString() + "','"+
                kelaminPria.getText().toString() + "','"+
                nKos.getText().toString() + "','"+
                kamarMewah.getText().toString() + "','"+
                lamaSewa.getText().toString() + "')");
        Toast.makeText(getApplicationContext(), "Berhasil ditambahkan", Toast.LENGTH_LONG);
        ListPesananActivity.lp.RefreshList();
        finish();
    }
}