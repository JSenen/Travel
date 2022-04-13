package com.travel.juansenen.dao;

import java.sql.Connection;

public class AvionesDao {
    private Connection conexion;

    public AvionesDao(Connection conexion) {
        this.conexion = conexion;
    }
}
