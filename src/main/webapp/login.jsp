<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesion</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Style.css">
</head>

<!-- Formulario de inicio de sesion -->
<body id="bodylogin">
	<h1 class="text-center" id="textlogin">Inicio de sesión</h1>

	<div class="conteiner-fluid" id="textlogin">
		<div class="row">
			<div class="col-12 d-flex justify-content-center">

				<form class="mx-auto pt-5" action="Login" method="POST">
					<div class="mb-3">
						<label for="imputUsuario" class="form-label">Usuario</label> <input
							type="text" class="form-control" id="inputUsuario"
							name="inputUsuario" aria-describedby="Help">
						<div id="Help" class="form-text"></div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Contraseña</label> <input
							type="password" class="form-control" name="password"
							id="password">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="remember">
						<label class="form-check-label" for="exampleCheck1">Recuerdame..</label>
					</div>
					<button type="submit" class="btn btn-primary">Log In</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	<!-- verificacion si hay un mensaje de error en la solicitud HTTP.Si el atributo "mensajeError" está establecido, se muestra un mensaje de error -->
	<%
	if (request.getAttribute("mensajeError") != null) {
	%>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-3">
				<div class="alert alert-danger text-center" role="alert">
					<%=request.getAttribute("mensajeError")%>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>

	<%@include file="extras/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
</body>

</html>