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
        int idruta = Integer.parseInt(request.getParameter("idruta"));

        //Recuperamos datos usuario
        Usuarios currentUser = (Usuarios) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("accesonopermitido.jsp"); //TODO Crear metodo login error
        }

        //Conectamos a base de datos
        BaseDatos baseDatos = new BaseDatos();
        PedidoDao pedidoDao = new PedidoDao(baseDatos.getConectionDao());

        //Creamos nuevo billete
        Pedido pedido = new Pedido(idruta, currentUser.getIdusuario());
        pedidoDao.addPedido(pedido);
    }
}
