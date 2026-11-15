
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>

<h1>Page de connexion</h1>

<c:if test="${not empty erreur}">
    <p style="color: red;">
        <c:out value="${erreur}"/>
    </p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">

    <label>Login :</label><br>
    <input type="text" name="login"
           value="<c:out value='${login}'/>" required>

    <br><br>

    <label>Mot de passe :</label><br>
    <input type="password" name="password" required>

    <br><br>

    <button type="submit">Se connecter</button>

</form>

</body>
</html>
