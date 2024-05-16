package com.example.intentovacio.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class bdd extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Basedd_ul.db";
    private static final int DATABASE_VERSION = 1;

    private static final String NOMBRE_TABLA_USUARIO = "Usuario";
    private static final String COLUMNA_ID_USUARIO = "Id_usuario";
    private static final String COLUMNA_CORREO = "Correo";
    private static final String COLUMNA_CLAVE = "clave";
    private static final String COLUMNA_NUMERO = "numero";

    private static final String NOMBRE_TABLA_STOCK = "stock";
    private static final String COLUMNA_ID_STOCK = "Id_stock";
    private static final String COLUMNA_NOMBRE = "Nobj";

    private static final String NOMBRE_TABLA_RESERVAS = "reservas";
    private static final String COLUMNA_ID_RESERVA = "Id_reserva";
    private static final String COLUMNA_TITULO_RESERVA = "titulo";
    private static final String COLUMNA_CODIGO_RESERVA = "codigo";

    public bdd(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUsuario = "CREATE TABLE " + NOMBRE_TABLA_USUARIO + " (" +
                COLUMNA_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_CORREO + " TEXT, " +
                COLUMNA_NUMERO + " INT, " +
                COLUMNA_CLAVE + " TEXT)";
        db.execSQL(createTableUsuario);

        String createTableStock = "CREATE TABLE " + NOMBRE_TABLA_STOCK + " (" +
                COLUMNA_ID_STOCK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_NOMBRE + " TEXT)";
        db.execSQL(createTableStock);

        String createTableReservas = "CREATE TABLE " + NOMBRE_TABLA_RESERVAS + " (" +
                COLUMNA_ID_RESERVA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_TITULO_RESERVA + " TEXT, " +
                COLUMNA_CODIGO_RESERVA + " INTEGER)";
        db.execSQL(createTableReservas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_STOCK);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA_RESERVAS);
        onCreate(db);
    }

    public void anadirUsuario(String correo, String clave) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMNA_CORREO, correo);
        cv.put(COLUMNA_CLAVE, clave);
        long result = db.insert(NOMBRE_TABLA_USUARIO, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Fallo :(", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Usuario añadido", Toast.LENGTH_SHORT).show();
        }
    }

    public void anadirReserva(String titulo, int codigo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMNA_TITULO_RESERVA, titulo);
        cv.put(COLUMNA_CODIGO_RESERVA, codigo);
        long result = db.insert(NOMBRE_TABLA_RESERVAS, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Fallo :(", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Reserva realizada", Toast.LENGTH_SHORT).show();
        }
    }
}