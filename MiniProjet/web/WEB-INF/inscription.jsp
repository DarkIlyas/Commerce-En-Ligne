<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 21/01/2020
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="../styles.css" />
</head>
<body>
<form method="post" action="inscription">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <%-- j'ai ajouté la balise c:out dans la valeur d'input pour raison de protection contre les failles XSS --%>

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="text" id="email" name="email" value="<c:out value="${user.getEmail()}" />" size="20" maxlength="60" />
        <span class="erreur">${form.getErreurs()['email']}</span>
        <br />


        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="erreur">${form.getErreurs()['motdepasse']}</span>
        <br />

        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
        <br />

        <label for="nom">Nom d'utilisateur</label>
        <input type="text" id="nom" name="nom" value="<c:out value="${user.getNom()}" />" size="20" maxlength="20" />
        <span class="erreur">${form.getErreurs()['nom']}</span>
        <br />

        <input type="submit" value="Inscription" class="sansLabel" />
        <br />
        <div class="${empty form.getErreurs() ? 'succes' : 'erreur'}">${form.getResultat()}</div>

    </fieldset>
</form>
</body>
</html>