package com.example.intentovacio.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;

public class Perfil extends Activity {

    TextView correo,celular,codigo,carrera;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        correo = findViewById(R.id.correo);
        celular = findViewById(R.id.celular);
        codigo = findViewById(R.id.codigo);
        carrera = findViewById(R.id.carrera);
    }
}
