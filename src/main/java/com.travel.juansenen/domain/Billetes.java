package com.travel.juansenen.domain;

public class Billetes {
    private int idbillete;
    private int idavion;
    private int idusuario;
    private String origen;
    private String destino;
    private String numvuelo;
    private String modelo;
    private float precio;
    private int idruta;

    public Billetes(){    }

    public Billetes (int idavion, int idusuario){
        this.idavion = idavion;
        this.idusuario = idusuario;
    }

    public Billetes( String origen, String destino, String numvuelo, String modelo, float precio, int idruta, int idusuario) {
        this.origen = origen;
        this.destino = destino;
        this.numvuelo = numvuelo;
        this.modelo = modelo;
        this.precio = precio;
        this.idruta = idruta;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdbillete() {
        return idbillete;
    }

    public void setIdbillete(int idbillete) {
        this.idbillete = idbillete;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }
}
