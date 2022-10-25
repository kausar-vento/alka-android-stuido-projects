package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListPesananActivity extends AppCompatActivity {
    String[] daftar;
    ListView lPesanan;
    Menu menu;
    protected Cursor cursor;
    DataHelper dHelper;
    public static ListPesananActivity lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pesanan);
        lp = this;
        dHelper = new DataHelper(this);
        RefreshList();
    }
    public void RefreshList(){
        SQLiteDatabase db = dHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kosts", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int cc=0; cc<cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        lPesanan = (ListView)findViewById(R.id.dataPesanan);
        lPesanan.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        lPesanan.setSelected(true);
        lPesanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ListPesananActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item){
                        switch (item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatPesananActivity.class);
                                i.putExtra("nama_lengkap", selection);
                                startActivity(i);
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)lPesanan.getAdapter()).notifyDataSetInvalidated();
    }

    public void bMenu(View view) {
        Intent inte = new Intent(ListPesananActivity.this, MainActivity.class);
        startActivity(inte);
    }
}