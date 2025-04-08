package src.main.java.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.Models.LigneCredit;
import src.main.java.Models.DAO.LigneCreditDAO;

public class FormLigneDepenseServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        List<LigneCredit> lignesCredit=new ArrayList<>();
        try {
            lignesCredit=new LigneCreditDAO().findAll();
        } catch (Exception e) {
            throw new ServletException("Probleme durant la recherche des lignes de credit");
        }
        req.setAttribute("lignes_credit", lignesCredit);
        req.getRequestDispatcher("views/dynamic/ligne_depense.jsp").forward(req, res);
    }
}
