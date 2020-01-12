package mypack.servlets;

import mypack.beans.Client;
import mypack.beans.Commande;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CreationCommande extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter( "nomClient" );
        String prenom = req.getParameter( "prenomClient" );
        String adresse = req.getParameter( "adresseClient" );
        String tel = req.getParameter( "telephoneClient" );
        String email = req.getParameter( "emailClient" );

        Date d = new Date();
        String date = d.toString();
        double montant;
        try {
            montant = Double.parseDouble( req.getParameter( "montantCommande" ) );
        } catch ( NumberFormatException e ) {
            montant = -1;
        }
        String modePaiement = req.getParameter( "modePaiementCommande" );
        String statutPaiement = req.getParameter( "statutPaiementCommande" );
        String modeLivraison = req.getParameter( "modeLivraisonCommande" );
        String statutLivraison = req.getParameter( "statutLivraisonCommande" );

        String message;

        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || tel.trim().isEmpty() || montant == -1
                || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
        } else {
            message = "Commande créée avec succès !";
        }

        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresseLivraison( adresse );
        client.setTel( tel );
        client.setEmail( email );

        Commande commande = new Commande();
        commande.setClient( client );
        commande.setDate( date );
        commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutPaiement( statutPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatutLivraison( statutLivraison );

        /* Ajout du bean et du message à l'objet requête */
        req.setAttribute( "commande", commande );
        req.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/afficherCommande.jsp" ).forward( req, resp );

    }
}
