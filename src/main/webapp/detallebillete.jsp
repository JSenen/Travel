<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.travel.juansenen.domain.Usuarios" %>
     <%@ page import="com.travel.juansenen.dao.BaseDatos" %>
     <%@ page import="com.travel.juansenen.dao.RutasDao" %>
     <%@ page import="com.travel.juansenen.domain.Rutas" %>
      <%@ page import="com.travel.juansenen.dao.BilletesDao" %>
      <%@ page import="com.travel.juansenen.domain.Billetes" %>
      <%@ page import="java.util.*" %>
      <%@ page import="java.sql.SQLException" %>

<!doctype html>
<html lang="en">
    <jsp:include page="header.jsp" />
<body>

    <%
        String idavion = request.getParameter("idavion");
        String nombre = request.getParameter("nombre");
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        String numvuelo = request.getParameter("numvuelo");
        String idusuario = request.getParameter("idusuario");
        String modeloavion = "./img/737.jpg";
        if(idavion.equals("2")){
            modeloavion = "./img/737max.jpg";}
           else if(idavion.equals("3")){
           modeloavion = "./img/747.jpg";}
           else if(idavion.equals("4")){
                      modeloavion = "./img/airbus320.jpg";}
                      else if(idavion.equals("5")){
                                            modeloavion = "./img/airbus380.jpg";}
    %>

       <div class="d-flex p-2 mt-5 bd-highlight">


            <div class="card mb-3" style="max-width: 640px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                         <img src="<%= modeloavion %>" >
                    </div>
                         <div class="col-md-8 p-5">
                             <div class="card-body">
                                <h5 class="card-title">BILLETE</h5>
        <p class="card-text">Nombre: <strong><%= nombre %></strong></p>
        <p class="card-text">Origen:  <%= origen %></p>
        <p class="card-text">Destino: <%= destino %></p>
        <p class="card-text">Numero de vuelo:  <%= numvuelo %></p>
        <p class="card-text"><small class="text-muted">Datos del billete adquirido</small></p>

      </div>

    </div>
  </div>
</div>
  </div>

<a class="btn btn-primary" href="menu.jsp" role="button">Menu inicio</a>
