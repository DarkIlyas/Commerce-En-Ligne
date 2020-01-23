package insc.forms;

import insc.beans.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class InscriptionForm {
    static final String CHAMP_NOM = "nom";
    static final String CHAMP_EMAIL = "email";
    static final String CHAMP_MOT_DE_PASSE = "motdepasse";
    static final String CHAMP_CONFIRMATION ="confirmation";

    private static Map<String,String> erreurs = new HashMap<>();
    private static String resultat;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    public InscriptionForm(){}

    public Utilisateur inscrireUtilisateur(HttpServletRequest req){
        String nom = getValeurChamp(req,CHAMP_NOM);
        String motDePasse = getValeurChamp(req,CHAMP_MOT_DE_PASSE);
        String confirmation = getValeurChamp(req,CHAMP_CONFIRMATION);
        String email = getValeurChamp(req,CHAMP_EMAIL);

        Utilisateur user = new Utilisateur();

        try {
            validationNom(nom);
        } catch (Exception e){
            setError(CHAMP_NOM,e.getMessage());
        }
        user.setNom(nom);

        try {
            validationMotDePasse(motDePasse, confirmation);
        } catch (Exception e){
            setError(CHAMP_MOT_DE_PASSE,e.getMessage());
        }
        user.setMotDePasse(motDePasse);

        try {
            validationEmail(email);
        } catch (Exception e){
            setError(CHAMP_EMAIL,e.getMessage());
        }
        user.getEmail();

        if(erreurs.isEmpty()){
            resultat = "Succés de l'inscription";
        } else {
            resultat = "Echec de l'inscription";
        }

        return user;
    }

    private void setError(String champ,String message){
        erreurs.put(champ,message);
    }



    private void validationNom (String nom) throws Exception{
        if(nom.trim().length()<3 && nom != null){
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }
    private void validationEmail(String email) throws Exception{
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    private void validationMotDePasse(String motDePasse,String confirmation) throws Exception{
        if (motDePasse != null && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    private String getValeurChamp(HttpServletRequest request,String nomChamp){
        String valeur = request.getParameter(nomChamp);
        if(valeur == null || valeur.trim().length() == 0){
            return valeur = null;
        } else {
            return valeur.trim();
        }
    }


}
