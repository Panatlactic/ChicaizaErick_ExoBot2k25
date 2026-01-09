
import UserInterface.CEForm.CEMainForm;
import UserInterface.CEForm.CESplashScreenForm;

public class CEApp {
    public static void main(String[] args) throws Exception {
        
        try {

            CESplashScreenForm.show();
            CEMainForm ceFrmMain = new CEMainForm("CEBot");

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
