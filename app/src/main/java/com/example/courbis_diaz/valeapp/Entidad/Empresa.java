package com.example.courbis_diaz.valeapp.Entidad;

public class Empresa {

    private int id;
    private String rut;
    private String direccion;
    private int comuna;
    private int tipo;
    private String razonSocial;

    public Empresa(int id, String rut, String direccion, int comuna, int tipo, String razonSocial) {
        this.id = id;
        this.rut = rut;
        this.direccion = direccion;
        this.comuna = comuna;
        this.tipo = tipo;
        this.razonSocial = razonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
