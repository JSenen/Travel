<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
 <html lang="en">
  <jsp:include page="header.jsp" />

 <body>

     <div class="d-flex p-5 mt-5 bd-highlight justify-content-center">
     <div><img src="img/logo.jpg" width="200" height="200"></div>
     <form action="login" method="post">
            <div class="form-outline mb-4">
                <label class="form-label" for="nombre">Nombre</label>
                <input type="text" id="nick" name="nombre" class="form-control" />
            </div>

  <!-- Password input -->
            <div class="form-outline mb-4">
                <label class="form-label" name="clave">Password</label>
                <input type="password" id="clave" name="clave" class="form-control" />
            </div>


  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
  <a class="btn btn-primary btn-block mb-4" href="menu.jsp" role="button">Registrarse</a>
  </form>
  </div>
  </body>


