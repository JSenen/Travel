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
            OrigenDao origendao = new OrigenDao(baseDatos.getConectionDao());
            DestinoDao destinodao = new DestinoDao(baseDatos.getConectionDao());
            List<Origen> origenes = origendao.listorigen();
            List<Destino> destinos = destinodao.listdestino();
 %>
            <form action="addruta" method="post">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Origen</label>
                    <select class="form-control" id="origenes" name="idorigen">
                    <%-- Listamos los datos ORIGENES --%>
                    <%
                    for (Origen origen: origenes) {
                            out.println("<option data-value=origen.getIdorigen>"+origen.getOrigen()+"<option>");

                    }
                     %>

                    </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Destino</label>
                    <select class="form-control" id="destinos" name="iddestino">
                    <%-- Listamos los datos DESTINOS --%>
                    <%
                    for (Destino destino: destinos) {
                            out.println("<option data-value2=origen.getIddestino>"+destino.getDestino()+"<option>");
                            int iddestino = destino.getIddestino();
                    }
                     %>
                    </select>
            </div>
            <div class="form-group row">
                    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Precio</label>
                    <div class="col-sm-10">
                      <input type="number" class="form-control form-control-sm" id="tarjeta" name="precio"
                        placeholder="Precio">
                    </div>
                  </div>

            <div class="form-group row">
                    <button type="submit" class="btn btn-primary">Nueva Ruta</button>
            </div>
            </form>
