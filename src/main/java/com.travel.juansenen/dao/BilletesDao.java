package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Billetes;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BilletesDao {
    private Connection conexion;

    public BilletesDao (Connection conexion){
        this.conexion = conexion;
    }

    //Método listar todas las rutas creadas
    public ArrayList<Billetes> listbilletes(){
        String sql = "SELECT * FROM billetesposibles ORDER BY origen";
        ArrayList<Billetes> billetes = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Billetes billete = new Billetes();
                billete.setOrigen(resultSet.getString("origen"));
                billete.setDestino(resultSet.getString("destino"));
                billete.setNumvuelo(resultSet.getString("numvuelo"));
                billete.setPrecio(resultSet.getFloat("precio"));
                billete.setModelo(resultSet.getString("modelo"));
                billetes.add(billete);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return billetes;
    }
}
