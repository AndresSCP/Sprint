<!--stablecer la configuración básica de la página JSP actual, como el lenguaje de programación, el tipo de contenido y el conjunto de caracteres.-->
<%@page import="modelo.Cliente"%>
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
<!-- Formulario Editar Usuario -->
<body id="bodyeditarUsuario">
	<div class="container">
		<h1 class="text-center">Usuario</h1>

		<!--La etiqueta form especifica que la información del formulario será enviada al servidor en una petición HTTP POST cuando se envíe el formulario.-->
		<form action="SvEditarCliente" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						 <!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="nombre">Nombres de Usuario:</label> <input
								type="text" id="nombre" name="nombre" class="form-control"
								maxlength="30" minlength="10"  value="${cliente.nombreUsuario}" required> <span
								id="nombre-error" class="text-danger d-none">Ingrese al
								menos 10 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="tipoUsuario">Tipo de Usuario</label> <select
							id="tipoUsuario" name="tipoUsuario" class="form-control" required>
							
							<option value=1 selected disabled>Cliente</option>
							
						</select> <span id="tipoUsuario-error" class="text-danger"
							style="display: none;">Seleccione un tipo de usuario.</span>
					</div>
				</div>

				<br>
				
				<br>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="run" class="form-label">RUN:</label> <input
							type="text" id="run" name="run" class="form-control"
							maxlength="10" required pattern="\d{7,8}-[Kk\d]"
							onblur="validarRut()" value="${cliente.runUsuario}">
						<div class="invalid-feedback">Ingrese un RUN válido (Ej:
							12345678-9)</div>
					</div>

				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="fechaNac">Fecha de Nacimiento</label> <input
							type="date" id="fechaNac" name="fechaNac" class="form-control"
							required min="1900-01-01" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
							title="Ingrese la fecha en formato AAAA-MM-DD"
							 value="${cliente.fechaNacimientoUsuario}">

					</div>

				</div>
			</div>
		
				
	<div class="container">
		<h1 class="text-center"> Cliente</h1>
		
		
		<form action="SvEditarCliente" method="post" id ="formularioEditarCliente">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						    <label for="nombreCli">Nombres</label>
						    <input type="text" id="nombreCli" name="nombreCli" value="${cliente.nombres}" class="form-control" maxlength="30" minlength="5" required>
						    <span id="nombre-error" class="text-danger d-none">Ingrese al menos 5 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
					    <label for="apellidoCli">Apellidos</label>
					    <input type="text" id="apellidoCli" name="apellidoCli" value="${cliente.apellidos}"  class="form-control" maxlength="30" minlength="5" required>
					    <span id="apellido-error" class="text-danger" style="display: none;">Ingrese al menos 5 caracteres.</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="telefono" class="form-label">Telefono:</label>
 						 <input type="text" id="telefono" name="telefono" value="${cliente.telefono}" class="form-control" maxlength="15" required >
  				</div>
					
				</div>
				<div class="col-md-6">
					<div class="form-group">
						  <label for="afp">AFP</label>
						  <input type="text" id="afp" name="afp" value="${cliente.afp}" class="form-control" maxlength="15" required>
						         
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
				    <div class="form-group">
				        <label for="sistSalud" class="form-label">Sistema de Salud:</label>
				        <select class="form-select" id="sistSalud" name="sistSalud" required>
						    <option value="">Seleccione una Opción</option>
						    <option value="Fonasa" ${cliente.sistemaSalud == 1 ? 'selected' : ''}>Fonasa</option>
						    <option value="Isapre" ${cliente.sistemaSalud == 2 ? 'selected' : ''}>Isapre</option>
						</select>

				    </div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						  <label for="direccion">Dirección</label>
						  <input type="text" id="direccion" name="direccion" value="${cliente.direccion}" class="form-control" maxlength="70" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						  <label for="comuna">Comuna</label>
						  <input type="text" id="comuna" name="comuna" value="${cliente.comuna}" class="form-control" maxlength="50" required>
						         
					</div>
					
				</div>
					
				
				<div class="col-md-6">
					<div class="form-group">
					  <label for="edad">Edad</label>
					  <input type="number" id="edad" name="edad" value="${cliente.edad}"  class="form-control" maxlength="3" required min="0" max="150">
					  <div class="invalid-feedback">
					    La edad debe ser mayor o igual a 0 y menor que 150.
					  </div>
					</div>

					
				</div>
			</div>
			<br>
			<input type="hidden" name="id" value="${cliente.runUsuario}">
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Modificar</button>
			</div>
			<br>
			<%-- Verificar si hay un mensaje y mostrarlo en un mensaje de Bootstrap --%>
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
		</form>
	</div>
</div>	
 <%@include file="extras/footer.jsp"%>	
	<br>
	<!-- Footer con la etiqueta include   -->
	

</body>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>

<!--código de JavaScript que contiene dos funciones para validar el RUT  y el nombre de un usuario  -->
<script>
			function validarRut() {
			  var rut = document.getElementById("run").value;
			  if (!/^(\d{7,8}-[\dkK])$/.test(rut)) {
			    document.getElementById("run").classList.add("is-invalid");
			  } else {
			    document.getElementById("run").classList.remove("is-invalid");
			  }
			}
			
			
		    const inputNombre = document.querySelector('#nombre');
		    const nombreError = document.querySelector('#nombre-error');

		    inputNombre.addEventListener('input', () => {
		        if (inputNombre.value.length < 10) {
		            nombreError.classList.remove('d-none');
		        } else {
		            nombreError.classList.add('d-none');
		        }
		    });
		    
		   


    </script>
   
</html>