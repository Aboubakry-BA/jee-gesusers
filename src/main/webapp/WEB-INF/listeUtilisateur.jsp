<%@ page import="beans.Utilisateur, java.util.ArrayList"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
<link rel="stylesheet" href="<c:url value='/css/design2.css'/>">
<script>
    function confirmSuppression() {
        return confirm("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
    }
</script>
</head>
<body>
    <c:import url="inc/menu.jsp"/>
    <div id="corps">
        <h1 id="titre-principal">Liste des utilisateurs</h1>
        <c:choose>
            <c:when test="${empty utilisateurs}">
                <p>La liste des utilisateurs est pour le moment vide !</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Login</th>
                        <th>Password</th>
                        <th colspan="2">Actions</th>
                    </tr>
                    <c:forEach var="utilisateur" items="${requestScope.utilisateurs}">
                        <tr>
                            <td><c:out value="${utilisateur.id}"/></td>
                            <td><c:out value="${utilisateur.prenom}"/></td>
                            <td><c:out value="${utilisateur.nom}"/></td>
                            <td><c:out value="${utilisateur.login}"/></td>
                            <td><c:out value="${utilisateur.password}"/></td>
                            <td><a href="<c:url value='/update?id=${utilisateur.id}'/>">Modifier</a></td>
                            <td><a href="<c:url value='/delete?id=${utilisateur.id}'/>" onclick="return confirmSuppression()">Supprimer</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="pied">Copyright DIC3 ESP &copy; 2024</div>
</body>
</html>
