#Travel WebApp

Aplicación web diseñada para la Actividad de Aprendizaje de la 2ª Evaluación de la asignatura Programacion.
Ciclo DAM - San Valero -

Se ha diseñado una aplicación simple para el tratamiento y manejo de una base de datos (Oracle) desde una 
aplicación web programada en Java.

La aplicación simula una agencia de viajes que ofrece la posibilidad de la compra de billetes online.

Se a utilizado el sistema DAO para el acceso a Datos. Junto con JDBC
La página se ha creado por medio de JSP y Servlets.

Se adjunta la base de datos creada para tal fin (Travelweb).

- Se ha creado una tabla usuarios con un admiinistrador Nombre: admin Password: admin
- Tambien se dispone de clientes de prueba Nombre: prueba Password: 0000
- Se ha creado una parametrizacion inicial de la base de datos para poder probar la app.

La aplicación dispone de menus disponibles dependiendo de si el acceso lo realiza un "administrador" o
un "usuario normal"
Tambien se dispone de la posibilidad de añadir rutas o clientes.
El acceso por usuario permite el listadp de rutas disponibles, comprar billetes o ver los billetes ya comprados.
El acceso por administrador, permite ademas, crear rutas nuevas y modificar o eliminar usuarios.

Tambien se dispone de un buscador de rutas por destino, asi como un buscador en cada listado.

Los listados estan todos paginados y disponen de la posibilidad de buscar u ordenar.

