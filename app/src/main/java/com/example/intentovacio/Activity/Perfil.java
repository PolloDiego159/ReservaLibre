package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.intentovacio.R;

import com.google.firebase.firestore.FirebaseFirestore;


public class Perfil extends AppCompatActivity {
    public AppCompatTextView celular, codigoe,  facultad;

    TextView correo, nombre;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();





    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        correo = findViewById(R.id.correop);
        nombre = findViewById(R.id.nom);
        celular = findViewById(R.id.celular);
        codigoe = findViewById(R.id.codigoe);
        facultad = findViewById(R.id.facultad);

        obtenerUserData(correo, nombre, celular, codigoe, facultad);


    }


    private void obtenerUserData(TextView nombre, TextView correo, AppCompatTextView celular, AppCompatTextView codigoe, AppCompatTextView facultad){
        db.collection("Usuario").document("juand-rodriguezga@unilibre.edu.co").get().addOnSuccessListener(documento ->{
            if (documento.exists()){
                nombre.setText(documento.getString("nombre"));
                correo.setText(documento.getString("correo"));
                celular.setText(documento.get("celular").toString());
                codigoe.setText(documento.get("codigo").toString());
                facultad.setText(documento.getString("facultad"));

            }else{
                //no exite documento
            }

                }
        );
    }

    public void irInicio(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void irLogin(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}