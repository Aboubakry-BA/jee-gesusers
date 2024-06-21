<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Gestion des utilisateurs</title>
	<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
	<script src="<c:url value='/js/script.js'/>"></script>
</head>
<body>
	<div id="entete">Gestion des utilisateurs</div>
	<div id="menu">
		<ul>
			<li><a href='<c:url value="/"/>'>Accueil</a></li>
			<li><a href='<c:url value="/list"/>'>Lister</a></li>
			<li><a href='<c:url value="/add"/>'>Ajouter</a></li>
		</ul>
	</div>

</body>
</html>