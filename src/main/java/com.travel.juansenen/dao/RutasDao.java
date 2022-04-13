package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Rutas;
import com.travel.juansenen.domain.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.travel.juansenen.util.Constantes.NOBD;

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
    //Método para añadir rutas
    public void addruta(Rutas rutas){
        //Creamos sentencia SQL
        String sql = "INSERT INTO RUTAS (idruta,precio,,idorigen,iddestino) VALUES (AUTO_IDRUTA.nextval, ?, ?, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try{
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setFloat(1, rutas.getPrecio());
            instruccion.setInt(2, rutas.getIdorigen());
            instruccion.setInt(3, rutas.getIddestno());
            instruccion.executeUpdate();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
}
