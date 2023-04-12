
<%@page import="modelo.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="container">
		<h1 class="text-center"> Cliente</h1>
		<%
		 // Obtener el Cliente de la solicitud
		  Cliente cliente = (Cliente) request.getAttribute("cliente");
		%>
		
		<form action="SvEditarCliente" method="post" id ="formularioEditarCliente">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
						    <label for="nombreCli">Nombres</label>
						    <input type="text" id="nombreCli" name="nombreCli" value="<%= cliente.getNombres()%>" class="form-control" maxlength="30" minlength="5" required>
						    <span id="nombre-error" class="text-danger d-none">Ingrese al menos 5 caracteres.</span>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
					    <label for="apellidoCli">Apellidos</label>
					    <input type="text" id="apellidoCli" name="apellidoCli" value="<%= cliente.getApellidos()%>"  class="form-control" maxlength="30" minlength="5" required>
					    <span id="apellido-error" class="text-danger" style="display: none;">Ingrese al menos 5 caracteres.</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="telefono" class="form-label">Telefono:</label>
 						 <input type="text" id="telefono" name="telefono" value="<%= cliente.getTelefono()%>" class="form-control" maxlength="15" required >
  				</div>
					
				</div>
				<div class="col-md-6">
					<div class="form-group">
						  <label for="afp">AFP</label>
						  <input type="text" id="afp" name="afp" value="<%= cliente.getAfp()%>" class="form-control" maxlength="15" required>
						         
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
  						<label for="sistSalud" class="form-label">Sistema de Salud:</label>
                    <select class="form-select" id="sistSalud" name="sistSalud" required>
                        <option selected disabled value="">Seleccione una Opci�n</option>
                        <option value="1">Fonasa</option>
                        <option value="2">Isapre</option>
                     </select>
  				</div>
					
				</div>
				<div class="col-md-6">
					<div class="form-group">
						  <label for="direccion">Direcci�n</label>
						  <input type="text" id="direccion" name="direccion" value="<%= cliente.getDireccion()%>" class="form-control" maxlength="70" required>
						         
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						  <label for="comuna">Comuna</label>
						  <input type="text" id="comuna" name="comuna" value="<%= cliente.getComuna()%>" class="form-control" maxlength="50" required>
						         
					</div>
					
				</div>
					
				
				<div class="col-md-6">
					<div class="form-group">
					  <label for="edad">Edad</label>
					  <input type="number" id="edad" name="edad" value="<%= cliente.getEdad()%>"  class="form-control" maxlength="3" required min="0" max="150">
					  <div class="invalid-feedback">
					    La edad debe ser mayor o igual a 0 y menor que 150.
					  </div>
					</div>

					
				</div>
			</div>
			<br>
			<input type="hidden" name="id" value="<%= cliente.getRunUsuario() %>">
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
			  <%-- Eliminar el mensaje de la sesi�n de HTTP para evitar que se muestre de nuevo --%>
			  ${sessionScope.remove("mensaje")}
			</c:if>
		</form>
	</div>

	<br>


<script>
			//1. Obtener el valor del sistema de salud del cliente
			const sistemaSalud = cliente.getSistemaSalud();
			
			// 2. Seleccionar el select correspondiente
			const selectSistSalud = document.getElementById('sistSalud');
			
			// 3. Asignar el valor obtenido al atributo value del select
			selectSistSalud.value = sistemaSalud;

			
			
			const apellidoInput = document.getElementById('apellido');
		    const apellidoError = document.getElementById('apellido-error');
		    
		    apellidoInput.addEventListener('blur', () => {
		        if (apellidoInput.value.length < 10) {
		            apellidoError.style.display = 'inline';
		        } else {
		            apellidoError.style.display = 'none';
		        }
		    });
		    
		   
 </script>