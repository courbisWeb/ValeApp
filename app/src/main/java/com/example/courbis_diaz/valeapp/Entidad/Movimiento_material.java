package com.example.courbis_diaz.valeapp.Entidad;

public class Movimiento_material {

    private int id;
    private String fecha;
    private int material;
    private int cantidad;
    private int responsable;
    private int obra;

    public Movimiento_material(int id, String fecha, int material, int cantidad, int responsable, int obra) {
        this.id = id;
        this.fecha = fecha;
        this.material = material;
        this.cantidad = cantidad;
        this.responsable = responsable;
        this.obra = obra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public int getObra() {
        return obra;
    }

    public void setObra(int obra) {
        this.obra = obra;
    }
}
