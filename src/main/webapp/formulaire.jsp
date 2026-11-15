
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire utilisateur</title>
</head>
<body>

    <h1>Formulaire utilisateur</h1>

    <form action="formulaire" method="post">

        <label>Nom :</label>
        <input type="text" name="nom" required>
        <br><br>

        <label>Email :</label>
        <input type="email" name="email" required>
        <br><br>

        <button type="submit">Envoyer</button>

    </form>

</body>
</html>
