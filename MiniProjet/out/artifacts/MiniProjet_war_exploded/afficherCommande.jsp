<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Affichage d'une commande</title>
    <link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
<%-- Affichage de la chaîne "message" transmise par la servlet --%>
<p class="info"><c:out value="${ message }"/></p>
<%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
<p>Client</p>
<%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande --%>
<p><c:out value="Nom : ${ commande.client.nom }"/></p>
<p><c:out value="Prénom : ${ commande.client.prenom }"/></p>
<p><c:out value="Adresse : ${ commande.client.adresseLivraison }"/></p>
<p><c:out value="Numéro de téléphone : ${ commande.client.tel }"/></p>
<p><c:out value="Email : ${ commande.client.email }"/></p>
<p><c:out value="Commande"/></p>
<p><c:out value="Date  : ${ commande.date }"/></p>
<p><c:out value="Montant  : ${ commande.montant }"/></p>
<p><c:out value="Mode de paiement  : ${ commande.modePaiement }"/></p>
<p><c:out value="Statut du paiement  : ${ commande.statutPaiement }"/></p>
<p><c:out value="Mode de livraison  : ${ commande.modeLivraison }"/></p>
<p><c:out value="Statut de la livraison  : ${ commande.statutLivraison }"/></p>
</body>
</html>