package com.example.courbis_diaz.valeapp.Entidad;

public class Colaborador {

    private int id;
    private String rut;
    private String nombre;
    private int cargo;
    private int empresa;
    private String pass;

    public Colaborador(int id, String rut, String nombre, int cargo, int empresa, String pass) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.pass = pass;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
