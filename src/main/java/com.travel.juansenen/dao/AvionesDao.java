package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Aviones;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.travel.juansenen.util.Constantes.NOBD;

public class AvionesDao {
    private Connection conexion;

    public AvionesDao(Connection conexion) {
        this.conexion = conexion;
    }

    //Método para añadir aviones
    public void addAvion(Aviones aviones){
        //Creamos sentencia SQL
        String sql = "INSERT INTO aviones (idavion, idruta, modelo, numvuelo) VALUES (AUTO_IDAVION.nextval, ( SELECT idruta FROM RUTAS INNER JOIN ORIGENES ON origenes.idorigen = rutas.idorigen INNER JOIN DESTINOS ON destinos.iddestino = rutas.iddestino WHERE origen = ? AND destino = ?), ?, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try{
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1,aviones.getOrigen());
            instruccion.setString(2,aviones.getDestino());
            instruccion.setString(3, aviones.getModelo());
            instruccion.setString(4, aviones.getNumvuelo());
            instruccion.executeUpdate();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
}
