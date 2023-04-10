<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="extras/Navbar.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Style.css">
</head>
<h1>Listado de Administrativos</h1>
<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th>Run</th>
                <th>Nombre</th>
                <th>Fecha de Nacimiento</th>
                <th>Tipo de Usuario</th>
                <th>Area</th>
                <th>Experiencia Previa</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        <%@ page import="modelo.AdministrativoDaoImpl" 
        obtenerAdministrativos();
        %>
        <% for (listaAdministrativos) { %>
        <tr>
            <td><%= listaAdministrativos.getRun() %></td>
            <td><%= listaAdministrativos.getNombre() %></td>
            <td><%= listaAdministrativos.getFechaNac() %></td>
            <td><%= listaAdministrativos.getTipo() %></td>
            <td><%= listaAdministrativos.getArea() %></td>
            <td><%= listaAdministrativos.getExpPrevia() %></td>
            <td><%= listaAdministrativos.getEmail() %></td>
            <td>
                <form action="ModificarClienteServlet" method="GET">
                    <input type="hidden" name="clienteId" value="<%= listaAdministrativos.getRun() %>">
                    <button type="submit">Modificar</button>
                </form>
                <form action="EliminarClienteServlet" method="POST">
                    <input type="hidden" name="clienteId" value="<%= listaAdministrativos.getRun() %>">
                    <button type="submit">Eliminar</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>


     <script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" 	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
    <script src="js/dnone.js"></script>	   
    </body>
    <!-- Footer con la etiqueta include   -->
<%-- 	<footer><%@include file="extras/footer.jsp"%></footer>	 --%>

    
</html>