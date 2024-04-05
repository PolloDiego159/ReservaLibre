package com.example.intentovacio.Domain;

import java.io.Serializable;

public class ListDomain implements Serializable {
    private String title;
    private String Stock;
    private String Estado;

    public ListDomain(String title, String stock, String estado) {
        this.title = title;
        Stock = stock;
        Estado = estado;
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


}
