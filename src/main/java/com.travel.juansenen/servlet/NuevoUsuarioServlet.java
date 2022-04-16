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

@WebServlet("/newusuario")
public class NuevoUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Conectamos la base de datos y el dao necesario
        BaseDatos baseDatos = new BaseDatos();
        UsuariosDao usuariosDao = new UsuariosDao(baseDatos.getConectionDao());

        //Obtenemos los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String mail = request.getParameter("mail");
        String clave = request.getParameter("clave");
        String tarjeta = request.getParameter("tarjeta");
        String rol = "usuario";

        //Creamos el nuevo objeto
        Usuarios usuario = new Usuarios( nombre, apellidos, mail, clave, tarjeta,  rol);
        usuariosDao.addUsuario(usuario);


        //Devolvemos mensaje de grabación al result del jsp
        out.println("<div class='alert alert-success' role='alert'>NUEVO usuario"+usuario.getNombre()+" agregado correctamente</div>");


    }
}
