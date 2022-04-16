package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.AvionesDao;
import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.RutasDao;
import com.travel.juansenen.domain.Aviones;
import com.travel.juansenen.domain.Rutas;
import com.travel.juansenen.util.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/addruta")
public class AddRutaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Recuperamos los parametros
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        float precio = Float.parseFloat(request.getParameter("precio"));
        String modelo = request.getParameter("modelo");
        String numvuelo = Constantes.generateRandomString(12);


        //Conectamos a bases datos necesarias
        BaseDatos baseDatos = new BaseDatos();
        RutasDao rutasDao = new RutasDao(baseDatos.getConectionDao());
        AvionesDao avionesDao = new AvionesDao(baseDatos.getConectionDao());



        //Creamos el objeto Ruta
        Rutas rutas = new Rutas(precio, origen, destino);
        rutasDao.addruta(rutas);



        //Creamos el objeto Aviones
        Aviones aviones = new Aviones( modelo, numvuelo, origen, destino);
        avionesDao.addAvion(aviones);

        //Cerramos conexion
        baseDatos.closeConexion();

        //Devolvemos mesaje de grabación al result del jsp
        out.println("<div class='alert alert-success' role='alert'>NUEVA RUTA AGREGADA</div>");
        out.println("<a class=\"btn btn-primary\" href=\"menu.jsp\" role=\"button\">Menu inicio</a>");



















        ;




    }
}
