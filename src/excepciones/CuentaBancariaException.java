package excepciones;

public class CuentaBancariaException extends Exception{

    public CuentaBancariaException(){
        super("Introduce una cuenta bancaria correcta");
    }

}
