package excepciones;

public class NuevaCuentaBancariaException extends Exception{

    public NuevaCuentaBancariaException(){
        super("No se a podido crear la cuenta verifica todos los campos");
    }

}
