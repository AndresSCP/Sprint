/*--código de JavaScript que contiene dos funciones para validar el RUT  y el nombre de un usuario  */
/*			  var rut = document.getElementById("run").value;
			  if (!/^(\d{7,8}-[\dkK])$/.test(rut)) {
			    document.getElementById("run").classList.add("is-invalid");
			  } else {
			    document.getElementById("run").classList.remove("is-invalid");
			  }
						
		    const inputNombre = document.querySelector('#nombre');
		    const nombreError = document.querySelector('#nombre-error');

		    inputNombre.addEventListener('input', () => {
		        if (inputNombre.value.length < 10) {
		            nombreError.classList.remove('d-none');
		        } else {
		            nombreError.classList.add('d-none');
		        }

		    });*/
		    
function displayFormFields() {
  const tipoUsuario = document.getElementById("tipoUsuario");
  const formularioCli = document.getElementById("formulario-cli");
  const formularioAdmin = document.getElementById("formularioAdmin");
  const formularioPro = document.getElementById("formularioPro");
  const formularioSv = document.getElementById("formularioSv"); // Agregamos esta línea
  
  if (tipoUsuario.value === "1") {
    formularioCli.classList.remove("d-none");
    formularioPro.classList.add("d-none");
    formularioAdmin.classList.add("d-none");
    formularioSv.action = 'SvCrearCliente'; // Agregamos esta línea
  } else if (tipoUsuario.value === "2") {
    formularioCli.classList.add("d-none");
    formularioPro.classList.remove("d-none");
    formularioAdmin.classList.add("d-none");
    formularioSv.action = 'SvCrearProfesional'; // Agregamos esta línea
  } else if (tipoUsuario.value === "3") {
    formularioCli.classList.add("d-none");
    formularioPro.classList.add("d-none");
    formularioAdmin.classList.remove("d-none");
    formularioSv.action = 'SvCrearAdministrador'; // Agregamos esta línea
  } else {
    formularioCli.classList.add("d-none");
    formularioPro.classList.add("d-none");
    formularioAdmin.classList.add("d-none");
    formularioSv.action = ''; // Agregamos esta línea para dejar vacía la propiedad "action" en caso contrario
  }
};




