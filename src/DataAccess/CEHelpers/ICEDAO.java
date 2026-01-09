package DataAccess.CEHelpers;

import java.util.List;

public interface ICEDAO<T> {  // obligatorio implementar los metodos CRUD en los DAO
    T       readBy(Integer id)  throws Exception;
    List<T> readAll()           throws Exception;
    boolean create(T entity)    throws Exception;
    boolean update(T entity)    throws Exception;
    boolean delete(Integer id)  throws Exception;
    Integer getMaxReg()         throws Exception;   
}
