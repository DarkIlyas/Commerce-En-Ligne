<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="/styles.css" />
    </head>
    <body>
    <%-- Importation du menu --%>
    <c:import url="/menu.jsp"/>
        <div>
            <form method="post" action="/creationClient">
                <fieldset>
                    <legend>Informations client</legend>
                    <c:import url="/formulaireClient.jsp"/>
                </fieldset>
                <div class = "info">
                    ${form.resultat}
                </div>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" />  <br />

            </form>
        </div>
    </body>
</html>