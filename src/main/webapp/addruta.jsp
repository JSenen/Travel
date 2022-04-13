<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
 <%@ page import="com.travel.juansenen.dao.BaseDatos" %>
 <%@ page import="com.travel.juansenen.dao.OrigenDao" %>
 <%@ page import="com.travel.juansenen.dao.DestinoDao" %>
 <%@ page import="com.travel.juansenen.domain.Destino" %>
 <%@ page import="com.travel.juansenen.domain.Origen" %>
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
           $.post("newruta", formValue, function (data) {
             $("#result").html(data);
           });
         });
       });
   </script>

 <%
            BaseDatos baseDatos = new BaseDatos();
            OrigenDao origendao = new OrigenDao(baseDatos.getConectionDao());
            DestinoDao destinodao = new DestinoDao(baseDatos.getConectionDao());
            List<Destino> destinos = destinodao.listdestino();
            List<Origen> origenes = origendao.listorigen();
 %>
           <form action="newruta" method="post">
                <div class="d-flex p-2 mt-5 bd-highlight flex-column justify-content-center">
                        <select class="form-select" width="20" multiple aria-label="multiple select example">
                        <option selected>Origen...</option>

                                 <%-- Listamos los datos --%>
            <%
            for (Origen origen: origenes) {
                    out.println("<option  name=idorigen value=origen.getIdorigen()>"+origen.getOrigen()+"</option>");

            }
            %>
                         </select>

                       <select class="form-select" width="12" multiple aria-label="multiple select example">
                       <option selected>Destino...</option>


            <%
              for (Destino destino: destinos) {
                          out.println("<option name=iddestino value=destino.getIddestino()>"+destino.getDestino()+"</option>");

                                    }
            %>
                        </select>

            </div>

            <div class="input-group mb-1 p-2">
                     <span class="input-group-text">€</span>
                     <input type="text" class="form-control" name="precio" aria-label="">
            </div>
            <div class="input-group mb-1 p-2">
                     <span class="input-group-text">NUMERO DE VUELO</span>
                     <input type="text" class="form-control" name="numvuelo "aria-label="">
            </div>
            <div class="input-group mb-1 p-2">
                      <span class="input-group-text">MODELO</span>
                      <input type="text" class="form-control" name="modelo "aria-label="">
            </div>
             <div class="form-group row">
                      <button type="submit" class="btn btn-primary">Grabar Ruta</button>
             </div>
            </form>
            <!-- MOSTRAMOS RSULTADO -->
             <div class="d-flex p-2 bd-highlight justify-content-center">
                    <div class="col-sm-2" id="result"></div> <!-- Muestra el resultado --> </div>
             </div>

            </body>
            </html>