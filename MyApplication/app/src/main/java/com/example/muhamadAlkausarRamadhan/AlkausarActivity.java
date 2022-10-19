package com.example.muhamadAlkausarRamadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class AlkausarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alkausar);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"App on Start",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"App on Stop", Toast.LENGTH_SHORT).show();
    }
}