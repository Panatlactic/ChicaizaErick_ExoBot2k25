package CE_Infrastructure.CETools;

public abstract class CE_CMD {

    private CE_CMD() {}

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void println(String msg){
        System.out.println(CE_CMDColor.CYAN + msg + CE_CMDColor.RESET);
    } 
    public static void printlnError(String msg){
        System.out.println(CE_CMDColor.RED + msg + CE_CMDColor.RESET);
    } 
}
