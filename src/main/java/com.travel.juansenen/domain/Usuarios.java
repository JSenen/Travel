package com.travel.juansenen.domain;

public class Usuarios {

    private int idusuario;
    private String nombre;
    private String apellidos;
    private String mail;
    private String clave;
    private String rol;
    private String tarjeta;

    public Usuarios(){}

    public Usuarios(String nombre, String apellidos, String mail, String clave, String tarjeta, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.clave = clave;
        this.rol = rol;
        this.tarjeta = tarjeta;
        this.rol = rol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
}