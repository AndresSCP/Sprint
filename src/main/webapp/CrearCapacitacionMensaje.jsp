<%-- 
    Document   : capacitacionMensaje.jsp
    Created on : Apr 5, 2023, 11:59:20 AM
    Author     : Leonel Briones Palacios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- BOOTSTRAP CSS V5.2.3 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="css/Style.css">
<title>Éxito</title>
</head>
<header>
	<nav></nav>
</header>
<body class="container" id="BodyCrearCapacitacionM">
<form id="formContacto" method="POST" action="index.jsp">
<h1 class="text-center py-3 my-5 border-bottom">Capacitación
		Guardada con éxito</h1>

	<c:if test="${not empty descripcion}">
		<p class="fs-5 text-success">${descripcion}</p>
	</c:if>

	<h1>Capacitación creada:</h1>
		${capacitacionStr}



<br><br>

<button type="submit" class="btn btn-primary">Volver</button>


</body>
</form>
<!-- BOOTSTRAP V5.2.3 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</body>

<footer> </footer>
</html>