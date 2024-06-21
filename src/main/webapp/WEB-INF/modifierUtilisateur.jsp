<%@page import="beans.Utilisateur"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html>
<body>
	<c:import url ="inc/menu.jsp"/>	
	<div id="corps">
		<h1 id="titre-principal">Modification d'un utilisateur</h1>
		<form method="post">
			<div class="formItem">
				<label>Nom</label>
				<input type="text" name="nom" value="${utilisateur.nom }">
			</div>
			<div class="formItem">
				<label>Prénom</label>
				<input type="text" name="prenom" value="${utilisateur.prenom }">
			</div>
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${utilisateur.login}">
			</div>
			<div class="formItem">
				<label>Password</label>
				<input type="password" name="password" value="${utilisateur.password}">
			</div>
			<div class="formItem">
				<label></label>
				<input type="submit" value="Modifier">
			</div>
		</form>
	</div>
	<div id="pied">Copyright DIC3 ESP &copy; Novembre 2022</div>
</body>
</html>