package com.example.courbis_diaz.valeapp.Entidad;

public class Obra {

    private int id;
    private String obra;
    private int empresa;
    private String direccion;
    private int comuna;

    public Obra(int id, String obra, int empresa, String direccion, int comuna) {
        this.id = id;
        this.obra = obra;
        this.empresa = empresa;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }
}
