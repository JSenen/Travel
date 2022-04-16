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
            <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                    <th scope="col">Id Usaurio</th>
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
            out.println("<th><td>"+usuario.getNombre()+"</th><td>"+usuario.getApellidos()+"</th><td><a class=btn-warning href=delusuario?idusuario="+usuario.getIdusuario()+">Eliminar</a></th>");
            out.println("<tr>");
            }
%>
                    </tbody>
               </table>
             <a class="btn btn-primary" href="menu.jsp" role="button">Menu inicio</a>
             <a class="btn btn-primary" href="registrarse.jsp" role="button">Añadir nuevo</a>
            </body>
            </html>

