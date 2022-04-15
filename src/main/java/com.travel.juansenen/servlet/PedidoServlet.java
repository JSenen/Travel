package com.travel.juansenen.servlet;

import com.travel.juansenen.domain.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("txt/html");
        PrintWriter out = response.getWriter();

        Usuarios currentUser = (Usuarios) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("accesonopermitido.jsp"); //TODO Crear jsp acceso no permitido
        }

        //Recuperamos los datos del billete seleccionado
        String idruta = request.getParameter("idruta");
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        String modelo = request.getParameter("modelo");
        String numvuelo = request.getParameter("numvuelo");



    }
}
