package src.main.java.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.Services.DashboardService;

public class Accueil extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        ArrayList<HashMap<String,Object>> data=new ArrayList<>();
        try {
            data=new DashboardService().loadData();

        } catch (Exception e) {
            throw new ServletException("Probleme durant le chargement des donnees du dashboard");
        }
        req.setAttribute("data", data);
        req.getRequestDispatcher("views/dynamic/dashboard.jsp").forward(req, res);       

    }
}
