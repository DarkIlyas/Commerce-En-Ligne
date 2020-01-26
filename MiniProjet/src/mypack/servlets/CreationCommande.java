package mypack.servlets;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mypack.beans.Client;
import mypack.beans.Commande;
import mypack.forms.CommandeForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreationCommande extends HttpServlet {
    static final String VUE_AFFICHAGE = "/WEB-INF/afficherCommande.jsp";
    static final String VUE_CREATION = "/WEB-INF/creerCommande.jsp";

    static final String ATT_COMMANDE = "commande";
    static final String ATT_FORM = "form";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommandeForm form = new CommandeForm();
        Commande commande = form.creerCommande(req);

        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_COMMANDE,commande);
        if(form.getErreurs().isEmpty()){
            this.getServletContext().getRequestDispatcher(VUE_AFFICHAGE).forward(req,resp);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
        }



    }
}
