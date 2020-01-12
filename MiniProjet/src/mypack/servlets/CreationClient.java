package mypack.servlets;

import mypack.beans.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nom = req.getParameter("nomClient");
        String prenom = req.getParameter("prenomClient");
        String addresse = req.getParameter("adresseClient");
        String tel = req.getParameter("telephoneClient");
        String email = req.getParameter("emailClient");
        Client newClient = new Client();
        newClient.setNom(nom);
        newClient.setPrenom(prenom);
        newClient.setEmail(email);
        newClient.setTel(tel);
        newClient.setAdresseLivraison(addresse);

        String message;
        if(nom.trim().isEmpty() || addresse.trim().isEmpty() || tel.trim().isEmpty()){
            message = "Erreur - vous n'avez pas rempli tous les champs obligatoires <br>" +
                    "<a href='/creerClient.jsp'>Cliquez-ici</a> pour revenir remplir le formulaire";

        } else {
            message = "Client créé avec succès !<br>";
        }
        req.setAttribute("message",message);


        req.setAttribute("client",newClient);


        req.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(req,resp);

    }
}
