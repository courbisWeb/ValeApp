package com.example.courbis_diaz.valeapp.Entidad;

public class tipoVale {

    private int id;
    private String vale;

    public tipoVale(int id, String vale) {
        this.id = id;
        this.vale = vale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }
}
