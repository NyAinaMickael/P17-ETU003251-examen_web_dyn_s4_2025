package src.main.java.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.main.java.Models.BaseObject;
import src.main.java.Models.Connexion;
import src.main.java.Models.User;

public class UserDAO implements InterfaceDAO {

    @Override
    public List<User> findAll() throws Exception {
        ArrayList<User> users=new ArrayList<>();
        String query="SELECT * FROM examen_web_dyn_s4_users";
        try (Connection conn=Connexion.getConnection()) {
            Statement stmnt=conn.createStatement();
            ResultSet rs=stmnt.executeQuery(query);
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("nom"), rs.getString("mdp")));
            }
            stmnt.close();
            rs.close();
            
        } catch (Exception e) {
            throw new Exception("Erreur durant la connexion a la base dans la fonction findAll de UserDAO");
        }
        return users;
    }

    public static List<User> findByNameAndMdp(String name,String mdp) throws Exception {
        ArrayList<User> users=new ArrayList<>();
        String query="SELECT * FROM examen_web_dyn_s4_users WHERE name=? AND password=?";
        try (Connection conn=Connexion.getConnection()) {
            PreparedStatement stmnt=conn.prepareStatement(query);
            stmnt.setString(1, name);
            stmnt.setString(2, mdp);
            ResultSet rs=stmnt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password")));
            }
            stmnt.close();
            rs.close();
            
        } catch (Exception e) {
            throw new Exception("Erreur durant la connexion a la base dans la fonction findAll de UserDAO");
        }
        return users;
    }
    

    @Override
    public List<? extends BaseObject> findAll(int start_id, int nb_rows) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void save(BaseObject o) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(BaseObject o) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(BaseObject o) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public BaseObject findById(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
