package com.example.courbis_diaz.valeapp.Entidad;

public class ListaVale {

    int cantidad;
    String descripcion;
    String bodega;

    public ListaVale(int cantidad, String descripcion, String bodega) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.bodega = bodega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }
}
