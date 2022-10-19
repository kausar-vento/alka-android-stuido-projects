package com.example.muhamadalkausarramadhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.muhamadalkausarramadhan.adapters.SuperHeroAdapter;
import com.example.muhamadalkausarramadhan.models.SuperHero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    instansi Recyclerview
    RecyclerView rvSuperHero;
    //  instansi list superhero
    List<SuperHero> listSuperHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menyambungkan rvSuperHero ke layout
        rvSuperHero = findViewById(R.id.rvSuperHero);
        //Membuat object hero
        SuperHero hero = new SuperHero("Petruk");
        //menambahkan hero ke listSuperHero
        listSuperHero.add(hero);
        //membuat object hero baru
        hero = new SuperHero("Gareng");
        //menambahkan hero baru ke listSuperhero
        listSuperHero.add(hero);
        // instansi adapter
        SuperHeroAdapter superHeroAdapter = new SuperHeroAdapter(listSuperHero);
        // set adapter dan layout manager
        rvSuperHero.setAdapter(superHeroAdapter);
        rvSuperHero.setLayoutManager(new LinearLayoutManager(this));
    }
}