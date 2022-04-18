package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Billetes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.travel.juansenen.util.Constantes.NOBD;

public class BilletesDao {
    private Connection conexion;

    public BilletesDao(Connection conexion) {
        this.conexion = conexion;
    }

    //Método listar todas las rutas creadas
    public ArrayList<Billetes> listbilletes() {
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
                billete.setIdruta(resultSet.getInt("idruta"));
                billete.setIdavion(resultSet.getInt("idavion"));
                billetes.add(billete);
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return billetes;
    }

    public ArrayList<Billetes> billetesuser(String idusuario) {
        String sql = "SELECT * FROM billetesusuario WHERE idusuario=" + idusuario;
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
                billete.setIdruta(resultSet.getInt("idruta"));
                billete.setIdavion(resultSet.getInt("idavion"));
                billete.setIdusuario(resultSet.getInt("idusuario"));

                billetes.add(billete);
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return billetes;
    }

    //Método para añadir billetes comprados
    public void addBillete(Billetes billetes) {
        //Creamos sentencia SQL
        String sql = "INSERT INTO billetes (idbillete, idavion, idusuario) VALUES (AUTO_IDBILLETE.nextval, ?, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try {
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, billetes.getIdavion());
            instruccion.setInt(2, billetes.getIdusuario());
            instruccion.executeUpdate();

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }

    //Método busqueda de ruta por nombre origen
    public ArrayList<Billetes> buscar(String texto) throws SQLException {
        String sql = "SELECT * FROM billetesposibles WHERE INSTR(origen, ?) != 0 OR INSTR(destino, ?) != 0 ORDER BY destino";
        ArrayList<Billetes> billetes = new ArrayList<>();

        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, texto);
        statement.setString(2, texto);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Billetes billete = fromBilletes(resultSet);
            billetes.add(billete);
        }
        return billetes;
    }
    //Metodo de resultados
    private Billetes fromBilletes(ResultSet resultSet) throws SQLException {
        Billetes billete = new Billetes();

        billete.setOrigen(resultSet.getString("origen"));
        billete.setDestino(resultSet.getString("destino"));
        billete.setModelo(resultSet.getString("modelo"));
        billete.setPrecio(resultSet.getFloat("precio"));

        //Devuelve los resultados del origen
        return billete;
    }
}
