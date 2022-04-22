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
<html lang="en">
    <jsp:include page="header.jsp" />
<body>
 <%
            BaseDatos baseDatos = new BaseDatos();
            UsuariosDao usuariosDao = new UsuariosDao(baseDatos.getConectionDao());
            List<Usuarios> usuarios = usuariosDao.listarTodos();
 %>
<div class="container">
            <table class="table table-fluid" id="listUsuarios">
                    <thead class="thead-dark">
                          <tr>
                              <th scope="col">Nombre</th>
                              <th scope="col">Apellidos</th>
                              <th scope="col">Eliminar</th>
                              <th scope="col">Modificar</th>

                          </tr>
                    </thead>
                    <tbody>

                         <%-- Listamos los datos --%>
<%
            for (Usuarios usuario: usuarios) {
            out.println("<tr>");
            out.println("<th>"+usuario.getNombre()+"</th><td>"+usuario.getApellidos()+"</td><td><a  class=btn-warning href=delusuario?idusuario="+usuario.getIdusuario()+">Eliminar</a></td><td><a class=btn-info href=modificar.jsp?idusuario="+usuario.getIdusuario()+">Modificar</a></td>");
            out.println("</tr>");
            }
%>

                    </tbody>
               </table>
               <a class="btn btn-primary" href="menu.jsp" role="button">Menu inicio</a>
               <a class="btn btn-primary" href="registrarse.jsp" role="button">Añadir nuevo</a>

</div>
                <!-- Script paginacion -->
                <script>
                         $(document).ready( function () {
                         $('#listUsuarios').DataTable();
                     } );
                </script>
</body>
</html>

