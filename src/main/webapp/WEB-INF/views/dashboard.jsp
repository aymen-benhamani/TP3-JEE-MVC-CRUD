
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>

<h1>Bienvenue <c:out value="${user}"/> !</h1>

<p>Vous êtes connecté.</p>

<a href="${pageContext.request.contextPath}/produits">
    Gestion des produits
</a>

<br><br>

<a href="${pageContext.request.contextPath}/logout">
    Déconnexion
</a>

</body>
</html>
