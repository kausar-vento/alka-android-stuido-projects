package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText userName, nAnda, passWord, alaMat;
    RadioGroup jKelamin;
    RadioButton pKelamin;
    Spinner pStatus;
    TextView tStatus;
    DataHelper dh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dh = new DataHelper(this);
        userName = (EditText) findViewById(R.id.username);
        nAnda = (EditText) findViewById(R.id.namaAnda);
        passWord = (EditText) findViewById(R.id.password);
        alaMat = (EditText) findViewById(R.id.alamat);
        jKelamin = (RadioGroup) findViewById(R.id.rg);
        pStatus = (Spinner) findViewById(R.id.spStatusAnda);
        tStatus = (TextView) findViewById(R.id.tvw);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.statusSekarang, android.R.layout.simple_spinner_dropdown_item);
        pStatus.setAdapter(adapter);
        pStatus.setOnItemSelectedListener(this);
    }

    public void kemLog(View view) {
        Intent inte = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(inte);
    }

    public void prosesReg(View view) {
        int kel = jKelamin.getCheckedRadioButtonId();
        pKelamin = findViewById(kel);
        SQLiteDatabase db = dh.getWritableDatabase();
        db.execSQL("insert into users(username, nama_anda, password, alamat, jenis_kelamin, status" +
                ") values('" +
                userName.getText().toString() + "','"+
                nAnda.getText().toString() + "','"+
                passWord.getText().toString() + "','"+
                alaMat.getText().toString() + "','"+
                pKelamin.getText().toString() + "','"+
                tStatus.getText().toString() + "')");
        displayToast("Akun Anda Berhasil DIbuat");
        Intent inte = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(inte);

    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String status = parent.getItemAtPosition(i).toString();
        tStatus.setText(String.valueOf(status));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}