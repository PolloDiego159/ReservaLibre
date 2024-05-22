package com.example.intentovacio.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    EditText correo, clave;
    boolean ad;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button material;
    private CheckBox checkBoxShowPassword, checkBoxRememberMe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.correo);
        clave = findViewById(R.id.clave);
        checkBoxShowPassword = findViewById(R.id.checkBoxShowPassword);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        material = findViewById(R.id.material);

        SharedPreferences credenciales = getSharedPreferences("datos", Context.MODE_PRIVATE);
        correo.setText(credenciales.getString("email", ""));
        clave.setText(credenciales.getString("password", ""));
        checkBoxRememberMe.setChecked(credenciales.getBoolean("rememberMe", false));

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciosesion(correo.getText().toString(), clave.getText().toString(), ad);
            }
        });

        // Listener para el CheckBox de mostrar/ocultar contraseña
        checkBoxShowPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Mostrar contraseña
                clave.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                // Ocultar contraseña
                clave.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }

    public void guardar(String email, String password, boolean rememberMe) {
        SharedPreferences creden = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = creden.edit();
        if (rememberMe) {
            Obj_editor.putString("email", email);
            Obj_editor.putString("password", password);
        } else {
            Obj_editor.remove("email");
            Obj_editor.remove("password");
        }
        Obj_editor.putBoolean("rememberMe", rememberMe);
        Obj_editor.apply();
    }

    private void iniciosesion(String correo, String clave, boolean ad) {
        db.collection("Usuario").document(correo).get().addOnSuccessListener(tarea -> {
            String clave1 = (String) tarea.get("password");
            Boolean admin = (Boolean) tarea.get("ad");

            if (clave.equals(clave1)) {
                guardar(correo, clave, checkBoxRememberMe.isChecked());
                if (admin) {
                    startActivity(new Intent(Login.this, Admin.class));
                    Toast.makeText(this, "Aprobado", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    Toast.makeText(this, "Aprobado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        });
    }
}
