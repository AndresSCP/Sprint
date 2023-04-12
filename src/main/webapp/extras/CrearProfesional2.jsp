
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container">
		<h1 class="text-center">Profesional</h1>
		<form action="SvCrearProfesional" method="post" id="formularioPro">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						    <label for="nombreTitulo">Titulo: </label>
						    <input type="text" id="nombreTitulo" name="nombreTitulo" class="form-control" maxlength="50" minlength="10" required>
						    <span id="nombre-error" class="text-danger d-none">Ingrese al menos 5 caracteres.</span>
						</div>
					</div>
				</div>
						<div class="col-md-6">
					<div class="form-group">
						<label for="fechaingreso">Fecha de Ingreso</label> <input
							type="date" id="fechaingreso" name="fechaingreso" class="form-control"
							required min="1900-01-01" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
							title="Ingrese la fecha en formato AAAA-MM-DD">

					</div>

				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="proyecto" class="form-label">Proyecto:</label>
 						 <input type="text" id="proyecto" name="proyecto" class="form-control" maxlength="50" required >
  				</div>
					
				</div>
			</div>
			<br>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Enviar</button>
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
