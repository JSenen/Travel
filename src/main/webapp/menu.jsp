<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.travel.juansenen.domain.Usuarios" %>

<%
    Usuarios usuarios = (Usuarios) session.getAttribute("currentuser");
    if (usuarios == null) {
        response.sendRedirect("index.jsp");
    }
%>

<!doctype html>
 <html lang="en">
  <jsp:include page="header.jsp" />

 <body>

     <div class="d-flex p-2 mt-5 bd-highlight flex-row justify-content-center">
             <div>
                <img src="img/logo.jpg" width="200" height="200">
             </div>
             <div>
                <div class="form-outline mb-4">
                    <a class="btn btn-primary" href="billetes.jsp?idusuario=<%= usuarios.getIdusuario() %>" role="button">Compra Billetes</a>
                    <a class="btn btn-primary" href="misbilletes.jsp?idusuario=<%= usuarios.getIdusuario() %>" role="button">Mis Billetes</a>
                    <a class="btn btn-warning" href="modificar.jsp?idusuario=<%= usuarios.getIdusuario() %>" role="button">Editar Perfil</a>
                    <a class="btn btn-danger" href="index.jsp" role "button">Cerrar sesión</a>
                </div>
                 <%
                   if ((usuarios != null) && (usuarios.getRol().equals("administrador"))) {
                   %>
                <div class="form-outline mb-4">
                    <a class="btn btn-warning" href="listusuarios.jsp" role="button">Listado Clientes</a>
                    <a class="btn btn-warning" href="billetes.jsp" role="button">Listado Rutas</a>
                    <a class="btn btn-warning" href="newruta.jsp" role="button">Crear Ruta</a>


                </div>
                <%
                }
                %>
            </div>
    </div>
  </body>
