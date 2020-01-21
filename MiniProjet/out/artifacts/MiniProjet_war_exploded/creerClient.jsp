<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <%-- Importation du menu --%>
        <c:import url="menu.jsp"/>
        <div>
            <form method="get" action="creationClient">
                <c:import url="formulaireClient.jsp"/>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>