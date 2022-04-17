<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="com.travel.juansenen.dao.BaseDatos" %>
 <%@ page import="com.travel.juansenen.dao.UsuariosDao" %>
 <%@ page import="com.travel.juansenen.domain.Usuarios" %>
 <%@ page import="java.util.*" %>
 <%@ page import="java.sql.SQLException" %>



<!doctype html>
<html lang="es">

 <jsp:include page="header.jsp" />

<body>
  <script type="text/javascript"> //!--Script de Ajax para asincronia de formulario con servidor-- >
      $(document).ready(function () {
        $("form").on("submit", function (event) {
          event.preventDefault();
          var formValue = $(this).serialize();
          $.post("modify", formValue, function (data) {
            $("#result").html(data);
          });
        });
      });
  </script>
  <% String nombre = request.getParameter("nombre");
     String apellidos = request.getParameter("apellidos");
     String mail = request.getParameter("mail");
     String tarjeta = request.getParameter("tarjeta");
     String idusario = request.getParameter("idusuario");

     %>

  <div class="d-flex p-2 bd-highlight justify-content-center">

    <form action="modify" method="post">
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Nombre</label>
        <div class="col-sm-5">
          <input type="text" class="form-control form-control-sm" id="nombre" name="nombre" value="<% out.println(nombre); %>">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Apellidos</label>
        <div class="col-sm-5">
          <input type="text" class="form-control form-control-sm" id="apellidos" name="apellidos"
            value="<% out.println(apellidos); %>">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Correo electrónico</label>
        <div class="col-sm-5">
          <input type="mail" class="form-control form-control-sm" id="mail" name="mail" value="<% out.println(mail); %>" >
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Clave</label>
        <div class="col-sm-5">
          <input type="password" class="form-control form-control-sm" id="clave" name="clave" placeholder="Password">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Número Tarjeta</label>
        <div class="col-sm-10">
          <input type="text" class="form-control form-control-sm" id="tarjeta" name="tarjeta"
            value="<% out.println(tarjeta); %>">
        </div>
      </div>
      <div class="form-group row">
         <input type="hidden" class="form-control form-control-sm" id="tarjeta" name="idusuario"
                     value="idusuario">
         <button type="submit" class="btn btn-primary">Modificar</button>
      </div>
    </form>
  </div>
    <div class="d-flex p-2 bd-highlight justify-content-center">
        <div class="col-sm-2" id="result"></div> <!-- Muestra el resultado --> </div>
    </div>
    <div class="d-flex p-2 bd-highlight justify-content-center">
            <a class="btn btn-primary" href="menu.jsp" role="button">Menu Inicio</a>
   </div>
</body>

</html>