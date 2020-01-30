package connexion.servlet;

import connexion.form.ConnexionForm;
import insc.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Connexion extends HttpServlet {
    private static String VUE_CONNEXION = "/WEB-INF/connexion.jsp";

    private static String ATT_FORM = "form";
    private static String ATT_USER = "user";
    private static String ATT_SESSION_USER = "userSession";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm();
        Utilisateur user = new Utilisateur();

        user = form.connecterUtilisateur(req);
        /*
         * Creation de la session
         */
        HttpSession session = req.getSession();
        /*
         * Associer les attributs de la session
         */
        if(form.getErreurs().isEmpty())
        {
            session.setAttribute(ATT_SESSION_USER,user);
        } else {
            session.setAttribute(ATT_SESSION_USER,null);
        }

        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_USER,user);

        this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(req,resp);
    }
}
