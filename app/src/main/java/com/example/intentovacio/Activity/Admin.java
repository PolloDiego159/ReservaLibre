package com.example.intentovacio.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.R;

public class Admin extends AppCompatActivity {

    EditText codigopre, fechapre, horapre, codigode, fechade, horade;
    private Button prestamo, actualizar, addelemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        codigopre = findViewById(R.id.re_codigo_estudiantes);
        fechapre = findViewById(R.id.re_fecha_prestamo);
        horapre = findViewById(R.id.re_hora_prestamo);

        codigode = findViewById(R.id.de_codigo_elemento);
        fechade = findViewById(R.id.de_fecha_prestamo);
        horade = findViewById(R.id.de_hora_prestamo);

        prestamo = findViewById(R.id.btn_reserva);
        actualizar = findViewById(R.id.btn_actualizar);

        prestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de reservado
                Toast.makeText(Admin.this, "Reservado", Toast.LENGTH_SHORT).show();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de actualizado
                Toast.makeText(Admin.this, "Actualizado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}