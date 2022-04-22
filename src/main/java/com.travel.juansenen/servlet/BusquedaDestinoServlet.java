package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.BilletesDao;
import com.travel.juansenen.domain.Billetes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/busqueda")
public class BusquedaDestinoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String texto = request.getParameter("texto");

        BaseDatos baseDatos = new BaseDatos();
        BilletesDao billetesDao = new BilletesDao(baseDatos.getConectionDao());
        try {
            ArrayList<Billetes> billetes = billetesDao.buscar(texto);
            StringBuilder result = new StringBuilder("<ul class='list-group'>");
            for (Billetes billete : billetes) {
                result.append("<li class='list-group-item'>").append("-- ORIGEN -->").append(billete.getOrigen()).append("<strong style=\"color:#FF0000\">-- DESTINO --></strong>").append(billete.getDestino()).append("--PRECIO ->").append(billete.getPrecio()).append("€ --AVION ->").append(billete.getModelo()).append("<a href=\"billetes.jsp\">Seleccionar</a></li>");
            }
            result.append("</ul>");
            out.println(result);
        } catch (SQLException sqle) {
            out.println("<div class='alert alert-danger' role='alert'>Se ha producido un error durante la búsqueda</div>");
            sqle.printStackTrace();
        }
    }


    }

