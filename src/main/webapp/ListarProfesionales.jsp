<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="extras/Navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
		<link rel="stylesheet" href="css/Style.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    </head>
    <body id="bodylistado">
</head>
<h1>Listado de Profesionales</h1>
<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th>run</th>
                <th>tituloProfesional</th>
                <th>fechaIngreso</th>
                <th>proyecto</th>
                <th>nombre</th>
                <th>fechaNac</th>
                <th>tipo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
	<c:forEach var="profesional" items="${miListaProfesional}">
  <tr>
    <td>${profesional[0]}</td>
    <td>${profesional[1]}</td>
    <td>${profesional[2]}</td>
    <td>${profesional[3]}</td>
    <td>${profesional[4]}</td>
    <td>${profesional[5]}</td>
    <td>${profesional[6]}</td>
    <td><a href="${pageContext.request.contextPath}/SvEditarProfesional?run=${profesional[0]}" class="btn btn-primary">
    <i class="bi bi-pencil"></i>
</a></td>
  </tr>
</c:forEach>
        </tbody>
    </table>
</div>

     <script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" 	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
       
    </body>
    <!-- Footer con la etiqueta include   -->
	<footer><%@include file="extras/footer.jsp"%></footer>	
</html>