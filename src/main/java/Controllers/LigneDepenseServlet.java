package src.main.java.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.Models.LigneCredit;
import src.main.java.Models.LigneDepense;
import src.main.java.Models.DAO.LigneCreditDAO;
import src.main.java.Models.DAO.LigneDepenseDAO;

public class LigneDepenseServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        if(req.getParameter("id")==null)
        {
            //Manao insert
            int id_ligne_credit=Integer.parseInt(req.getParameter("id_ligne_credit"));
            float montant=Integer.parseInt(req.getParameter("montant"));
            try {   
                LigneCreditDAO ligneCreditDAO=new LigneCreditDAO();
                LigneDepenseDAO ligneDepenseDAO=new LigneDepenseDAO();
                LigneCredit ligneCredit=(LigneCredit) ligneCreditDAO.findById(id_ligne_credit);
                if(ligneCredit.getMontant()>ligneDepenseDAO.getDepensesLigneCredit(id_ligne_credit)+montant)
                {
                    ligneDepenseDAO.save(new LigneDepense(id_ligne_credit, montant));
                    res.sendRedirect(req.getContextPath()+"/form_ligne_depense");
                }
                else{
                    res.sendRedirect(req.getContextPath()+"/form_ligne_depense?err=1");
                }
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
