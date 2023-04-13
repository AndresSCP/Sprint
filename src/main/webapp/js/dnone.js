

/*La función displayFormFields() es una función de JavaScript que se encarga de mostrar diferentes campos de formulario en función de la opción 
seleccionada en una lista desplegable con un id de "tipoUsuario".*/
function displayFormFields() {
	
    var selectedOption = document.getElementById("tipoUsuario").value;
    
    /*  Dependiendo del valor de selectedOption, diferentes campos de formulario se mostrarán u ocultarán utilizando los métodos 
    classList.add() y classList.remove().*/
    if (selectedOption == "Cliente") {
		/*La cadena de caracteres "d-none" es una clase de CSS que se utiliza para ocultar un elemento en una página web*/
        document.getElementById("formulario-cli").classList.remove("d-none");
        document.getElementById("formularioPro").classList.add("d-none");
        document.getElementById("formularioAdmin").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
    } else if (selectedOption == "Profesional") {
        document.getElementById("formulario-cli").classList.add("d-none");
        document.getElementById("formularioPro").classList.remove("d-none");
        document.getElementById("formularioAdmin").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
    } else if (selectedOption == "Administrativo") {
        document.getElementById("formulario-cli").classList.add("d-none");
        document.getElementById("formularioPro").classList.add("d-none");
        document.getElementById("formularioAdmin").classList.remove("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
    } else if (selectedOption == "usuario") {
        document.getElementById("formulario-cli").classList.add("d-none");
        document.getElementById("formularioPro").classList.add("d-none");
        document.getElementById("formularioAdmin").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.remove("d-none");
}
}