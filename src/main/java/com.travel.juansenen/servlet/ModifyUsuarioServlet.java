package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.UsuariosDao;
import com.travel.juansenen.domain.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/modify")
public class ModifyUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Conectamos a base de datos
        BaseDatos baseDatos = new BaseDatos();
        UsuariosDao usuariosDao = new UsuariosDao(baseDatos.getConectionDao());

        //Recuperamos datos del JSP
        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String mail = request.getParameter("mail");
        String clave = request.getParameter("clave");
        String tarjeta = request.getParameter("tarjeta");
        String rol = "usuario";


        //Creamos el objeto
        Usuarios usuario = new Usuarios(nombre, apellidos, mail, clave, tarjeta, rol, idusuario);

        //Usamos el metodo de busqueda por id que modificara los campos introducidos
        try {
            usuariosDao.modificar(idusuario,usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Cerramos conexion base datos
        baseDatos.closeConexion();

        //Devolvemos el mensaje
        out.println("<div class='alert alert-success' role='alert'>MODIFICADO usuario"+usuario.getNombre()+" correctamente</div>");



    }
}
