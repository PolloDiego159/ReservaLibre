package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.R;

public class Adicion  extends AppCompatActivity {
    private ImageView backBtn;
    EditText codigo, nombre, descripcion, ubicacion, horario;
    private Button foto, subir;
    private ImageView backbt;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicion);
        codigo = findViewById(R.id.et_codigo);
        nombre = findViewById(R.id.et_nombre);
        descripcion = findViewById(R.id.et_descripcion);
        ubicacion = findViewById(R.id.et_ubicacion);
        horario = findViewById(R.id.et_horario_prestamo);


        foto = findViewById(R.id.btn_subir_imagen);
        subir = findViewById(R.id.btn_guardar);

        backbt=findViewById(R.id.BackBtnr);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adicion.this, Admin.class));
            }
        });

    }
}
