package CE_DataAccess.CEHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class CEDataHelperSQLite {
    private static final String DBPathConnection = "jdbc:sqlite:CE_db//CE_EXOBOT.sqlite"; 
    private static Connection CEconn = null;
    
    private DateTimeFormatter   CEdtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    private LocalDateTime       CEnow = LocalDateTime.now();

    protected CEDataHelperSQLite(){}
    protected static synchronized Connection openConnection() throws SQLException{
        try {
            if(CEconn == null)
                CEconn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e; //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return CEconn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (CEconn != null)
                CEconn.close();
        } catch (Exception e) {
            throw e;//new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }

    protected String getDataTimeNow() {
        return CEdtf.format(CEnow).toString();
    }
    
}
