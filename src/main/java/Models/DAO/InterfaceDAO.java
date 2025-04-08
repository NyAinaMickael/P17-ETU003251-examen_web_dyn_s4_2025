package src.main.java.Models.DAO;

import java.util.List;
import src.main.java.Models.*;
public interface InterfaceDAO {
    public abstract List<? extends BaseObject> findAll() throws Exception;
    public abstract List<? extends BaseObject> findAll(int start_id,int nb_rows) throws Exception;
    public abstract void save(BaseObject o) throws Exception;
    public abstract void update(BaseObject o) throws Exception;
    public abstract void delete(BaseObject o) throws Exception;
    public abstract BaseObject findById(int id) throws Exception;
}
