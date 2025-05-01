package excepciones;

public class CuentaBancariaException extends Exception{

    public CuentaBancariaException(){
        super("Intorduce un numero de cuenta correcto");
    }
}
