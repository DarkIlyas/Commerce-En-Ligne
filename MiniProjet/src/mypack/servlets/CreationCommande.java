package mypack.servlets;

import mypack.beans.Client;
import mypack.beans.Commande;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreationCommande extends HttpServlet {
    static final String MESSAGE_ERREUR = "Erreur - vous n'avez pas rempli tous les champs obligatoires. <br> <a href='/creerClient.jsp'>Cliquez-ici</a> pour revenir remplir le formulaire";
    static final String MESSAGE_SUCCES ="Client créé avec succès !<br>";

    static final String CHAMP_NOM = "nomClient";
    static final String CHAMP_PRENOM = "prenomClient";
    static final String CHAMP_ADRESSE = "adresseClient";
    static final String CHAMP_TEL = "telephoneClient";
    static final String CHAMP_EMAIL = "emailClient";
    static final String CHAMP_MODE_PAIMENT = "modePaiementCommande";
    static final String CHAMP_STATUT_PAIEMENT = "statutPaiementCommande";
    static final String CHAMP_MODE_LIVRAISON = "modeLivraisonCommande";
    static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
    static final String CHAMP_MONTANT_COMMANDE = "montantCommande";

    static final String ATT_MESSAGE = "message";
    static final String ATT_CLIENT = "client";

    static final String VUE = "/afficherCommande.jsp";

    static final String COMMANDE = "commande";
    static final String MESSAGE = "message";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter( CHAMP_NOM );
        String prenom = req.getParameter( CHAMP_PRENOM );
        String adresse = req.getParameter( CHAMP_ADRESSE );
        String tel = req.getParameter( CHAMP_TEL );
        String email = req.getParameter( CHAMP_EMAIL);

        Date d = new Date();
        String date = d.toString();
        double montant;
        try {
            montant = Double.parseDouble( req.getParameter( CHAMP_MONTANT_COMMANDE ) );
        } catch ( NumberFormatException e ) {
            montant = -1;
        }
        String modePaiement = req.getParameter(CHAMP_MODE_PAIMENT);
        String statutPaiement = req.getParameter(CHAMP_STATUT_PAIEMENT);
        String modeLivraison = req.getParameter(CHAMP_MODE_LIVRAISON);
        String statutLivraison = req.getParameter(CHAMP_STATUT_LIVRAISON);

        String message;

        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || tel.trim().isEmpty() || montant == -1
                || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
            message = MESSAGE_ERREUR;
        } else {
            message = MESSAGE_SUCCES;
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
        req.setAttribute( COMMANDE, commande );
        req.setAttribute( MESSAGE, message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher(VUE).forward( req, resp );

    }
}
