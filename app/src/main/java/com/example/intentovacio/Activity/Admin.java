package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.R;

public class Admin extends AppCompatActivity {

    EditText codigopre, fechapre, horapre, codigode, fechade, horade;
    private Button prestamo, actualizar, addelemento;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        codigopre = findViewById(R.id.re_codigo_elemento);
        fechapre = findViewById(R.id.re_fecha_prestamo);
        horapre = findViewById(R.id.re_hora_prestamo);

        codigode = findViewById(R.id.de_codigo_elemento);
        fechade = findViewById(R.id.de_fecha_prestamo);
        horade = findViewById(R.id.de_hora_prestamo);

        prestamo = findViewById(R.id.btn_reserva);
        actualizar = findViewById(R.id.btn_actualizar);
        addelemento = findViewById(R.id.btn_agregar);

        prestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hacer proceso para marcar el elemento que se presta
                //myDB.añadir_usuario(correo.getText().toString().trim(), clave.getText().toString().trim());
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hacer para desmarcar el elemento que fue prestado
                //myDB.añadir_usuario(correo.getText().toString().trim(), clave.getText().toString().trim());
            }
        });

        addelemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this, Adicion.class));
            }
        });


    }

}
