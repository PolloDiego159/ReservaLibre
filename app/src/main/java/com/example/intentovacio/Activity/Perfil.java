package com.example.intentovacio.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intentovacio.Helper.ManagmentReservas;
import com.example.intentovacio.R;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class Perfil extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
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