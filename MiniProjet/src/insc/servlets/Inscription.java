package insc.servlets;

import insc.beans.Utilisateur;
import insc.forms.InscriptionForm;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inscription extends HttpServlet {
    static final String ATT_USER = "user";
    static final String ATT_FORM = "form";

    final static String VUE = "/WEB-INF/inscription.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InscriptionForm form = new InscriptionForm();
        Utilisateur user = form.inscrireUtilisateur(req);
        req.setAttribute(ATT_USER,user);
        req.setAttribute(ATT_FORM,form);
        this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
    }


}
