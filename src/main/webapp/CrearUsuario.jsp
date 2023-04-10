<!--stablecer la configuración básica de la página JSP actual, como el lenguaje de programación, el tipo de contenido y el conjunto de caracteres.-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--JSLT es una biblioteca de etiquetas personalizadas que se puede utilizar en páginas JSP para simplificar la escritura de código -->
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

<%@include file="extras/Navbar.jsp"%>
</head>
<!-- Formulario Crear Usuario -->
<body id="bodycapacitacion">
	<div class="container">
		<h1 class="text-center">Crear Usuario</h1>

		<!--La etiqueta form especifica que la información del formulario será enviada al servidor en una petición HTTP POST cuando se envíe el formulario.-->
		<form action="svCrearUsuario" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
							<!--La etiqueta label: proporciona una etiqueta descriptiva para el campo de entrada -->
							<label for="nombre">Nombres de Usuario:</label> <input
								type="text" id="nombre" name="nombre" class="form-control"
								maxlength="30" minlength="10" required> <span
								id="nombre-error" class="text-danger d-none">Ingrese al
								menos 10 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="tipoUsuario">Tipo de Usuario</label> <select
							id="tipoUsuario" name="tipoUsuario" class="form-control" required onchange="displayFormFields()">
							<option value="">Seleccione un tipo de usuario</option>
							<option value="cliente">Cliente</option>
							<option value="profesional">Profesional</option>
							<option value="administrativo">Administrativo</option>
						    </select> <span id="nombre-error" class="text-danger d-none">Seleccione un tipo de usuario.</span>
						<div class="formulario d-none" id="formulario-cliente">
							<jsp:include page="CrearCliente.jsp" />
						</div>
						<div class="formulario d-none" id="formulario-profesional">
							<%--     <jsp:include page="CrearProfesional.jsp" /> --%>
						</div>
						<div class="formulario d-none" id="formulario-administrativo">
							<jsp:include page="CrearAdministrativo.jsp" />
						</div>
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
							onblur="validarRut()">
						<div class="invalid-feedback">Ingrese un RUN válido (Ej:
							12345678-9)</div>
					</div>

				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="fechaNac">Fecha de Nacimiento</label> <input
							type="date" id="fechaNac" name="fechaNac" class="form-control"
							required min="1900-01-01" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
							title="Ingrese la fecha en formato AAAA-MM-DD">

					</div>

				</div>
			</div>
			<br>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>
				<div class="formulario d-none" id="formulario-cliente">
					<jsp:include page="CrearCliente.jsp" />
				</div>	
				<div class="formulario d-none" id="formulario-profesional">
					<%--     <jsp:include page="CrearProfesional.jsp" /> --%>
				</div>
				<div class="formulario d-none" id="formulario-administrativo">	
					<jsp:include page="CrearAdministrativo.jsp" />
				</div>
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
<script src="js/dnone.js"></script>

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
		    }
</script>
	<!-- Footer con la etiqueta include   -->
	<%@include file="extras/footer.jsp"%>
   
</html>