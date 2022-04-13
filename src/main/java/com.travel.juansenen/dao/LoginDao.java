package com.travel.juansenen.dao;

import java.sql.Connection;

public class LoginDao {
    private Connection conexion;

    public LoginDao(Connection conexion) {
        this.conexion = conexion;
    }


}
