<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
		  rel="stylesheet"
		  integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
		  crossorigin="anonymous">
	<link rel="stylesheet" href="css/Style.css">	
</head>
<body id="bodycliente">
	<div class="container">
	
		<h1 class="text-center">Editar Administrativo</h1>
		
		<c:set var="administrativo" value="${requestScope.administrativo}"/>
		
		<form action="SvEditarAdministrativo" method="POST" id="formulaAdmin">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
							<!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="nombre">Nombres de Usuario:</label> 
							<input type="text" id="nombre" name="nombre" class="form-control" value="${administrativo.getNombreUsuario()}"
								maxlength="30" minlength="10" required  > 
							<span id="nombre-error" class="text-danger d-none">.</span>
						</div>
					</div>
				</div>
			 <div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
							<!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="Run">Run</label> 
							<input type="text" id="Run" name="run" class="form-control" value="${administrativo.getRunUsuario()}"
								maxlength="30" minlength="10" required  > 
							<span id="nombre-error" class="text-danger d-none">.</span>
						</div>
					</div>
				</div>
			 <div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
							<!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="tipoUsuario">Tipo de Usuario</label> 
							<input type="text" id="tipoUsuario" name="tipoUsuario" class="form-control" value="${administrativo.getTipoUsuario()}"
								maxlength="30" minlength="10" required  > 
							<span id="nombre-error" class="text-danger d-none">.</span>
						</div>
					</div>
				</div>
							 <div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
							<!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="fechaNacimientoUsuario">Fecha de nacimiento</label> 
							<input type="text" id="fechaNacimientoUsuario" name="fechaNacimientoUsuario" class="form-control" value="${administrativo.getFechaNacimientoUsuario()}"
								maxlength="30" minlength="10" required  > 
							<span id="nombre-error" class="text-danger d-none">.</span>
						</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						    <label for="area">Area: </label>
						    <input type="text" id="area" name="area" class="form-control" maxlength="30" minlength="5" required 
						    value="${administrativo.getArea()}">
						    <span id="nombre-error" class="text-danger d-none">Ingrese al menos 5 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
					    <label for="expPrevia">Experiencia Previa: </label>
					    <input type="text" id="expPrevia" name="expPrevia" class="form-control" maxlength="30" minlength="5" required					    
					    value="${administrativo.getExpPrevia()}">
					    
					    <span id="apellido-error" class="text-danger" style="display: none;">Ingrese al menos 5 caracteres.</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="email" class="form-label">Email:</label>
 						 <input type="text" id="email" name="email" class="form-control" maxlength="15" required 
 						  value="${administrativo.getEmail()}">
  				</div>
					
				</div>
			</div>
			<br>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Actualizar</button>
			</div>
			<button type="button" class="btn btn-primary" onclick="window.location.href='ListarAdministrativos.jsp'">Volver</button>
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
</html>
