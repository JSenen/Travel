package com.travel.juansenen.domain;

public class Rutas {
    private int idruta;
    private float precio;
    private int iddestino;
    private int idorigen;

    public Rutas(){}

    public Rutas(float precio, int iddestino, int idorigen) {
        this.precio = precio;
        this.iddestino = iddestino;
        this.idorigen = idorigen;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIddestno() {
        return iddestino;
    }

    public void setIddestno(int iddestno) {
        this.iddestino = iddestno;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }
}
