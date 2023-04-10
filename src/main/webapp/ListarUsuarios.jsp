
<!--JSLT es una biblioteca de etiquetas personalizadas que se puede utilizar en p�ginas JSP para simplificar la escritura de c�digo -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navbar con La etiqueta incluide sirve para reutilizar el contenido en varias p�ginas JSP  -->
<%@include file="extras/Navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/Style.css">

</head>
<body id="bodylistado">


	<h1>Listado de Usuarios</h1>
	<div class="container" >

		<div class="col-md-12">
			<div class="form-group" >
				<label for="tipoUsuario">Tipo de Usuario</label> <select
					id="tipoUsuario" name="tipoUsuario" class="form-control" required
					onchange="displayFormFields()">
					<option value="">Seleccione un tipo de usuario</option>
					<option value="cliente">Cliente</option>
					<option value="profesional">Profesional</option>
					<option value="administrativo">Administrativo</option>
					<option value="usuario">Usuario</option>
				</select> <span id="nombre-error" class="text-danger">Seleccione
					un tipo de usuario.</span>
				<div class="formulario d-none" id="formulario-usuario">
					<!-- se definen cuatro columnas (RUN Usuario, Nombres, Fecha de Nacimiento y Tipo Usuario) utilizando la etiqueta "th" para los encabezados de columna.-->
					<table class="table">
						<thead>
							<tr>
								<th>RUN Usuario</th>
								<th>Nombres</th>
								<th>Fecha de Nacimiento</th>
								<th>Tipo Usuario</th>
							</tr>
						</thead>

						<!-- lista de usuarios en una tabla con la etiqueta c:forEach para iterar sobre una lista de objetos de usuario-->
						<tbody>
							<!--<c:out value="${miListaUsuario}" /> con esto se valida si trae datos -->
							<c:forEach var="usuario" items="${miListaUsuario}">

								<tr>
									<th>${usuario.runUsuario}</th>
									<td>${usuario.nombreUsuario}</td>
									<td>${usuario.fechaNacimientoUsuario}</td>
									<td>${usuario.tipoUsuario}</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
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
			</div>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
<script src="js/dnone.js"></script>		

</body>
<footer><%@include file="extras/footer.jsp"%></footer>


</html>