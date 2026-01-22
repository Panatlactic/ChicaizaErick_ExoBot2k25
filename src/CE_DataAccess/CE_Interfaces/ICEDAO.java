package CE_DataAccess.CE_Interfaces;

import java.util.List;

import CE_Infrastructure.CEAppException;

public interface ICEDAO<T> {  
    T       readBy(Integer id)  throws CEAppException;
    List<T> readAll()           throws CEAppException;
    boolean create(T entity)    throws CEAppException;
    boolean update(T entity)    throws CEAppException;
    boolean delete(Integer id)  throws CEAppException;
    Integer getMaxReg()         throws CEAppException;   
}
