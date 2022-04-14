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
 <script type="text/javascript"> //!--Script de Ajax para asincronia de formulario con servidor-- >
       $(document).ready(function () {
         $("form").on("submit", function (event) {
           event.preventDefault();
           var formValue = $(this).serialize();
           $.post("addruta", formValue, function (data) {
             $("#result").html(data);
           });
         });
       });
   </script>

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
                    <select class="form-control" name="origen">
                    <%-- Listamos los datos ORIGENES --%>
                    <%
                    for (Origen origen: origenes) {
                            out.println("<option>"+origen.getOrigen()+"<option>");
                    }
                     %>

                    </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Destino</label>
                    <select class="form-control"  name="destino">
                    <%-- Listamos los datos DESTINOS --%>
                    <%
                    for (Destino destino: destinos) {
                            out.println("<option>"+destino.getDestino()+"<option>");

                    }
                     %>
                    </select>
            </div>
            <div class="form-group row">
                    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Precio</label>
                    <div class="col-sm-10">
                      <input type="number" class="form-control form-control-sm" step="any" id="tarjeta" name="precio"
                        placeholder="Precio">
                    </div>
            </div>
            <div class="form-group">
                            <label for="exampleFormControlSelect1">Modelo Avion</label>
                                <select class="form-control" name="modelo">
                                <option value="Boeing737">Boeing 737<option>
                                <option value="Boeing737MAX">Boeing 737MAX<option>
                                <option value="Boeing747">Boeing 747<option>
                                <option value="AirbusA320">Airbus A320<option>
                                <option value="AirbusA380">Airbus A380<option>
                                </select>
            </div>



            <div class="form-group row">
                    <button type="submit" class="btn btn-primary">Nueva Ruta</button>
            </div>
            <div class="d-flex p-2 bd-highlight justify-content-center">
                    <div class="col-sm-2" id="result"></div> <!-- Muestra el resultado --> </div>
                </div>
            </form>
