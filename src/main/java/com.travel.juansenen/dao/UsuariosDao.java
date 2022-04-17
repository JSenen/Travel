package com.travel.juansenen.dao;

import com.travel.juansenen.domain.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import static com.travel.juansenen.util.Constantes.NOBD;

public class UsuariosDao {

    private Connection conexion;

    public UsuariosDao(Connection conexion) {

        this.conexion = conexion;
    }
    //Método para añadir usuarios
    public void addUsuario(Usuarios usuario){
        //Creamos sentencia SQL
        String sql = "INSERT INTO USUARIOS (idusuario,nombre,apellidos,mail,clave,rol, tarjeta) VALUES (AUTO_IDUSUARIO.nextval, ?, ?, ?, ?, ?, ?)";

        // SQL (auto_id.nexval) nos da el numero siguiente automaticamente en la base
        try{
            //Lanzamos la sentencia a la BD
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, usuario.getNombre());
            instruccion.setString(2, usuario.getApellidos());
            instruccion.setString(3, usuario.getMail());
            instruccion.setString(4, usuario.getClave());
            instruccion.setString(5, usuario.getRol());
            instruccion.setString(6, usuario.getTarjeta());
            instruccion.executeUpdate();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println(NOBD);
        }
    }
    //Metodo para encontrar Id de un cliente
    public Optional<Usuarios> findUsuario(int idusuario){
        //Añadimos sentencia SQL para busqueda en BD
        String sql = "SELECT * FROM USUARIOS WHERE idusuario = ?";
        Usuarios usuarios = null;

        try{
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,idusuario);
            ResultSet resultSet = sentencia.executeQuery();
            //Ejecutamos la consulta a la tabla
            if (resultSet.next()) {
                usuarios = new Usuarios();
                usuarios.setIdusuario(resultSet.getInt("idusuario"));
                usuarios.setNombre(resultSet.getString("nombre"));
                usuarios.setApellidos(resultSet.getString("apellidos"));
                usuarios.setMail(resultSet.getString("mail"));
                usuarios.setClave(resultSet.getString("clave"));
                usuarios.setTarjeta(resultSet.getString("tarjeta"));
            }

        }catch (SQLException sqe){
            sqe.printStackTrace();
        }
        // Devuelve el resultado si se ha encontrado y si no null
        return Optional.ofNullable(usuarios);
    }
    //Método para listar todos los usuarios de la base con la cadena de busqueda se le pase
    public ArrayList<Usuarios> encontrarTodos(String cadenadebusqueda) throws SQLException {
        //Sentencia de busqueda por nombre, apellidos o mail
        String sql = "SELECT * FROM usuarios WHERE INSTR(nombre, ?) != 0 OR INSTR(apellidos, ?) != 0 OR INSTR(mail, ?) != 0 ORDER BY idusuario";
        ArrayList<Usuarios> usuarios = new ArrayList<>();

        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, cadenadebusqueda);
        statement.setString(2, cadenadebusqueda);
        statement.setString(3, cadenadebusqueda);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Usuarios usuario = fromResultSet(resultSet);
            //Añade usuario
            usuarios.add(usuario);
        }
        //Devuelve usuarios
        return usuarios;
    }
    //Metodo de resultados
    private Usuarios fromResultSet(ResultSet resultSet) throws SQLException {
        Usuarios usuario = new Usuarios();

        usuario.setIdusuario(resultSet.getInt("idusuario"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellidos(resultSet.getString("apellidos"));
        usuario.setMail(resultSet.getString("mail"));
        //Devuelve los resultados del usuario
        return usuario;
    }
    public ArrayList<Usuarios> listarTodos(){
        String sql = "SELECT * FROM USUARIOS ORDER BY nombre";
        ArrayList<Usuarios> usuario = new ArrayList<>();

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdusuario(resultSet.getInt("idusuario"));
                usuarios.setNombre(resultSet.getString("nombre"));
                usuarios.setApellidos(resultSet.getString("apellidos"));

                usuario.add(usuarios);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }

        return usuario;
    }

    //Metodo que busca el usuario en el Login y devuelve nombre, id y rol de este
    public Optional<Usuarios> login(String nombre, String clave) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE nombre = ? AND clave = ?";
        Usuarios usuarios = null;

        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, clave);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            usuarios = new Usuarios();
            usuarios.setIdusuario(resultSet.getInt("idusuario"));
            usuarios.setNombre(resultSet.getString("nombre"));
            usuarios.setRol(resultSet.getString("rol"));
        }

        return Optional.ofNullable(usuarios);
    }
    //Metodo para eliminar usuario
    public boolean deleteUser(int idusuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE idusuario = ?";

        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, idusuario);
        int rows = statement.executeUpdate();

        return rows == 1;
    }
    public boolean modificar(int idusuario, Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, mail = ? clave = ?, tarjeta =?, rol = ? WHERE idusuario = ?";

        PreparedStatement instruccion = conexion.prepareStatement(sql);
        instruccion.setString(1, usuario.getNombre());
        instruccion.setString(2, usuario.getApellidos());
        instruccion.setString(3, usuario.getMail());
        instruccion.setString(4,usuario.getClave());
        instruccion.setString(5, usuario.getTarjeta());
        instruccion.setString(6, usuario.getRol());
        instruccion.setInt(7,usuario.getIdusuario());

        int rows = instruccion.executeUpdate();
        return rows == 1;
    }


}

