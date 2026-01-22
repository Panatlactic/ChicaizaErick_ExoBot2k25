package CE_Infrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import CE_Infrastructure.CETools.CE_CMDColor;

public class CEAppException extends Exception {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public CEAppException(String showMsg) {
        super((showMsg== null || showMsg.isBlank()) ? CEAppConfig.MSG_DEFAULT_ERROR   : showMsg);
        saveLogFile(null, null, null);
    }
    public CEAppException(String showMsg, Exception e, Class<?> clase, String metodo) {
        super((showMsg== null || showMsg.isBlank()) ? CEAppConfig.MSG_DEFAULT_ERROR   : showMsg);
        saveLogFile(e.getMessage(), clase, metodo);
    }
    private void saveLogFile(String logMsg, Class<?> clase, String metodo) {
        String timestamp  = LocalDateTime.now().format(FORMATTER);
        String className  = (clase  == null) ? CEAppConfig.MSG_DEFAULT_CLASS          : clase.getSimpleName();
        String methodName = (metodo == null) ? CEAppConfig.MSG_DEFAULT_METHOD         : metodo;
        logMsg = (logMsg == null || logMsg.isBlank()) ? CEAppConfig.MSG_DEFAULT_ERROR : logMsg;
        logMsg = String.format("╭─💀─ SHOW ❱❱ %s \n╰──── LOG  ❱❱ %s | %s.%s | %s", getMessage(), timestamp, className, methodName, logMsg);

        try {
            String logFilePath = CEAppConfig.getLOGFILE();
            
            // Validar que la ruta del archivo no sea nula
            if (logFilePath == null || logFilePath.isBlank()) {
                System.err.println(CE_CMDColor.RED + "[AppException.saveLogFile] ❱ Ruta del archivo de logs no configurada");
                System.err.println(CE_CMDColor.BLUE + logMsg);
                return;
            }
            
            // Normalizar la ruta (convertir backslashes a forward slashes)
            logFilePath = logFilePath.replace("\\", java.io.File.separator);
            
            // Crear el archivo si no existe y escribir
            try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
                System.err.println(CE_CMDColor.BLUE + logMsg);
                writer.println(logMsg);
                writer.flush();
            }
        } catch (Exception e) {
            System.err.println(CE_CMDColor.RED + "[AppException.saveLogFile] ❱ Error al escribir log: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println(CE_CMDColor.RESET);
        }
    }
}