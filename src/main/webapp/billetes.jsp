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
    Usuarios usuarios = (Usuarios) session.getAttribute("currentuser");
    if (usuarios == null) {
        response.sendRedirect("index.jsp");
    }

%>
<%
            BaseDatos baseDatos = new BaseDatos();
            BilletesDao billetesdao = new BilletesDao(baseDatos.getConectionDao());
            List<Billetes> billetes = billetesdao.listbilletes();
 %>


<div class="container">
            <table class="table table-fluid" id="Tablebilletes">
                         <thead class="thead-dark">
                         <tr>
                            <th scope="col">Id Ruta</th>
                            <th scope="col">Origen</th>
                            <th scope="col">Destino</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Numero de Vuelo</th>
                            <th scope="col">Avion</th>
                            <th scope="col">Seleccionar</th>


                        </tr>
                         </thead>
                         <tbody>
                         <tr>
                         <%-- Listamos los datos --%>
     <%
                 for (Billetes billete: billetes) {
                 out.println("<tr>");
                 out.println("<th>"+billete.getIdruta()+"</th><td>"+billete.getOrigen()+"</td><td>"+billete.getDestino()+"</td><td>"+billete.getPrecio()+"€</td><td>"+billete.getNumvuelo()+"</td><td>"+billete.getModelo()+"</td><td><a href=compras.jsp?idusuario="+usuarios.getIdusuario()+"&nombre="+usuarios.getNombre()+"&origen="+billete.getOrigen()+"&destino="+billete.getDestino()+"&numvuelo="+billete.getNumvuelo()+"&idavion="+billete.getIdavion()+"&modelo="+billete.getModelo()+"> Seleccionar</a></td>");
                 out.println("</tr>");
                 }

     %>

                      </tbody>
                    </table>


                  <a class="btn btn-primary" href="menu.jsp" role="button">Volver al Menu</a>
 </div>

            <!-- Script paginacion -->
                <script>
                          $(document).ready( function () {
                          $('#Tablebilletes').DataTable();
                      } );
                 </script>

 </body>
 </html>
