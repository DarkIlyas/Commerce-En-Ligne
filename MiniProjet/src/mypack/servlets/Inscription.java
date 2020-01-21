package mypack.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inscription extends HttpServlet {
    static final String CHAMP_NOM = "nom";
    static final String CHAMP_EMAIL = "email";
    static final String CHAMP_MOT_DE_PASSE = "motdepasse";
    static final String CHAMP_CONFIRMATION ="confirmation";

    static final String ATT_NOM = "nom";
    static final String ATT_EMAIL = "email";
    static final String ATT_MOT_DE_PASSE = "motDePasse";
    static final String ATT_CONFIRMATION = "confirmation";
    static final String ATT_ERREURS = "erreurs";
    static final String ATT_RESULTAT = "resultat";

    final static String VUE = "/WEB-INF/inscription";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> erreurs = new HashMap<>();
        String resultat;

        String nom = req.getParameter(CHAMP_NOM);
        String motDePasse = req.getParameter(CHAMP_MOT_DE_PASSE);
        String confirmation = req.getParameter(CHAMP_CONFIRMATION);
        String email = req.getParameter(CHAMP_EMAIL);

        try {
            validationNom(nom);
        } catch (Exception e){
            erreurs.put(CHAMP_EMAIL,e.getMessage());
            }
        try {
            validationMotDePasse(motDePasse, confirmation);
        } catch (Exception e){
            erreurs.put(CHAMP_MOT_DE_PASSE,e.getMessage());
        }
        try {
            validationEmail(email);
        } catch (Exception e){
            erreurs.put(CHAMP_EMAIL,e.getMessage());
        }

        /*req.setAttribute(ATT_NOM,nom);
        req.setAttribute(ATT_MOT_DE_PASSE,motDePasse);
        req.setAttribute(ATT_CONFIRMATION,confirmation);
        req.setAttribute(ATT_EMAIL,email);*/


    }

    private void validationNom (String nom) throws Exception{
        if(nom.trim().length()<3 && nom != null){
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }
    private void validationEmail(String email) throws Exception{
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    private void validationMotDePasse(String motDePasse,String confirmation) throws Exception{
        if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }
}
