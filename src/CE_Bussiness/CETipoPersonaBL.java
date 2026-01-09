package CE_Bussiness;

import java.util.List;

import DataAccess.CE_DAO.CETipoPersonaDAO;
import DataAccess.CE_DTO.CETipoPersonaDTO;

public class CETipoPersonaBL {

    private CETipoPersonaDTO ceTipoPersonaDTO;
    private CETipoPersonaDAO ceTipoPersonaDAO = new CETipoPersonaDAO();

    public CETipoPersonaBL(){}

    public List <CETipoPersonaDTO> ceGetAll () throws Exception {
        return ceTipoPersonaDAO.readAll();
    }

    public CETipoPersonaDTO ceGetBy (Integer idReg) throws Exception {
        ceTipoPersonaDTO = ceTipoPersonaDAO.readBy(idReg);
        return ceTipoPersonaDTO;
    }

    public boolean ceCreate (CETipoPersonaDTO ceTipoPersonaDTO) throws Exception {
        return ceTipoPersonaDAO.create(ceTipoPersonaDTO);
    }

    public boolean ceUpdate (CETipoPersonaDTO ceTipoPersonaDTO) throws Exception {
        return ceTipoPersonaDAO.update(ceTipoPersonaDTO);
    }

    public boolean ceDelete (Integer idReg) throws Exception {
        return ceTipoPersonaDAO.delete(idReg);
    }

    public Integer ceGetRowCount () throws Exception {
        return ceTipoPersonaDAO.getMaxReg();
    }

}
