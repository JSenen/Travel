package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Aviones;
import com.travel.juansenen.domain.Usuarios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

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
    //Metodo para encontrar Id de un cliente
    public Optional<Aviones> findAvion(int idavion){
        //Añadimos sentencia SQL para busqueda en BD
        String sql = "SELECT * FROM aviones WHERE idruta = ?";
        Aviones aviones = null;

        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,idavion);
            ResultSet resultSet = sentencia.executeQuery();
            //Ejecutamos la consulta a la tabla
            if (resultSet.next()) {
                aviones = new Aviones();
                aviones.setIdavion(resultSet.getInt("idavion"));
                aviones.setIdruta(resultSet.getInt("idruta"));
            }

        }catch (SQLException sqe){
            sqe.printStackTrace();
        }
        // Devuelve el resultado si se ha encontrado y si no null
        return Optional.ofNullable(aviones);
    }
}
