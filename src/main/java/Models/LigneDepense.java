package src.main.java.Models;

import java.sql.Date;

public class LigneDepense  extends BaseObject{
    private int id_ligne_credit;
    private float montant;
    private Date date_insertion;

    
    public LigneDepense(int id,int id_ligne_credit, float montant) {
        super();
        super.setId(id);
        this.id_ligne_credit = id_ligne_credit;
        this.montant = montant;
    }

    public LigneDepense(int id_ligne_credit, float montant) {
        super();
        this.id_ligne_credit = id_ligne_credit;
        this.montant = montant;
    }

    public LigneDepense(int id_ligne_credit, float montant, Date date_insertion) {
        super();
        this.id_ligne_credit = id_ligne_credit;
        this.montant = montant;
        this.date_insertion = date_insertion;
    }

    public LigneDepense(int id,int id_ligne_credit, float montant, Date date_insertion) {
        super();
        super.setId(id_ligne_credit);
        this.id_ligne_credit = id_ligne_credit;
        this.montant = montant;
        this.date_insertion = date_insertion;
    }


    public int getId_ligne_credit() {
        return id_ligne_credit;
    }
    public void setId_ligne_credit(int id_ligne_credit) {
        this.id_ligne_credit = id_ligne_credit;
    }
    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        this.montant = montant;
    }
    public Date getDate_insertion() {
        return date_insertion;
    }
    public void setDate_insertion(Date date_insertion) {
        this.date_insertion = date_insertion;
    }
    
}
