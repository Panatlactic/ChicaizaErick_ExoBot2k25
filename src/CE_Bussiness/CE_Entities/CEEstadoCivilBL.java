package CE_Bussiness.CE_Entities;

import java.util.List;

import CE_DataAccess.CE_DAO.CEEstadoCivilDAO;
import CE_DataAccess.CE_DTO.CEEstadoCivilDTO;

public class CEEstadoCivilBL {

    private CEEstadoCivilDTO ceEstadoCivilDTO;
    private CEEstadoCivilDAO ceEstadoCivilDAO = new CEEstadoCivilDAO();

    public CEEstadoCivilBL(){}

    public List <CEEstadoCivilDTO> ceGetAll () throws Exception {
        return ceEstadoCivilDAO.readAll();
    }

    public CEEstadoCivilDTO ceGetBy (Integer idReg) throws Exception {
        ceEstadoCivilDTO = ceEstadoCivilDAO.readBy(idReg);
        return ceEstadoCivilDTO;
    }

    public boolean ceCreate (CEEstadoCivilDTO ceEstadoCivilDTO) throws Exception {
        return ceEstadoCivilDAO.create(ceEstadoCivilDTO);
    }

    public boolean ceUpdate (CEEstadoCivilDTO ceEstadoCivilDTO) throws Exception {
        return ceEstadoCivilDAO.update(ceEstadoCivilDTO);
    }

    public boolean ceDelete (Integer idReg) throws Exception {
        return ceEstadoCivilDAO.delete(idReg);
    }

    public Integer ceGetRowCount () throws Exception {
        return ceEstadoCivilDAO.getMaxReg();
    }

}
