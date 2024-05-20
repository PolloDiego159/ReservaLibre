package com.example.intentovacio.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.R;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    EditText correo, clave;

    private FirebaseFirestore db= FirebaseFirestore.getInstance();

    private Button material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.correo);
        clave = findViewById(R.id.clave);
        material = findViewById(R.id.material);

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciosesion(correo.getText().toString(), clave.getText().toString());
            }
        });



    }
    private void iniciosesion(String correo, String clave){
        /*
        if (!db.disableNetwork()) {
            // La conexión está establecida

        } else {
            // No hay conexión
            Log.w("Firebase", "Sin conexión a la base de datos");
        }
        */

        db.collection("Usuario").document(correo).get().addOnSuccessListener(tarea->{
            String clave1;
            clave1 = (String) tarea.get("password");

            if (clave.equals(clave1)){
                startActivity(new Intent(Login.this, MainActivity.class));
                Toast.makeText(this, "Aprovado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Usuario y/o contraseña incorrecta" , Toast.LENGTH_LONG).show();
            }
        });

    }
}
