package com.example.intentovacio.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class Perfil extends Activity {

    TextView correo,celular,codigo,carrera;
    private FirebaseFirestore mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        mDatabase = FirebaseFirestore.getInstance();
        correo = findViewById(R.id.correo);
        celular = findViewById(R.id.celular);
        codigo = findViewById(R.id.codigo);
        carrera = findViewById(R.id.carrera);
        mDatabase.collection("Usuario").document(correo.getText().toString()).get().addOnSuccessListener(resultado->{
            String correo1 = resultado.getString("correo");
            Double celular  = resultado.getDouble("celular");
            correo.setText("El numero de celular es: " + celular);
        });

    }
}