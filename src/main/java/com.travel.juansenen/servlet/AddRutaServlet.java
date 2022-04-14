package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.DestinoDao;
import com.travel.juansenen.dao.OrigenDao;
import com.travel.juansenen.dao.RutasDao;
import com.travel.juansenen.domain.Destino;
import com.travel.juansenen.domain.Origen;
import com.travel.juansenen.domain.Rutas;

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

        //Recuperamos los datos del formulario
        int origen = Integer.parseInt(request.getParameter("idorigen"));
        int destino = Integer.parseInt(request.getParameter("iddestino"));
        Float precio = Float.parseFloat(request.getParameter("precio"));

        //Conectamos a bases de datos
        BaseDatos baseDatos = new BaseDatos();
        RutasDao rutasDao = new RutasDao(baseDatos.getConectionDao());

        //Creamos objetos necesarios
        Rutas rutas = new Rutas(precio, destino, origen);
        rutasDao.addruta(rutas);



        ;




    }
}
