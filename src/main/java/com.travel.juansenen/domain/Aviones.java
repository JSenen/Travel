package com.travel.juansenen.domain;
import java.security.SecureRandom;

public class Aviones {
    private int idavion;
    private int idruta;
    private String modelo;
    private String numvuelo;
    private String origen;
    private String destino;

    public Aviones(){}

    public Aviones(String modelo, String numvuelo, String origen, String destino) {
        this.modelo = modelo;
        this.numvuelo = numvuelo;
        this.origen = origen;
        this.destino = destino;
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
}
