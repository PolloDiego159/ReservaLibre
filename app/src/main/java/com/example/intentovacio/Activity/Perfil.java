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
    public AppCompatTextView celular, codigo,  facultad;

    TextView correo, nombre;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();





    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        correo = findViewById(R.id.correop);
        nombre = findViewById(R.id.nom);

        obtenerUserData(correo, nombre);


    }
/*
    private void datos(String correo, String celular) {


        db.collection("Usuario").whereEqualTo("1", correo).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        if (!querySnapshot.isEmpty()) {
                            DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                            String celular = document.getString("celular");


                        } else {
                            // Handle the case where no document matching the email is found
                            Log.d("datos", "No se encontró ningún documento para el correo: " + correo);
                        }

                    }

                });
        Toast.makeText(this, celular, Toast.LENGTH_SHORT).show();
    }

 */

    private void obtenerUserData(TextView nombre, TextView correo){
        db.collection("Usuario").document("1").get().addOnSuccessListener(documento ->{
            if (documento.exists()){
                nombre.setText(documento.getString("nombre"));
                correo.setText(documento.getString("correo"));
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