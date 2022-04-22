package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.UsuariosDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/delusuario")
public class DelUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Recogemos el parametro idusuario que nos han pasado en el jsp al seleccionar eliminar
        int idusuario = Integer.parseInt(request.getParameter("idusuario"));

        //Conexion
        BaseDatos baseDatos = new BaseDatos();
        UsuariosDao usuariosDao = new UsuariosDao(baseDatos.getConectionDao());

        try {
            //Llamada al metodo para borrar el cliente
            boolean deleted = usuariosDao.deleteUser(idusuario);
            if (deleted){
                out.println("<h2>USUARIO ELIMINADO CON EXITO<h2>");
                out.println("<a class=\"btn btn-primary\" href=\"menu.jsp\" role=\"button\">Menu inicio</a>");
            }else{
                out.println("<h2>USUARIO NO EXISTE EN LA BASE<h2>");
                out.println("<a class=\"btn btn-primary\" href=\"menu.jsp\" role=\"button\">Menu inicio</a>");}
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        //Cerramos base de datos
        baseDatos.closeConexion();

    }
}
