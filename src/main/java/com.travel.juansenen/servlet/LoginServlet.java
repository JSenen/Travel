package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.UsuariosDao;
import com.travel.juansenen.domain.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("nombre");
        String password = request.getParameter("clave");

        BaseDatos basedatos = new BaseDatos();
        UsuariosDao usuariosDao = new UsuariosDao(basedatos.getConectionDao());
        try {
            Optional<Usuarios> usuarios = usuariosDao.login(username, password);
            if (usuarios.isPresent()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentuser", usuarios.get());

                response.sendRedirect("menu.jsp");
            } else {
                response.sendRedirect("loginerror.jsp"); //TODO Crear accion error login
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        //Cerramos conexion
        basedatos.closeConexion();
    }

}
