// ------- horario y fecha -------

// Codigo que utiliza el objeto Date para obtener la fecha y hora actual y mostrarla en un contenedor HTML con el id "calendario". 

//La primera línea declara una variable contenedor y la asigna al elemento HTML con el id "calendario". 
 let contenedor = document.getElementById('calendario');
 
 //se crea un array semana con los nombres de los días de la semana.//
const semana = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];

//Se crea un objeto Date y se usa su método getDay() para obtener el número del día de la semana 
const dia = new Date();
let dias = semana[dia.getDay()]

//Se crea otro objeto Date y se usa su método getDate() para obtener el día del mes actual. Este número se asigna a la variable diasNum.
const diaNum = new Date()
let diasNum = diaNum.getDate()

//Se crea otro array meses con los nombres de los meses del año.
const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]

//Se crea otro objeto Date y se usa su método getMonth() para obtener el número del mes actual, que se usa como índice para acceder al nombre del mes en el array meses.
const month = new Date()
let months = meses[month.getMonth()]

//Se crea otro objeto Date y se usa su método toLocaleTimeString() para obtener la hora actual en formato de hora local. Este valor se asigna a la variable horaAhora.
const hora = new Date()
let horaAhora = hora.toLocaleTimeString('es-CL')

//se actualiza el contenido del elemento HTML con la fecha, el año y la hora actual utilizando las variables dias, diasNum, months, annios y horaAhora.
const annio = new Date();
let annios = annio.getFullYear()
contenedor.innerHTML = '' + dias + '  ' + diasNum + " de " + months + " año " + annios + ' y la hora es ' + horaAhora;
   
