package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Origen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import static com.travel.juansenen.util.Constantes.NOBD;

public class OrigenDao {
    private Connection conexion;

    public OrigenDao(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo añadir destinos
    public void addOrigen(Origen origen) {
        //Creamos sentencia SQL
        String sql = "INSERT INTO ORIGENES (idorigen,origen) VALUES (AUTO_IDORIGEN.nextval, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try {
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, origen.getOrigen());;
            instruccion.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
    //Metodo para buscar por origen
    public ArrayList<Origen> findOrigenes(String searchtext) throws SQLException {
        String sql = "SELECT idorigen FROM ORIGENES WHERE origen = ?";
        ArrayList<Origen> origenes = new ArrayList<>();

        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, searchtext);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Origen origen = fromResultSet(resultSet);
            origenes.add(origen);
        }
        return origenes;
    }
    //Metodo de resultados
    private Origen fromResultSet(ResultSet resultSet) throws SQLException {
        Origen origen = new Origen();

        origen.setIdorigen(resultSet.getInt("idorigen"));
        origen.setOrigen(resultSet.getString("origen"));

        //Devuelve los resultados del usuario
        return origen;

    }

    //Método listar todos los registros de la base
    public ArrayList<Origen> listorigen(){
        String sql = "SELECT * FROM origenes ORDER BY origen";
        ArrayList<Origen> origenes = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Origen origen = new Origen();
                origen.setIdorigen(resultSet.getInt("idorigen"));
                origen.setOrigen(resultSet.getString("origen"));
                origenes.add(origen);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return origenes;
    }

}
