<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/Style.css">



<title>Formulario de Contacto</title>
<!-- Incluimos los archivos CSS de Bootstrap -->
</head>
<body id="bodycontacto">
	<%@include file="extras/Navbar.jsp"%>
	
	<body style="background-color: Lavender;">
	<div class="container">
		<h1 class="text-center">Formulario de Contacto</h1>
  <form id="formContacto" action=SvContacto method="post">
  <div class="form-group">
    <label for="nombre">Nombre de Contacto</label>
    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
    <div class="invalid-feedback"></div> <!-- Aquí se mostrará el mensaje de error -->
  </div>
  <div class="form-group">
    <label for="email">Correo Electrónico</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Correo Electrónico" required>
    <div class="invalid-feedback"></div> <!-- Aquí se mostrará el mensaje de error -->
  </div>
  <div class="form-group">
    <label for="asunto">Asunto</label>
    <input type="text" class="form-control" id="asunto" name="asunto" placeholder="Asunto" required>
    <div class="invalid-feedback"></div> <!-- Aquí se mostrará el mensaje de error -->
  </div>
  <div class="form-group">
    <label for="mensaje">Mensaje</label>
    <textarea class="form-control" id="mensaje" name="mensaje" rows="5" placeholder="Mensaje" required></textarea>
    <div class="invalid-feedback"></div> <!-- Aquí se mostrará el mensaje de error -->
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
			<c:if test="${not empty sessionScope.mensaje}">
			  <div class="alert alert-success alert-dismissible fade show" role="alert">
			    <strong>${sessionScope.mensaje}</strong>
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			      <span aria-hidden="true">&times;</span>
			    </button>
			  </div>
			  <%-- Eliminar el mensaje de la sesión de HTTP para evitar que se muestre de nuevo --%>
			  ${sessionScope.remove("mensaje")}
			</c:if>
		
	</div>
	
		
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="js/validaFormContacto.js"></script>
<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
			integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
			integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
			crossorigin="anonymous"></script>
</body>
<footer><%@include file="extras/footer.jsp"%></footer>
</html>
