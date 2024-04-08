package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentovacio.Helper.ChangeCodeItemsListener;
import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;

public class Reservas extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagmentReservas managmentReservas;

    private TextView titulo, code;

    private ScrollView scrollView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        managmentReservas = new ManagmentReservas(this);

        initView();
        setvariable();
        initList();
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        //recyclerView.setLayoutManager(linearLayoutManager);
        /*
        adapter=new ListAdapter(managmentReservas.getListReservas(), this, new ChangeCodeItemsListener(){
            @Override
            public void change() {

            }
        });
        */
         recyclerView.setAdapter(adapter);
         /*
         if(managmentReservas.getListReservas().isEmpty()){
             titulo.setVisibility(View.VISIBLE);
             scrollView.setVisibility(View.GONE);
         }else{

         }
          */


    }

    private void setvariable() {
        backBtn.setOnClickListener(v -> {
            //startActivity(new Intent(Reservas.this, MainActivity.class));
            finish();
        });
    }

    private void initView() {
        titulo= findViewById(R.id.titleTex);
        code=findViewById(R.id.Codigo);
        backBtn=findViewById(R.id.BackBtnr);


    }
}
