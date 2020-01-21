<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 12/01/2020
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Afficher le client</title>
    <link type="text/css" rel="stylesheet" href="styles.css">
</head>
<body>
    <%-- Importation du menu --%>
    <c:import url="menu.jsp"/>
    <div class = "info">
        ${message}
    </div>
    <p><c:out value="Nom : ${ client.nom }"/></p>
    <p><c:out value="Prénom : ${ client.prenom }"/></p>
    <p><c:out value="Adresse : ${ client.adresseLivraison }"/></p>
    <p><c:out value="Numéro de téléphone : ${ client.tel }"/></p>
    <p><c:out value="Email : ${ client.email }"/></p>
</body>
</html>
