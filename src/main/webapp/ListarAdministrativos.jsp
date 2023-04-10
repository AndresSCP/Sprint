<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/Style.css">
</head>
<h1>Listado de Administrativos</h1>
<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th>Run</th>
                <th>Nombre</th>
                <th>Fecha de Nacimiento</th>
                <th>Tipo de Usuario</th>
                <th>Area</th>
                <th>Experiencia Previa</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="administrativo" items="${miListaAdministrativo}">
                <tr>
                    <td>${administrativo.runUsuario}</td>
                    <td>${administrativo.nombreUsuario}</td>
                    <td>${administrativo.fechaNacimientoUsuario}</td>
                    <td>${administrativo.tipoUsuario}</td>
                    <td>${administrativo.area }</td>
                    <td>${administrativo.expPrevia}</td>
                    <td>${administrativo.email}</td>
			            <td>
			                <form method="post" action="/SvEditar-usuario">
			                    <input type="hidden" name="rut" value="${administrativo.runUsuario}">
			                    <button type="submit" class="btn btn-primary">
			                        <i class="bi bi-pencil"></i>
			                    </button>
			                </form>
			                <form method="post" action="/SvEliminar-usuario">
			                    <input type="hidden" name="rut" value="${administrativo.runUsuario}">
			                    <button type="submit" class="btn btn-danger">
			                        <i class="bi bi-trash"></i>
			                    </button>
			                </form>
			            </td>
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
    <script src="js/dnone.js"></script>	   
    </body>   
</html>