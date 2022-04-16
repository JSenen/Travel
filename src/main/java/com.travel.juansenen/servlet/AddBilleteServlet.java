package com.travel.juansenen.servlet;

import com.travel.juansenen.dao.BaseDatos;
import com.travel.juansenen.dao.BilletesDao;
import com.travel.juansenen.dao.PedidoDao;
import com.travel.juansenen.domain.Billetes;
import com.travel.juansenen.domain.Pedido;
import com.travel.juansenen.domain.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addbillete")
public class AddBilleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("txt/html");
        PrintWriter out = response.getWriter();

        //Recuperamos datos del JSP

        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        int idavion = Integer.parseInt(request.getParameter("idavion"));


        //Conectamos a base de datos
        BaseDatos baseDatos = new BaseDatos();
        BilletesDao billetesDao = new BilletesDao(baseDatos.getConectionDao());

        //Creamos nuevo billete
        Billetes billete = new Billetes(idavion,idusuario);
        billetesDao.addBillete(billete);

        //Cerramos conexion
        baseDatos.closeConexion();

        //Devolvemos mesaje de grabación
        out.println("<div class='alert alert-success' role='alert'>BILLETE COMPRADO</div>");
        out.println("<a class=\"btn btn-primary\" href=\"menu.jsp\" role=\"button\">Menu inicio</a>");

    }
}
