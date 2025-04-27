package excepciones;

public class CampoVacioException extends Exception{

    public CampoVacioException(){
        super("Introduce todos los campos");
    }
}
