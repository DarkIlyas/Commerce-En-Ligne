package mypack.servlets;

import mypack.beans.Client;
import mypack.forms.ClientForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationClient extends HttpServlet {
    static final String ATT_FORM = "form";
    static final String ATT_CLIENT = "client";

    static final String VUE_CREATION = "/WEB-INF/creerClient.jsp";
    static final String VUE_AFFICHAGE = "/WEB-INF/afficherClient.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientForm form = new ClientForm();
        Client client = form.creerClient(req);
        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_CLIENT,client);

        if(!form.getErreurs().isEmpty()){
            req.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
        }else {
            req.getServletContext().getRequestDispatcher(VUE_AFFICHAGE).forward(req,resp);
        }


    }
}
