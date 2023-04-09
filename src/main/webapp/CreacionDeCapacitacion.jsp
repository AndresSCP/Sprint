<%if (session.getAttribute("username") == null) {response.sendRedirect("login.jsp");}%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

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

</head>
<body id="bodycapacitacion">

    <!-- Inserta navbar proveniente de navbar.sjp -->
    <%@include file = "extras/Navbar.jsp" %>
    
    <!-- Insertar formulario de creacion de capacitaciones -->   
    <div class="container">
        <form action="SvCrearCapacitacion2" method="post">
        <h1 class="text-center">Creacion de capacitacion</h1>
            <div class="form-group">
                <label for="nombreCapacitacion">Nombre de capacitacion:</label>
                <input type="text" id="nombre" name="nombreCapacitacion" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="rut">Rut:</label>
                <input type="number" id="rut" name="rut" class="form-control" required>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label for="dia" class="form-label">Dia:</label>
                    <select class="form-select" id="dia" name="dia" required>
                        <option selected disabled value="">Seleccione un dia</option>
                        <option value="lunes">Lunes</option>
                        <option value="martes">Martes</option>
                        <option value="miercoles">Miercoles</option>
                        <option value="jueves">Jueves</option>
                        <option value="viernes">Viernes</option>
                        <option value="sabado">Sabado</option>
                        <option value="domingo">Domingo</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="hora" class="form-label">Hora:</label>
                    <input type="time" id="hora" name="hora" class="form-control" required>
                </div>
                <div class="col-md-3">
                    <label for="lugar" class="form-label">Lugar:</label>
                    <select class="form-select" id="lugar" name="lugar" required>
                        <option selected disabled value="">Seleccione un lugar</option>
                        <option value="valparaiso">Valparaiso</option>
                        <option value="villa_alemana">Villa Alemana</option>
                        <option value="santiago">Santiago</option>
                        <option value="quillota">Quillota</option>
                    </select>
					</div>
					<div class="col-md-3">
						<label for="duracion" class="form-label">Duracion:</label> <input
							type="text" id="duracion" name="duracion" class="form-control"
							maxlength="70" required>
					</div>
				</div>
				<div class="form-group">
					<label for="cantidadAsistentes">Cantidad de Asistentes:</label> <input
						type="number" id="cantidad_asistentes" name="cantidadAsistentes"
						class="form-control" required max="999">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
			integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
			integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
			crossorigin="anonymous"></script>
</body>
<br>
<%@include file="extras/footer.jsp"%>
</html>
