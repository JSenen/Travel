package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Rutas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutasDao {
    private Connection conexion;

    public RutasDao(Connection conexion) {
        this.conexion = conexion;
    }

    public ArrayList<Rutas> listarRutas(){
        String sql = "SELECT * FROM RUTAS ORDER BY origen";
        ArrayList<Rutas> ruta = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Rutas rutas = new Rutas();
                rutas.setIdruta(resultSet.getInt("idruta"));
                rutas.setIdorigen(resultSet.getInt("idorigen"));
                rutas.setIddestno(resultSet.getInt("iddestino"));
                rutas.setPrecio(resultSet.getFloat("precio"));

                ruta.add(rutas);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return ruta;
    }
}
