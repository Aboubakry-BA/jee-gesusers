<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% final String APP_ROOT = request.getContextPath() ; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion utilisateur</title>
<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
</head>
<body>	
	<form method="post" action ="login">
		
		<div class="formItem">
			<label>Login</label>
			<input type="text" name="login"/>
		</div>
		
		
		<div class="formItem">
			<label>Password</label>
			<input type="password" name="password"/>
		</div>
		
	
		<div class="formItem">
			<label></label>
			<input type="submit" value="Connect"/>	
		</div>
		
	
	</form>
	<div id="pied">Copyright DIC3 ESP &copy; Novembre 2022</div>	

</body>
</html>

