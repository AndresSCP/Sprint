<!--stablecer la configuración básica de la página JSP actual, como el lenguaje de programación, el tipo de contenido y el conjunto de caracteres.-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--JSLT es una biblioteca de etiquetas personalizadas que se puede utilizar en páginas JSP para simplificar la escritura de código -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/Style.css">

<%@include file="extras/Navbar.jsp"%>
</head>
<!-- Formulario Crear Usuario -->
<body id="bodycapacitacion">
	<div class="container">


		<!--La etiqueta form especifica que la información del formulario será enviada al servidor en una petición HTTP POST cuando se envíe el formulario.-->
		<form action="SvEditarProfesional" method="post">

			<div class="row pt-5">
				<h3 class="text-center">Usuario</h3>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="nombre" class="form-label">Nombres de Usuario:</label>
						<input type="text" id="nombre" name="nombre" class="form-control"
							maxlength="30" required value="${datosPro[4]}">

					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="run" class="form-label">Run:</label> <input
							type="text" id="run" name="run" class="form-control"
							maxlength="12" required 
							value="${datosPro[0]}">
					</div>

				</div>
				<div class="col-md-4 col-sm-12">
					<label for="fechaNac" class="form-label">Fecha de
						Nacimiento</label> <input type="date" id="fechaNac" name="fechaNac"
						class="form-control" required min="01-01-1900"
						pattern="^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\d{4}$"
						title="Ingrese la fecha en formato AAAA-MM-DD"
						value="${datosPro[5]}">

				</div>



			</div>

			<div class="row pt-5">
				<h3 class="text-center">Profesional</h3>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="titulo" class="form-label">Titulo Profesional:</label>
						<input type="text" id="titulo" name="titulo" class="form-control"
							maxlength="30" value="${datosPro[1]}" required>

					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="fechaIn" class="form-label">Fecha de Ingreso:</label>
						<input type="date" id="fechaIn" name="fechaIn"
							class="form-control" min="01-01-1900" required
							value="${datosPro[2]}"
							pattern="^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\d{4}$"
							title="Ingrese la fecha en formato DD-MM-AAAA">
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="proyecto" class="form-label">Proyecto:</label> <input
							type="text" id="proyecto" name="proyecto" class="form-control"
							maxlength="30" required value="${datosPro[3]}">

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<div class="form-group">

						<label for="tipo" class="form-label">Tipo:</label> <input
							type="text" id="tipo" name="tipo" class="form-control"
							maxlength="30" required value="${datosPro[6]}">

					</div>
				</div>
				<div class="col-md-4 col-sm-12 d-flex align-items-center justify-content-center">
					
				</div>
			</div>
			<div class="row">
			<div class="col-md-12 col-sm-12 d-flex align-items-center justify-content-center">
					<div class="form-group pt-3 mt-3">						
						<button type="submit" class="btn btn-primary">
						  <i class="bi bi-pencil"></i> Actualizar
						</button>
					</div>
				</div>
			</div>
			<br>

			<!-- <div class="form-group"> -->
			<!-- <button type="submit" class="btn btn-primary">Enviar</button> -->
			<!-- </div>  -->
			<br>
			<%-- Verificar si hay un mensaje y mostrarlo en un mensaje de Bootstrap --%>
			<c:if test="${not empty sessionScope.mensaje}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<strong>${sessionScope.mensaje}</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<%-- Eliminar el mensaje de la sesión de HTTP para evitar que se muestre de nuevo --%>
			  ${sessionScope.remove("mensaje")}
			</c:if>
		</form>
	</div>

	<br>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous">
	
</script>
<!-- <script src="js/dnone.js"></script> -->
</html>