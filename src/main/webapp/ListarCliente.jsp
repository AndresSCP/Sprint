<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="extras/Navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Style.css">
    </head>
    <body id="bodylistado">
       
<!--creando una tabla para mostrar un listado de clientes, donde cada fila representará un cliente y cada columna de la tabla mostrará información  del cliente. -->
<h1>Listado de Clientes</h1>
<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th>Username</th>
                <th>Fecha Nacimiento</th>
                <th>Tipo Usuario</th>
                <th>Run</th>
                <th>Nombre Cliente</th>
                <th>Apellido Cliente</th>
                <th>Telefono</th>
                <th>AFP</th>
                <th>Sistema Salud</th>
                <th>Dirección</th>
                <th>Comuna</th>
                <th>Edad</th>
                <th>Modificar</th>
                <th>Eliminar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${miListaCliente}">
                <tr>
                    <td>${cliente.nombreUsuario}</td>
                    <td>${cliente.fechaNacimientoUsuario}</td>
                    <td>${cliente.tipoUsuario}</td>
                    <td id="runUsuarioC">${cliente.runUsuario}</td>
                    <td>${cliente.nombres}</td>
                    <td>${cliente.apellidos}</td>
                    <td>${cliente.telefono}</td>
                    <td>${cliente.afp}</td>
                    <td>${cliente.sistemaSalud}</td>
                    <td>${cliente.direccion}</td>
                    <td>${cliente.comuna}</td>
                    <td>${cliente.edad}</td>
                    <td>
                        <form action="ModificarClienteServlet" method="GET">
                            <input type="hidden" name="clienteId" value="${cliente.id}">
                            <button type="submit">Modificar</button>
                        </form>
                    </td>
                    <td>
                        <form action="EliminarClienteServlet" method="POST">
                            <input type="hidden" name="clienteId" value="${cliente.id}">
                            <button type="submit">Eliminar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


     <script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" 	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
       
    </body>
    <!-- Footer con la etiqueta include   -->
	<footer><%@include file="extras/footer.jsp"%></footer>	

    
</html>