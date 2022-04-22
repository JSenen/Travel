package com.travel.juansenen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.travel.juansenen.util.Constantes.*;

public class BaseDatos {
    private Connection conectionDao;

    // Metodo conexion a la base Oracle
    public Connection getConectionDao(){
        try {
            Class.forName(ORCDRV);
        conectionDao = DriverManager.getConnection(ORCURL, ORCUSER, ORCPASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(NOBD);
        } catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
        return conectionDao;
    }

    // Metodo para cerrar la conexion a la Base de Datos
    public void closeConexion(){
        try {
            conectionDao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(NOBD);
        }
    }
}
