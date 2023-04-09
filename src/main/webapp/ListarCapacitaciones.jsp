<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="css/Style.css">

<title>Lista Capacitaciones</title>
</head>
<body id="bodylistado">
	<%@include file="extras/Navbar.jsp"%>
	<h1>Listado de Capacitaciones</h1>

 <!-- importar las clases ArrayList y List del paquete java.util-->
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>



	<%-- <% if (listaCapacitaciones != null && !listaCapacitaciones.isEmpty()) { %> --%>
	 <!-- Tabla listar capacitaciones con etiqueta c:forEach permite ejecutar un bucle en una página JSP-->
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Capacitación</th>
					<th>Nombre</th>
					<th>RUT</th>
					<th>Día</th>
					<th>Hora</th>
					<th>Lugar</th>
					<th>Duración</th>
					<th>Cantidad de Asistentes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="capacitacion" items="${miLista}">
					<tr>
						<td>${capacitacion.id}</td>
						<td>${capacitacion.nombreCapacitacion}</td>
						<td>${capacitacion.rut}</td>
						<td>${capacitacion.dia}</td>
						<td>${capacitacion.hora}</td>
						<td>${capacitacion.lugar}</td>
						<td>${capacitacion.duracion}</td>
						<td>${capacitacion.cantidadAsistentes}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%-- <% } else { %>
		<div class="alert alert-info">No hay capacitaciones disponibles.</div>
	% } %> --%>


	<footer><%@include file="extras/footer.jsp"%></footer>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
</body>