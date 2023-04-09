// ------- horario y fecha -------

 let contenedor = document.getElementById('calendario');
const semana = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];

const dia = new Date();
let dias = semana[dia.getDay()]

const diaNum = new Date()
let diasNum = diaNum.getDate()

const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]

const month = new Date()
let months = meses[month.getMonth()]

const hora = new Date()
let horaAhora = hora.toLocaleTimeString('es-CL')


const annio = new Date();
let annios = annio.getFullYear()
contenedor.innerHTML = '' + dias + '  ' + diasNum + " de " + months + " año " + annios + ' y la hora es ' + horaAhora;
   
