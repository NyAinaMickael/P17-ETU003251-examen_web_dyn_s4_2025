package src.main.java.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.Models.LigneCredit;
import src.main.java.Models.DAO.LigneCreditDAO;

public class LigneCreditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        if(req.getParameter("id")==null)
        {
            //Manao insert
            String libelle=req.getParameter("libelle");
            float montant=Integer.parseInt(req.getParameter("montant"));
            try {   
                new LigneCreditDAO().save(new LigneCredit(libelle, montant));
                res.sendRedirect(req.getContextPath()+"/form_ligne_credit");
            } catch (Exception e) {
                throw new ServletException("Erreur lors de l'insertion de la ligne de credit");
            }
        }
        else{
            //Manao update
        }
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        if(req.getParameter("id")==null)
        {
            //Mamerina liste
        }
        else{
            //Manao delete
        }
    }
}
