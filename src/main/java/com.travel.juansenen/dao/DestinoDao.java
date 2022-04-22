package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Destino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.travel.juansenen.util.Constantes.*;

public class DestinoDao {
    private Connection conexion;

    public DestinoDao(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo añadir destinos
    public void addDestino(Destino destino) {
        //Creamos sentencia SQL
        String sql = "INSERT INTO DESTINOS (iddestino,destino) VALUES (AUTO_IDDESTINO.nextval, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try {
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, destino.getDestino());
            instruccion.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
    public ArrayList<Destino> listdestino(){
        String sql = "SELECT * FROM DESTINOS ORDER BY destino";
        ArrayList<Destino> destinos = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Destino destino = new Destino();
                destino.setIddestino(resultSet.getInt("iddestino"));
                destino.setDestino(resultSet.getString("destino"));

                destinos.add(destino);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return destinos;
    }
    //Metodo de resultados
    private Destino fromResultSet(ResultSet resultSet) throws SQLException {
        Destino destino = new Destino();

        destino.setIddestino(resultSet.getInt("iddestino"));
        destino.setDestino(resultSet.getString("destino"));

        //Devuelve los resultados del usuario
        return destino;

    }

}
