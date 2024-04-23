package com.example.intentovacio.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


class bdd  extends SQLiteOpenHelper{

    private Context context ;
    private static final  String DATABESE_NAME ="Basedd_ul.db";
    private static final  int DATABESE_version =1;

    private static final  String Nombre_tabla ="Usuario";
    private static final  String  COLUMNA_ID ="Id_usuario";
    private static final  String  COLUMNA_CORREO ="Correo";

    private static final  String  COLUMNA_CLAVE ="clave";
    private static final  String  COLUMNA_NUMERO ="numero";

    private static final String  Nombre_tabla_s ="stock";
    private static final String  Columna_Id_s ="Id_stock";

    private static final  String  COLUMNA_NOMBRE ="Nobj";






    public bdd(@Nullable Context context) {
        super(context, DATABESE_NAME, null,DATABESE_version );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Nombre_tabla +
                "(" + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_CORREO + " TEXT, " +
                COLUMNA_NUMERO + " INT, " +
                COLUMNA_CLAVE + " TEXT)";
        db.execSQL(query);

        String stock = "CREATE TABLE " + Nombre_tabla_s +
                "(" +  Columna_Id_s + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_NOMBRE  + " TEXT)";
        db.execSQL(stock);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Nombre_tabla);
        onCreate(db);
    }
    void añadir_usuario (String correo , String clave ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMNA_CORREO, correo);
        cv.put(COLUMNA_CLAVE, clave);
        long result = db.insert(Nombre_tabla,null,cv);
        if (result == -1){
            Toast.makeText(context, "fallo :(", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "insert realizado", Toast.LENGTH_SHORT).show();
        }

    }
    void añadir_Stock (String obj ){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();

        cv2.put(COLUMNA_NOMBRE, obj);
        long result = db2.insert(Nombre_tabla_s,null,cv2);
        if (result == -1){
            Toast.makeText(context, "fallo :(", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "insert realizado", Toast.LENGTH_SHORT).show();
        }

    }
}