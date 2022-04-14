<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
 <%@ page import="com.travel.juansenen.dao.BaseDatos" %>
 <%@ page import="com.travel.juansenen.dao.RutasDao" %>
 <%@ page import="com.travel.juansenen.domain.Rutas" %>
  <%@ page import="com.travel.juansenen.dao.OrigenDao" %>
  <%@ page import="com.travel.juansenen.domain.Origen" %>
   <%@ page import="com.travel.juansenen.dao.DestinoDao" %>
   <%@ page import="com.travel.juansenen.domain.Destino" %>

 <%@ page import="java.util.*" %>
 <%@ page import="java.sql.SQLException" %>

<!doctype html>
 <html lang="en">
  <jsp:include page="header.jsp" />
 <body>
 <%
            BaseDatos baseDatos = new BaseDatos();
            RutasDao rutasdao = new RutasDao(baseDatos.getConectionDao());
            OrigenDao origendao = new OrigenDao(baseDatos.getConectionDao());
            DestinoDao destinodao = new DestinoDao(baseDatos.getConectionDao());
            List<Origen> origenes = origendao.listorigen();
            List<Destino> destinos = destinodao.listdestino();
            List<Rutas> rutas = rutasdao.listrutas();
 %>
            <div class="d-flex p-2 mt-5 bd-highlight justify-content-center">
            <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                    <th scope="col">Id Ruta</th>
                    <th scope="col">Precio</th>
                   </tr>
                    </thead>
                    <tbody>
                    <%-- Listamos los datos --%>
<%
            for (Rutas ruta: rutas) {
            out.println("<tr>");
            out.println("<th><td>"+ruta.getIdruta()+"</th><td>"+ruta.getPrecio()+"</th>");
            out.println("<tr>");
            }
%>
                </tbody>
               </table>
<table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                    <th scope="col">Origen</th>
                   </tr>
                    </thead>
                    <tbody>
                    <%-- Listamos los datos --%>
<%
            for (Origen origen: origenes) {
            out.println("<tr>");
            out.println("<th><td>"+origen.getOrigen()+"</th>");
            out.println("<tr>");
            }
%>
                </tbody>
               </table>
<table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                    <th scope="col">Destino</th>
                   </tr>
                    </thead>
                    <tbody>
                    <%-- Listamos los datos --%>
<%
            for (Destino destino: destinos) {
            out.println("<tr>");
            out.println("<th><td>"+destino.getDestino()+"</th>");
            out.println("<tr>");
            }
%>
                </tbody>
               </table>
               </div>

             <a class="btn btn-primary" href="menu.jsp" role="button">Menu inicio</a>
            </body>
            </html>

