package src.main.java.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.main.java.Models.BaseObject;
import src.main.java.Models.Connexion;
import src.main.java.Models.LigneCredit;

public class LigneCreditDAO implements InterfaceDAO{

    @Override
    public List<LigneCredit> findAll() throws Exception {
        try (Connection conn=Connexion.getConnection()) {
            ArrayList<LigneCredit> lignesCredit=new ArrayList<>();
            String query="SELECT * FROM examen_web_dyn_s4_ligne_credit";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                try (ResultSet rs=ps.executeQuery()) {
                    while(rs.next())
                    {
                        lignesCredit.add(new LigneCredit(rs.getInt("id"),rs.getString("libelle"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return lignesCredit;

        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }

    }

    @Override
    public List<LigneCredit> findAll(int start_id,int nb_rows) throws Exception {
        try (Connection conn=Connexion.getConnection()) {
            ArrayList<LigneCredit> lignesCredit=new ArrayList<>();
            String query="SELECT * FROM examen_web_dyn_s4_ligne_credit WHERE id BETWEEN ? AND ?";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1, start_id);
                ps.setInt(2, start_id+nb_rows);
                try (ResultSet rs=ps.executeQuery()) {
                    while(rs.next())
                    {
                        lignesCredit.add(new LigneCredit(rs.getInt("id"),rs.getString("libelle"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return lignesCredit;
        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }

    }


    @Override
    public void save(BaseObject o) throws Exception {
        try {
            LigneCredit ligneCredit=(LigneCredit) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="INSERT INTO examen_web_dyn_s4_ligne_credit(libelle,montant) VALUES (?,?)";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setString(1, ligneCredit.getLibelle());
                    ps.setFloat(2, ligneCredit.getMontant());
                    ps.executeUpdate();
                }
                catch(Exception e)
                {
                    throw new Exception("Probleme durant l'execution de la requete");
                }
            }    
        } catch (Exception e) {
            throw new Exception("Type de variable non supporte  ");
        }        
    }

    @Override
    public void update(BaseObject o) throws Exception {
        try {
            LigneCredit ligneCredit=(LigneCredit) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="UPDATE examen_web_dyn_s4_ligne_credit SET libelle=?, montant=? WHERE id=? ";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setString(1, ligneCredit.getLibelle());
                    ps.setFloat(2, ligneCredit.getMontant());
                    ps.setInt(3, ligneCredit.getId());
                    ps.executeUpdate();
                }
            }    
        } catch (Exception e) {
            throw new Exception("Type de variable non supporte  ");
        }  
    }

    @Override
    public void delete(BaseObject o) throws Exception {
        try {
            LigneCredit ligneCredit=(LigneCredit) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="DELETE FROM examen_web_dyn_s4_ligne_credit WHERE id=? ";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setInt(1, ligneCredit.getId());
                    ps.executeUpdate();
                }
            }    
        } catch (Exception e) {
            throw new Exception("Type de variable non supporte  ");
        }  
    }

    @Override
    public BaseObject findById(int id) throws Exception {
        try (Connection conn=Connexion.getConnection()) {
            LigneCredit ligneCredit=null;
            String query="SELECT * FROM examen_web_dyn_s4_ligne_credit WHERE id=?";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs=ps.executeQuery()) {
                    if(rs.next())
                    {
                        ligneCredit=(new LigneCredit(rs.getInt("id"),rs.getString("libelle"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return ligneCredit;

        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }
    }

}
