package com.travel.juansenen.domain;

public class Origen {
    private int idorigen;
    private String origen;

    public Origen(){}

    public Origen(String origen) {
        this.origen = origen;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
