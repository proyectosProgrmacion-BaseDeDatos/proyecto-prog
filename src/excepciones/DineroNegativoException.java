package excepciones;

public class DineroNegativoException extends Exception{

    public DineroNegativoException(){
        super("El dinero no puede ser negativo");
    }


}
