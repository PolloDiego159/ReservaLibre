package com.example.intentovacio.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.intentovacio.Domain.ListDomain;
import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;

public class DetailActivity extends AppCompatActivity {
    private Button addreservaBtn;
    private TextView titleTxt, estadoTxt, descriptionTxt, scoreTxt, horarioTxt, ubicacionTxt;
    private ImageView picItem, backBtn;
    private ListDomain object;
    private int code;
    private ManagmentReservas managmentReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentReservas = new ManagmentReservas(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (ListDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);
        titleTxt.setText(object.getTitle());
        estadoTxt.setText(object.getEstado());
        descriptionTxt.setText(object.getDescripcion());
        scoreTxt.setText(object.getScore());
        horarioTxt.setText(object.getHorario());
        ubicacionTxt.setText(object.getUbicacion());

        addreservaBtn.setOnClickListener(v -> {
            object.setCode(code);
            managmentReservas.insertFood(object);
        });

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }

    private void initView() {
        addreservaBtn = findViewById(R.id.addreservaBtn);
        titleTxt = findViewById(R.id.textTitulo);
        estadoTxt = findViewById(R.id.textEstado);
        descriptionTxt = findViewById(R.id.textDescription);
        picItem = findViewById(R.id.PicItem);
        scoreTxt = findViewById(R.id.textcalificacion);
        horarioTxt = findViewById(R.id.textHora);
        ubicacionTxt = findViewById(R.id.textLugar);
        backBtn = findViewById(R.id.BackBtn);
    }
}