package src.main.java.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import src.main.java.Models.DAO.UserDAO;
import src.main.java.Services.LoginService;

public class LoginServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        req.getRequestDispatcher("views/dynamic/login.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        String nom=req.getParameter("nom");
        String mdp=req.getParameter("mdp");
        try {
            LoginService loginService=new LoginService(new UserDAO());
            int idUser=loginService.checkLogin(nom,mdp);
            if(idUser>=1)
            {
                HttpSession session =req.getSession();
                session.setAttribute("id_user", idUser);
                req.getRequestDispatcher("views/dynamic/ligne_credit.jsp").forward(req, res);
            }
            else{
                res.sendRedirect(req.getContextPath()+"/back_office?err=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
