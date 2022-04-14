package com.travel.juansenen.domain;
import java.security.SecureRandom;

public class Aviones {
    private int idavion;
    private int idruta;
    private String modelo;
    private String numvuelo;

    public Aviones(){}

    public Aviones(int idruta, String modelo, String numvuelo) {
        this.idruta = idruta;
        this.modelo = modelo;
        this.numvuelo = numvuelo;
    }
    //generador de cadena aleatoria para los numeros de vuelo

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumvuelo() {
        return numvuelo;
    }

    public void setNumvuelo(String numvuelo) {
        this.numvuelo = numvuelo;
    }
}
