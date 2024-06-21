<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
	<c:import url ="inc/menu.jsp"/>	 
	<div id="corps">
		<h1 id="titre-principal">Ajout d'un utilisateur</h1>
		<p id="statusMessage" class=${status ? 'succes' : 'erreur'}>${statusMessage}</p>
		<form method="post">
			<div class="formItem">
				<label>Nom</label>
				<input type="text" name="nom" value="${utilisateur.nom}">
				<span class="erreur">${erreurs.nom}</span>
			</div class="formItem">
			<div class="formItem">
				<label>Prénom</label>
				<input type="text" name="prenom" value="${utilisateur.prenom}">
				<span class="erreur">${erreurs.prenom}</span>
			</div>
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${utilisateur.login}">
				<span class="erreur">${erreurs.login}</span>
			</div>
			<div class="formItem">
				<label>Password</label>
				<input type="password" name="password">
				<span class="erreur">${erreurs.password}</span>
			</div>
			
			<div class="formItem">
				<label>PasswordConfirmation</label>
				<input type="password" name="passwordBis">
				<span class="erreur">${erreurs.passwordBis}</span>
			</div>
			
			<div class="formItem">
		
				<label></label>
				<input type="submit" value="Ajouter">
			</div>
		</form>
	</div>
	<div id="pied">Copyright DIC3 ESP &copy; 2024</div>	
	</body>
</html>