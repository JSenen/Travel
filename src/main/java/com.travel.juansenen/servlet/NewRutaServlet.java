package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.RutasDao;
import com.travel.juansenen.domain.Rutas;
import com.travel.juansenen.domain.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newruta")
public class NewRutaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Recuperar datos del formulario
        String idorigen = request.getParameter("idorigen");
        String iddestino = request.getParameter("iddestino");
        String precio = request.getParameter("precio");
        String numvuelo = request.getParameter("numvuelo");
        String modelo = request.getParameter("modelo");


        //Conectamos bases de datos
        BaseDatos baseDatos = new BaseDatos();
        RutasDao rutasDao = new RutasDao(baseDatos.getConectionDao());

        //Creamos el nuevo objeto
        Rutas rutas = new Rutas(Float.parseFloat(precio), Integer.parseInt(idorigen),Integer.parseInt(iddestino));
        rutasDao.addruta(rutas);

        //Devolvemos mesaje de grabación al result del jsp
        out.println("<div class='alert alert-success' role='alert'>NUEVA RUTA"+rutas.getIdruta()+" agregada correctamente</div>");

    }
}
