

	<div class="container">
		<h1 class="text-center">Administrativo</h1>
		<form action="SvCrearAdministrador" method="post" id="formularioAdmin" >
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						    <label for="area">Area: </label>
						    <input type="text" id="area" name="area" class="form-control" maxlength="30" minlength="5" required>
						    <span id="nombre-error" class="text-danger d-none">Ingrese al menos 5 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
					    <label for="expPrevia">Experiencia Previa: </label>
					    <input type="text" id="expPrevia" name="expPrevia" class="form-control" maxlength="30" minlength="5" required>
					    <span id="apellido-error" class="text-danger" style="display: none;">Ingrese al menos 5 caracteres.</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="email" class="form-label">Email:</label>
 						 <input type="text" id="email" name="email" class="form-control" maxlength="15" required >
  				</div>
					
				</div>
			</div>
			<br>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Ingresar</button>
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




