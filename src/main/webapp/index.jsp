<!--Este codigo esta siendo utilizado para verificar si el usuario ha iniciado sesión en el sistema.-->
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- etiqueta meta se utiliza para garantizar que la página web se muestre de manera adecuada y legible en diferentes dispositivos y tamaños de pantalla.-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
	
	<!-- Vincular hoja de estilo Css -->
<link rel="stylesheet" href="css/Style.css">

</head>
<body id="bodyindex">
<!-- Navbar con La etiqueta incluide sirve para reutilizar el contenido en varias páginas JSP  -->
	<%@include file="extras/Navbar.jsp"%>

	<div class="container">
		<div class="row justify-content-center my-auto vh-100">

			<div
				class="col-md-4 col-lg-4 d-flex justify-content-center align-items-center mx-auto">
				<div class="image-container">
					<img src="./imagenes/persona.jpg" width="200" height="200"
						alt="Imagen 2" class="superpuesta" />
					<h2>¿Quiénes somos?</h2>
				</div>
			</div>

			<div
				class="col-md-6 col-lg-8 d-flex justify-content-center align-items-center"
				id="parrafo1">
				<p>Somos una empresa especializada en asesorías en prevención de
					riesgos. Nuestro equipo de expertos cuenta con una amplia
					experiencia en el campo de la seguridad laboral y está comprometido
					con brindar soluciones efectivas y personalizadas para garantizar
					la salud y seguridad de su personal y su entorno de trabajo. Nos
					enorgullece ofrecer una amplia gama de servicios, desde la
					evaluación y gestión de riesgos hasta la capacitación en seguridad,
					para ayudar a nuestros clientes a cumplir con los requisitos
					legales y mejorar continuamente sus prácticas de prevención de
					riesgos. En resumen, estamos comprometidos con el éxito de nuestros
					clientes a través de la prevención de riesgos y la promoción de un
					entorno de trabajo seguro y saludable.</p>
			</div>

		</div>
	</div>

</body>
<!-- Cargar archivos de bootstrap  -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>


<!-- Footer con la etiqueta include   -->
<footer><%@include file="extras/footer.jsp"%></footer>
</html>
