package excepciones;

public class CuentaBancariaYaExisteException extends Exception{

    public CuentaBancariaYaExisteException(){
        super("Esa cuenta ya existe");
    }

}
