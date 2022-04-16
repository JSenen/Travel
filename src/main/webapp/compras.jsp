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
<script type="text/javascript"> //!--Script de Ajax para asincronia de formulario con servidor-- >
       $(document).ready(function () {
         $("form").on("submit", function (event) {
           event.preventDefault();
           var formValue = $(this).serialize();
           $.post("addbillete", formValue, function (data) {
             $("#result").html(data);
           });
         });
       });
   </script>
    <%
        String idavion = request.getParameter("idavion");
        String nombre = request.getParameter("nombre");
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        String numvuelo = request.getParameter("numvuelo");
        String idusuario = request.getParameter("idusuario");
    %>

       <form action="addbillete" method="post">
            <div class="card mb-3" style="max-width: 540px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                         <img src="..." alt="...">
                    </div>
                         <div class="col-md-8">
                             <div class="card-body">
                                <h5 class="card-title">BILLETE</h5>
        <p class="card-text">Nombre: <strong><%= nombre %></strong></p>
        <p class="card-text">Origen:  <%= origen %></p>
        <p class="card-text">Destino: <%= destino %></p>
        <p class="card-text">Numero de vuelo:  <%= numvuelo %></p>
        <p class="card-text"><small class="text-muted">Datos del billete desea comprar</small></p>
        <input type="" name="idusuario" value="<% out.print(idusuario); %>">
        <input type="" name="idavion" value="<% out.print(idavion); %>">
      </div>
      <div class="form-group row">
             <button type="submit" class="btn btn-primary">Comprar</button>
      </div>
    </div>
  </div>
</div>
<div class="d-flex p-2 bd-highlight justify-content-center">
                    <div class="col-sm-2" id="result"></div> <!-- Muestra el resultado --> </div>
                </div>
            </form>

            </form>
