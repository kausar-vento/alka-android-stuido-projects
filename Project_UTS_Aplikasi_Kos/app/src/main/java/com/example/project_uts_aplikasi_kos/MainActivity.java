package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView menuPesan;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Session(this);
        if (!session.loggedin()) {
            prosesLogout();
        }

        menuPesan = (CardView) findViewById(R.id.pesan);
        menuPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(MainActivity.this, PesanActivity.class);
                startActivity(inte);
            }
        });
    }

    private void prosesLogout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    public void logout(View view) {
        prosesLogout();
    }

    public void listPesanan(View view) {
        Intent inte = new Intent(MainActivity.this, ListPesananActivity.class);
        startActivity(inte);
    }
}