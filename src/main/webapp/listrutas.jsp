<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
 <%@ page import="com.travel.juansenen.dao.BaseDatos" %>
 <%@ page import="com.travel.juansenen.dao.RutasDao" %>
 <%@ page import="com.travel.juansenen.domain.Rutas" %>
 <%@ page import="java.util.*" %>
 <%@ page import="java.sql.SQLException" %>

<!doctype html>
 <html lang="en">
  <jsp:include page="header.jsp" />
 <body>
 <%
            BaseDatos baseDatos = new BaseDatos();
            RutasDao rutasdao = new RutasDao(baseDatos.getConectionDao());
            List<Rutas> rutas = rutasdao.listarRutas();
 %>
            <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                    <th scope="col">Id Ruta</th>
                   <th scope="col">Origen</th>
                    <th scope="col">Destino</th>
                    <th scope="col">Precio</th>

                   </tr>
                    </thead>
                    <tbody>
                    <%-- Listamos los datos --%>
<%
            for (Rutas ruta: rutas) {
            out.println("<tr>");
            out.println("<th><td>"+ruta.getIdruta()+"</th><td>");
            out.println("<tr>");
            }
%>
                    </tbody>
               </table>
             <a class="btn btn-primary" href="menu.jsp" role="button">Menu inicio</a>
            </body>
            </html>

