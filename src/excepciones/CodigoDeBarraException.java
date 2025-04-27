package excepciones;

public class CodigoDeBarraException extends Exception{
    public CodigoDeBarraException(){
        super("Intorduce un codigo de barras correcto");
    }
}
