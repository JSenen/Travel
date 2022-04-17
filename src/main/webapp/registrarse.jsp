<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="es">

 <jsp:include page="header.jsp" />

<body>
  <script type="text/javascript"> //!--Script de Ajax para asincronia de formulario con servidor-- >
      $(document).ready(function () {
        $("form").on("submit", function (event) {
          event.preventDefault();
          var formValue = $(this).serialize();
          $.post("newusuario", formValue, function (data) {
            $("#result").html(data);
          });
        });
      });
  </script>

  <div class="d-flex p-2 bd-highlight justify-content-center">

    <form action="newusuario" method="post">
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Nombre</label>
        <div class="col-sm-5">
          <input type="text" class="form-control form-control-sm" id="nombre" name="nombre" placeholder="Nombre">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Apellidos</label>
        <div class="col-sm-5">
          <input type="text" class="form-control form-control-sm" id="apellidos" name="apellidos"
            placeholder="Apellidos">
        </div>
      </div>
      <div class="form-group row">
        <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Correo electrónico</label>
        <div class="col-sm-5">
          <input type="mail class="form-control form-control-sm" id="mail" name="mail"
            placeholder="Correo eléctronico">
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
            placeholder="Número de tarjeta">
        </div>
      </div>
      <div class="form-group row">
         <button type="button" class="btn btn-success">Nuevo Registro</button>
      </div>
    </form>
  </div>
    <div class="d-flex p-2 bd-highlight justify-content-center">
        <div class="col-sm-2" id="result"></div> <!-- Muestra el resultado --> </div>
    </div>
    <div class="d-flex p-2 bd-highlight justify-content-center">
            <a class="btn btn-primary" href="index.jsp" role="button">Volver a Login</a>
   </div>
</body>

</html>