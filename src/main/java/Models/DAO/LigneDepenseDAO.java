package src.main.java.Models.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.main.java.Models.BaseObject;
import src.main.java.Models.Connexion;
import src.main.java.Models.LigneDepense;

public class LigneDepenseDAO implements InterfaceDAO {
    @Override
    public List<LigneDepense> findAll() throws Exception {
        try (Connection conn=Connexion.getConnection()) {
            ArrayList<LigneDepense> lignesDepenses=new ArrayList<>();
            String query="SELECT * FROM examen_web_dyn_s4_ligne_depense";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                try (ResultSet rs=ps.executeQuery()) {
                    while(rs.next())
                    {
                        lignesDepenses.add(new LigneDepense(rs.getInt("id"),rs.getInt("id_ligne_credit"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return lignesDepenses;

        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }

    }

    @Override
    public List<LigneDepense> findAll(int start_id,int nb_rows) throws Exception {
        try (Connection conn=Connexion.getConnection()) {
            ArrayList<LigneDepense> lignesDepenses=new ArrayList<>();
            String query="SELECT * FROM examen_web_dyn_s4_ligne_depense WHERE id BETWEEN ? AND ?";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1, start_id);
                ps.setInt(2, start_id+nb_rows);
                try (ResultSet rs=ps.executeQuery()) {
                    while(rs.next())
                    {
                        lignesDepenses.add(new LigneDepense(rs.getInt("id"),rs.getInt("id_ligne_credit"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return lignesDepenses;
        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }

    }


    @Override
    public void save(BaseObject o) throws Exception {
        try {
            LigneDepense ligneDepense=(LigneDepense) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="INSERT INTO examen_web_dyn_s4_ligne_depense(id_ligne_credit,montant) VALUES (?,?)";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setInt(1, ligneDepense.getId_ligne_credit());
                    ps.setFloat(2, ligneDepense.getMontant());
                    ps.executeUpdate();
                }
            }    
        } catch (Exception e) {
            throw new Exception("Type de variable non supporte  ");
        }        
    }

    @Override
    public void update(BaseObject o) throws Exception {
        try {
            LigneDepense ligneDepense=(LigneDepense) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="UPDATE examen_web_dyn_s4_ligne_depense SET id_ligne_credit=?, montant=? WHERE id=? ";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setInt(1, ligneDepense.getId_ligne_credit());
                    ps.setFloat(2, ligneDepense.getMontant());
                    ps.setInt(3, ligneDepense.getId());
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
            LigneDepense ligneDepense=(LigneDepense) o;
            try (Connection conn=Connexion.getConnection()) {   
                String query="DELETE FROM examen_web_dyn_s4_ligne_depense WHERE id=? ";
                try (PreparedStatement ps=conn.prepareStatement(query)) {
                    ps.setInt(1, ligneDepense.getId());
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
            LigneDepense ligneDepense=null;
            String query="SELECT * FROM examen_web_dyn_s4_ligne_depense WHERE id=?";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs=ps.executeQuery()) {
                    if(rs.next())
                    {
                        ligneDepense=(new LigneDepense(rs.getInt("id"),rs.getInt("id_ligne_credit"),rs.getFloat("montant")));
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }
            return ligneDepense;

        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }
    }

    public float getDepensesLigneCredit(int id_ligne_credit) throws Exception
    {
        try (Connection conn=Connexion.getConnection()) {
            String query="SELECT SUM(montant) as total FROM examen_web_dyn_s4_ligne_depense WHERE id_ligne_credit=?";
            try (PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1, id_ligne_credit);
                try (ResultSet rs=ps.executeQuery()) {
                    if(rs.next())
                    {   
                        return rs.getFloat("total");
                    }
                    else{
                        return 0;
                    }
                } catch (Exception e) {
                    throw new Exception("Erreur lors de l'execution de la requete");
                }
                
            } catch (Exception e) {
                throw new Exception("Erreur lors de la preparation  de la requete");
            }

        } catch (Exception e) {
            throw new Exception("Connexion a la base impossible");
        }

    }
}
