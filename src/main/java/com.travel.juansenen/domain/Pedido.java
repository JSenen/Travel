package com.travel.juansenen.domain;

public class Pedido {
    private int idbillete;
    private int idusuario;

    public Pedido() {
    }

    public Pedido(int idbillete, int idusuario) {
        this.idbillete = idbillete;
        this.idusuario = idusuario;
    }
    public Pedido(int idusuario){
        this.idusuario = idusuario;
    }

    public int getIdbillete() {
        return idbillete;
    }

    public void setIdbillete(int idbillete) {
        this.idbillete = idbillete;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
