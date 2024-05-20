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

        //LinearLayout historialBtn=findViewById(R.id.Historial);
        //LinearLayout perfilBtn=findViewById(R.id.Perfil);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));



    }

    private void initRecyclerview() {
        ArrayList<ListDomain> items= new ArrayList<>();
        //aca debe de estar la implementacion de base de datos
        items.add(new ListDomain("Raquetas de Pin-Pong", "Acceso a una mesa, dos raquetas, una malla resistente y un par de pelotas de pinpon. Desafia tus amigos, practica tu tecnica y diviertete en tu ambiente universitario. Reserva en base a disponibilidad","Stock:3","Disponible", "pinpong", "4.5","1 P.M.-7 P.m.", "B"));
        items.add(new ListDomain("Balon Futbol", "sdf","Stock:5","Disponible", "futbol", "3.0","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Rummi-Q", "dfg","Stock:2","Disponible", "rummiq", "4.0","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Ps5", "fgh", "Stock:2","Disponible", "ps5", "2.2","1 P.M.-7 P.m.", "Bloque"));
        items.add(new ListDomain("Balon Futbol Americano", "ghj","Stock:5","Disponible", "futa", "4.3","1 P.M.-7 P.m.", "Bloque"));

        recyclerViewList=findViewById(R.id.view1);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterList=new ListAdapter(items);
        recyclerViewList.setAdapter(adapterList);
    }

    public void irPerfil(View view){
        Intent i = new Intent(this, Perfil.class);
        startActivity(i);
    }

}
