
import CE_App.CE_DesktopApp.CE_Forms.CE_AppSplashScreen;
import CE_App.CE_DesktopApp.CE_Forms.CE_AppStart;
import CE_Infrastructure.CEAppException;
import CE_Infrastructure.CEAppMSG;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a =10;
        int b =0;
        try {
            a= a / b;
        } catch (Exception e) {
            CEAppException er = new CEAppException("Error al dividir por cero", e, null, "main(...)" );
            CEAppMSG.showError(er.getMessage());
        }
        System.out.println("Final Feliz...");

    }
}
