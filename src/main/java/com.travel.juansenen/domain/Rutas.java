package com.travel.juansenen.domain;

public class Rutas {
    private int idruta;
    private float precio;
    private int iddestino;
    private int idorigen;
    private String origen;
    private String destino;
    private String numvuelo;
    private String modelo;

    public Rutas(){}

    public Rutas(float precio, int iddestino, int idorigen) {
        this.precio = precio;
        this.iddestino = iddestino;
        this.idorigen = idorigen;
    }
    public Rutas(float precio, String origen, String destino){
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public int getIddestino() {
        return iddestino;
    }

    public void setIddestino(int iddestino) {
        this.iddestino = iddestino;
    }

    public String getNumvuelo() {
        return numvuelo;
    }

    public void setNumvuelo(String numvuelo) {
        this.numvuelo = numvuelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
