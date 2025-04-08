package src.main.java.Models;

public class LigneCredit extends BaseObject{
    private String libelle;
    private float montant;

    public LigneCredit(String libelle, float montant) {
        super();
        this.libelle = libelle;
        this.montant = montant;
    }

    public LigneCredit(int id,String libelle, float montant) {
        super();
        super.setId(id);
        this.libelle = libelle;
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "LigneCredit [libelle=" + libelle + ", montant=" + montant + "]";
    }
    
    
    
}
