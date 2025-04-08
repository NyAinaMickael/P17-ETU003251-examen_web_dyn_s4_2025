package src.main.java.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import src.main.java.Models.LigneCredit;
import src.main.java.Models.DAO.LigneCreditDAO;
import src.main.java.Models.DAO.LigneDepenseDAO;

public class DashboardService {
    private LigneCreditDAO ligneCreditDAO;
    private LigneDepenseDAO ligneDepenseDAO;

    public DashboardService()
    {
        this.ligneCreditDAO=new LigneCreditDAO();
        this.ligneDepenseDAO=new LigneDepenseDAO();
    }

    public ArrayList<HashMap<String,Object>> loadData() throws Exception
    {   
        List<LigneCredit> ligneCredits=ligneCreditDAO.findAll();
        ArrayList<HashMap<String,Object>> data=new ArrayList<>();
        for(LigneCredit ligneCredit:ligneCredits)
        {
            float depenses=ligneDepenseDAO.getDepensesLigneCredit(ligneCredit.getId());
            float budget=ligneCredit.getMontant();
            HashMap<String,Object> ligne=new HashMap<>();
            ligne.put("libelle",ligneCredit.getLibelle());
            ligne.put("depenses",depenses);
            ligne.put("reste",budget-depenses);
            data.add(ligne);
        }
        return data;
    } 
}
