package CE_Bussiness;

import java.util.List;

import CE_DataAccess.CE_Interfaces.ICEDAO;
import CE_Infrastructure.CEAppException;

public class CE_Factory <T> {
    private final ICEDAO<T> oDAO;

    public CE_Factory (Class<? extends ICEDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            CEAppException er = new CEAppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(<T>)");
            throw new RuntimeException(er);
        }
    }
 
    public List<T> getAll() throws CEAppException {
         return oDAO.readAll();
    }

    public T getBy(Integer id) throws CEAppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws CEAppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws CEAppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws CEAppException {
        return oDAO.delete(id);
    }

    public Integer getMaxReg() throws CEAppException{
        return oDAO.getMaxReg();
    }
}
