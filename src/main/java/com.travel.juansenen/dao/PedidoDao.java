package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Billetes;
import com.travel.juansenen.domain.Pedido;
import com.travel.juansenen.domain.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.travel.juansenen.util.Constantes.NOBD;

public class PedidoDao {
    private Connection conexion;

    public PedidoDao (Connection connection){
        this.conexion = connection;
    }

    //Método para generar billetes
    public void addPedido(Pedido pedido){
        //Creamos sentencia SQL
        String sql = "INSERT INTO PEDIDOS (idbillete, idusuario) VALUES (AUTO_IDBILLETE.nextval, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try{
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, pedido.getIdusuario());

            instruccion.executeUpdate();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
    public ArrayList<Pedido> listarpedidos(){
     return null; //TODO Crear listar compras realizadas
    }

}
