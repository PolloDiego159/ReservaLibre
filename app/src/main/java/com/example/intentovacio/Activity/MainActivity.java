package com.example.intentovacio.Activity;

import android.os.Bundle;

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

    }

    private void initRecyclerview() {
        ArrayList<ListDomain> items= new ArrayList<>();
        //aca debe de estar la implementacion de base de datos
        items.add(new ListDomain("Raquetas de Pin-Pong", "Stock:3","Disponible", "pinpong"));
        items.add(new ListDomain("Balon Voley", "Stock:5","Disponible", "futbol"));
        items.add(new ListDomain("Rummi-Q", "Stock:2","Disponible", "rummiq"));
        items.add(new ListDomain("Rummi-Q", "Stock:2","Disponible", "rummiq"));

        recyclerViewList=findViewById(R.id.view1);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterList=new ListAdapter(items);
        recyclerViewList.setAdapter(adapterList);
    }
}
