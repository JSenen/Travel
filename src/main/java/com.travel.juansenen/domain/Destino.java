package com.travel.juansenen.domain;

public class Destino {
    private int iddestino;
    private String destino;

    public Destino(){}

    public Destino(String destino) {
        this.destino = destino;
    }

    public int getIddestino() {
        return iddestino;
    }

    public void setIddestino(int iddestino) {
        this.iddestino = iddestino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

}

