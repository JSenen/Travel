package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Origen;
import com.travel.juansenen.domain.Rutas;


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
    //Método listar todos los registros de la base
    public ArrayList<Rutas> listrutas(){
        String sql = "SELECT * FROM rutas ORDER BY idruta";
        ArrayList<Rutas> rutas = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Rutas ruta = new Rutas();
                ruta.setIdruta(resultSet.getInt("idruta"));
                ruta.setIdorigen(resultSet.getInt("idorigen"));
                ruta.setIddestno(resultSet.getInt("iddestino"));
                ruta.setPrecio(resultSet.getFloat("precio"));
                rutas.add(ruta);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return rutas;
    }


}
