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
        items.add(new ListDomain("Raquetas de Pin-Pong", "Acceso a una mesa, dos raquetas, una malla resistente y un par de pelotas de pinpon. Desafia tus amigos, practica tu tecnica y diviertete en tu ambiente universitario. Reserva en base a disponibilidad","Stock:3","Disponible", "pinpong", "4.5","1 P.M.-7 P.m.", "Bloque D"));
        items.add(new ListDomain("Balon Baloncesto", "Acceso a un balón de baloncesto oficial. Juega con tus amigos, mejora tus tiros y disfruta del deporte en tu ambiente universitario. Reserva en base a disponibilidad.","Stock:10","Disponible", "baloncesto", "4.0","1 P.M.-7 P.m.", "PoliDeportivo"));
        items.add(new ListDomain("Balon Voleibol", "Acceso a un balón de voleibol de alta calidad. Organiza partidos con tus amigos, mejora tus habilidades y disfruta del deporte en tu ambiente universitario. Reserva en base a disponibilidad.","Stock:10","Disponible", "voley", "3.5","8 A.M.-7 P.m.", "PoliDeportivo"));
        items.add(new ListDomain("Ps5", "Ofrece una experiencia de juego increíblemente inmersiva y realista, gracias a su potente procesador, gráficos de última generación y almacenamiento SSD ultrarrápido. Con la PS5, podrás disfrutar de juegos exclusivos como Horizon Forbidden West, Ratchet & Clank: Rift Apart y Gran Turismo 7, que te transportarán a mundos increíbles y te harán vivir aventuras inolvidables.", "Stock:2","Disponible", "ps5", "4.2","1 P.M.-7 P.m.", "Bloque C"));
        items.add(new ListDomain("Balon Futbol", "Acceso a un balón de fútbol de alta calidad. Organiza partidos con tus amigos, practica tus habilidades y disfruta del deporte en tu ambiente universitario. Reserva en base a disponibilidad.","Stock:10","Disponible", "futbol", "4.3","8 A.M.-7 P.m.", "Zonas v"));

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
