package src.main.java.Models;

public class User extends BaseObject{
    private String nom;
    private String mdp;



    public User(int id,String nom, String mdp) {
        super.setId(id);
        this.nom = nom;
        this.mdp = mdp;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}
