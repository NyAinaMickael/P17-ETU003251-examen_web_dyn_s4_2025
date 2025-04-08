package src.main.java.Services;

import java.util.List;

import src.main.java.Models.User;
import src.main.java.Models.DAO.UserDAO;

public class LoginService {
    private UserDAO userDAO;

    public LoginService()
    {
    }

    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int checkLogin(String nom,String mdp) throws Exception
    {   try {
            List<User> users=UserDAO.findByNameAndMdp(nom,mdp);
            if(!users.isEmpty())
            {
                return users.get(0).getId();
            }
            return -1;
        } catch (Exception e) {
            throw new Exception("Erreur durant la verification du login");
            // TODO: handle exception
        }

    }
    
}
