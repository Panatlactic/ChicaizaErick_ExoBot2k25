package CEFramework;

public class ECException extends Exception {

    public ECException (String e, String clase, String metodo){
        System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + "." + e);
    }

    @Override
    public String getMessage (){
        return "No seas chimoso...";
    }
    
}
