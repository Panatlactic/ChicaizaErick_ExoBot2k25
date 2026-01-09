package DataAccess.CE_DAO;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CEFramework.ECException;
import DataAccess.CEHelpers.CEDataHelperSQLite;
import DataAccess.CEHelpers.ICEDAO;
import DataAccess.CE_DTO.CESexoDTO;

public class CESexoDAO extends CEDataHelperSQLite implements ICEDAO <CESexoDTO>{

    @Override
    public CESexoDTO readBy(Integer id) throws Exception {

        CESexoDTO s = new CESexoDTO();
        String query = " SELECT IdCatalogo "
                     + ", IdCatalogoTipo "
                     + ", Nombre "
                     + ", Descripcion "
                     + ", Estado "
                     + ", FechaCreacion "
                     + ", FechaModifica"
                     + " FROM Catalogo "
                     + " WHERE Estado = 'A' "
                     + " AND IdCatalogoTipo = 2"
                     + " AND IdCatalogo = " + id.toString();

        try {
            
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                s = new CESexoDTO(rs.getInt(1),       // IdCatalogo
                                rs.getInt(2),       // IdCatalogoTipo
                                rs.getString(3),    // Nombre
                                rs.getString(4),    // Descripcion
                                rs.getString(5),    // Estado
                                rs.getString(6),    // FechaCreacion
                                rs.getString(7));   // FechaModifica
            }

        } catch (SQLException e) {
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }

        return s;
        
    }

    @Override
    public List<CESexoDTO> readAll() throws Exception {
         
        List <CESexoDTO> lst = new ArrayList<>();
        String query = " SELECT IdCatalogo "
                     + ", IdCatalogoTipo "
                     + ", Nombre "
                     + ", Descripcion "
                     + ", Estado "
                     + ", FechaCreacion "
                     + ", FechaModifica"
                     + " FROM Catalogo "
                     + " WHERE Estado = 'A' "
                     + " AND IdCatalogoTipo = 2";

        try {
            
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                CESexoDTO s = new CESexoDTO(rs.getInt(1),       // IdCatalogo
                                        rs.getInt(2),       // IdCatalogoTipo
                                        rs.getString(3),    // Nombre
                                        rs.getString(4),    // Descripcion
                                        rs.getString(5),    // Estado
                                        rs.getString(6),    // FechaCreacion
                                        rs.getString(7));   // FechaModifica

                lst.add(s);
            }

        } catch (SQLException e) {
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }

        return lst;

    }

    @Override
    public boolean create(CESexoDTO entity) throws Exception {
        // (2, 'Masculino', 'tipos de sexualida'),
        String query = " INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES (?, ?, ?) ";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getCENombre());
            pstmt.setString(3, entity.getCEDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }

    }

    @Override
    public boolean update(CESexoDTO entity) throws Exception {
         
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM--dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {

            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCENombre());
            pstmt.setString(2, entity.getCEDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getCEIdCatalogo());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }

    }

    @Override
    public boolean delete(Integer id) throws Exception {

        String query = "UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }
         
    }

    @Override
    public Integer getMaxReg() throws Exception {
        
        String query = " SELECT COUNT(*) TotalReg "
                     + " FROM Catalogo "
                     + " WHERE Estado = 'A' "
                     + " AND IdCatalogoTipo = 2";
        
        try {

            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw new ECException(e.getMessage(), getClass().getName(), "create()");
        }

        return 0;
    }
    
}
