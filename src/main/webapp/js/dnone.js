function displayFormFields() {
    var selectedOption = document.getElementById("tipoUsuario").value;
    if (selectedOption == "cliente") {
        document.getElementById("formulario-cliente").classList.remove("d-none");
        document.getElementById("formulario-profesional").classList.add("d-none");
        document.getElementById("formulario-administrativo").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
    } else if (selectedOption == "profesional") {
        document.getElementById("formulario-cliente").classList.add("d-none");
        document.getElementById("formulario-profesional").classList.remove("d-none");
        document.getElementById("formulario-administrativo").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
    } else if (selectedOption == "administrativo") {
        document.getElementById("formulario-cliente").classList.add("d-none");
        document.getElementById("formulario-profesional").classList.add("d-none");
        document.getElementById("formulario-administrativo").classList.remove("d-none");
        document.getElementById("formulario-usuario").classList.add("d-none");
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                console.log(this.responseText);
            }
        };
        xmlhttp.open("GET", "SvListarAdministrativo", true);
        xmlhttp.send();
    } else if (selectedOption == "usuario") {
        document.getElementById("formulario-cliente").classList.add("d-none");
        document.getElementById("formulario-profesional").classList.add("d-none");
        document.getElementById("formulario-administrativo").classList.add("d-none");
        document.getElementById("formulario-usuario").classList.remove("d-none");
    }
}    
