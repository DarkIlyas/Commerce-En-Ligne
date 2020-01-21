package mypack.servlets;

import mypack.beans.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationClient extends HttpServlet {
    static final String MESSAGE_ERREUR = "Erreur - vous n'avez pas rempli tous les champs obligatoires <br> <a href='/creerClient.jsp'>Cliquez-ici</a> pour revenir remplir le formulaire";
    static final String MESSAGE_SUCCES ="Client créé avec succès !<br>";

    static final String CHAMP_NOM = "nomClient";
    static final String CHAMP_PRENOM = "prenomClient";
    static final String CHAMP_ADRESSE = "adresseClient";
    static final String CHAMP_TEL = "telephoneClient";
    static final String CHAMP_EMAIL = "emailClient";

    static final String ATT_MESSAGE = "message";
    static final String ATT_CLIENT = "client";

    static final String VUE = "/afficherClient.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter(CHAMP_NOM);
        String prenom = req.getParameter(CHAMP_PRENOM);
        String adresse = req.getParameter(CHAMP_ADRESSE);
        String tel = req.getParameter(CHAMP_TEL);
        String email = req.getParameter(CHAMP_EMAIL);
        Client newClient = new Client();
        newClient.setNom(nom);
        newClient.setPrenom(prenom);
        newClient.setEmail(email);
        newClient.setTel(tel);
        newClient.setAdresseLivraison(adresse);

        String message;
        if(nom.trim().isEmpty() || adresse.trim().isEmpty() || tel.trim().isEmpty()){
            message = MESSAGE_ERREUR;
        } else {
            message = MESSAGE_SUCCES;
        }
        req.setAttribute(ATT_MESSAGE,message);
        req.setAttribute(ATT_CLIENT,newClient);
        req.getServletContext().getRequestDispatcher(VUE).forward(req,resp);

    }
}
