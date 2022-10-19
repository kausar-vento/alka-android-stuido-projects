package com.example.project_uts_alkausar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    // Key-key untuk data yang disimpan di SharedPrefernces
    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    // SharedPreferences yang akan digunakan untuk menulis dan membaca data
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.sharedPrefs = this.getSharedPreferences("dtsapp_sharedprefs", Context.MODE_PRIVATE);
        cardView1 = findViewById(R.id.cardView01);
        cardView2 = findViewById(R.id.cardView02);
        cardView3 = findViewById(R.id.cardView03);
        cardView4 = findViewById(R.id.cardView04);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBtnLogout_Click(View view)
    {
        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        editor.remove(KEEP_LOGIN_KEY);
        
    }

}