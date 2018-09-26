package com.example.courbis_diaz.valeapp.Entidad;

public class Comuna {

    private int id;
    private String comuna;

    public Comuna(int id, String comuna) {
        this.id = id;
        this.comuna = comuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
}
