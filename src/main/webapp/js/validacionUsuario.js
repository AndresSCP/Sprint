
			function validarRut() {
			  var rut = document.getElementById("run").value;
			  if (!/^(\d{7,8}-[\dkK])$/.test(rut)) {
			    document.getElementById("run").classList.add("is-invalid");
			  } else {
			    document.getElementById("run").classList.remove("is-invalid");
			  }
			}
			
			const apellidoInput = document.getElementById('apellido');
		    const apellidoError = document.getElementById('apellido-error');
		    
		    apellidoInput.addEventListener('blur', () => {
		        if (apellidoInput.value.length < 10) {
		            apellidoError.style.display = 'inline';
		        } else {
		            apellidoError.style.display = 'none';
		        }
		    });
		    
		    const inputNombre = document.querySelector('#nombre');
		    const nombreError = document.querySelector('#nombre-error');

		    inputNombre.addEventListener('input', () => {
		        if (inputNombre.value.length < 10) {
		            nombreError.classList.remove('d-none');
		        } else {
		            nombreError.classList.add('d-none');
		        }
		    });
