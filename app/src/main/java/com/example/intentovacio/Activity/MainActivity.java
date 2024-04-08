package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentovacio.Adapter.ListAdapter;
import com.example.intentovacio.Domain.ListDomain;
import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterList;
    private RecyclerView recyclerViewList;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initRecyclerview();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout homeBtn=findViewById(R.id.Home);
        LinearLayout reservasBtn=findViewById(R.id.Reservas);
        //LinearLayout historialBtn=findViewById(R.id.Historial);
        //LinearLayout perfilBtn=findViewById(R.id.Perfil);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));

        reservasBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Reservas.class)));


    }

    private void initRecyclerview() {
        ArrayList<ListDomain> items= new ArrayList<>();
        //aca debe de estar la implementacion de base de datos
        items.add(new ListDomain("Raquetas de Pin-Pong", "asd","Stock:3","Disponible", "pinpong", "4.5","1 P.M.-7 P.m.", "B"));
        items.add(new ListDomain("Balon Voley", "sdf","Stock:5","Disponible", "futbol", "3.0","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Rummi-Q", "dfg","Stock:2","Disponible", "rummiq", "4.0","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Rummi-Q", "fgh", "Stock:2","Disponible", "rummiq", "2.2","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Balon Voley", "ghj","Stock:5","Disponible", "futbol", "4.3","1 P.M.-7 P.m.", "Bloque"));

        recyclerViewList=findViewById(R.id.view1);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterList=new ListAdapter(items);
        recyclerViewList.setAdapter(adapterList);
    }
}
