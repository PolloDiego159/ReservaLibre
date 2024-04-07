package com.example.intentovacio.Domain;

import java.io.Serializable;


public class ListDomain implements Serializable {
    private String title;
    private String Stock;
    private String Estado;

    private String PicUrl;

    private int code;

    public ListDomain(String title, String stock, String estado, String PicUrl) {
        this.title = title;
        this.Stock = stock;
        this.Estado = estado;
        this.PicUrl = PicUrl;

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

    public void setPicUrl(String picUrll) {
        PicUrl = picUrll;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
