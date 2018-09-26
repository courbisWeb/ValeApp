package com.example.courbis_diaz.valeapp.Entidad;

public class material {

    private int id;
    private String material;
    private int marca;
    private int proveedor;

    public material(int id, String material, int marca, int proveedor) {
        this.id = id;
        this.material = material;
        this.marca = marca;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
}
