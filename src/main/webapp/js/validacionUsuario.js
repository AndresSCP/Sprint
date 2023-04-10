//realiza la validación de los campos de entrada "run", "apellido" y "nombre" de un formulario HTML.

// la función obtiene el valor ingresado en el campo de entrada "run" del formulario HTML utilizando el método getElementById().
			function validarRut() {
			  var rut = document.getElementById("run").value;
			  
			  //d{7,8} indica que la cadena debe contener entre 7 y 8 dígitos numéricos.
			  //[\dkK] indica que después del guion puede haber una letra "k" o "K"
			  if (!/^(\d{7,8}-[\dkK])$/.test(rut)) {
			    document.getElementById("run").classList.add("is-invalid");
			  } else {
			    document.getElementById("run").classList.remove("is-invalid");
			  }
			}
			
			const apellidoInput = document.getElementById('apellido');
		    const apellidoError = document.getElementById('apellido-error');
		    
		    
		    //event listener valida la longitud del valor en el campo de entrada de texto del apellido.
		    // validar la longitud del apellido y mostrar un mensaje de error si el apellido ingresado por el usuario no cumple con el requisito de longitud mínima.
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
