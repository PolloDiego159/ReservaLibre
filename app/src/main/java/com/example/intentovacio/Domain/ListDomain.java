package com.example.intentovacio.Domain;

import android.util.EventLogTags;

import java.io.Serializable;


public class ListDomain implements Serializable {
    private String title;
    private String Stock;
    private String Estado;
    private String Descripcion;

    private String PicUrl;
    private String score;
    private String Horario;
    private String Ubicacion;
    private int code;

    public ListDomain(String title, String descripcion, String stock,  String estado, String PicUrl,String score ,String Horario, String Ubicado) {
        this.title = title;
        this.Stock = stock;
        this.Estado = estado;
        this.PicUrl = PicUrl;
        this.Descripcion = descripcion;
        this.Horario = Horario;
        this.Ubicacion = Ubicacion;
        this.score = score;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
