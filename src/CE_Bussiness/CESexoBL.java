package CE_Bussiness;

import java.util.List;

import DataAccess.CE_DAO.CESexoDAO;
import DataAccess.CE_DTO.CESexoDTO;

public class CESexoBL {
    
    private CESexoDTO ceSexoDTO;
    private CESexoDAO ceSexoDAO = new CESexoDAO();

    public CESexoBL (){}

    public List <CESexoDTO> ceGetAll() throws Exception{
        return ceSexoDAO.readAll();
    }

    public CESexoDTO ceGetByIdSexo (Integer idSexo) throws Exception {
        ceSexoDTO = ceSexoDAO.readBy(idSexo);
        return ceSexoDTO;
    }

    public boolean ceCreate (CESexoDTO ceSexoDTO) throws Exception {
        return ceSexoDAO.create(ceSexoDTO);
    }

    public boolean ceUpdate (CESexoDTO ceSexoDTO) throws Exception {
        return ceSexoDAO.update(ceSexoDTO);
    }

    public boolean ceDelete (Integer idSexo) throws Exception {
        return ceSexoDAO.delete(idSexo);
    }

    public Integer ceGetRowCount () throws Exception {
        return ceSexoDAO.getMaxReg();
    }

}
