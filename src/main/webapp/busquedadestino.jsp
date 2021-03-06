<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
    <jsp:include page="header.jsp" />

<body>
<div class="d-flex p-2 mt-5 bd-highlight flex-column align-items-center justify-content-center">
    <script type="text/javascript">
        $(document).ready(function() {
            $("form").on("submit", function(event) {
                event.preventDefault();
                var formValue = $(this).serialize();
                $.post("busqueda", formValue, function(data) {
                    $("#result").html(data);
                });
            });
        });
    </script>
    <div class="container">
        <h2>Busqueda por Destino</h2>
        <form>
            <div class="mb-2">
                <label for="texto" class="form-label">Cadena de búsqueda</label>
                <input name="texto" type="text" class="form-control w-25" id="texto">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
             <a class="btn btn-primary" href="menu.jsp" role="button">Volver al Menu</a>
        </form>
        <div id="result"></div>
    </div>

</div>
</body>
</html>
