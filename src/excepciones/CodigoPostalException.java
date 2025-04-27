package excepciones;

public class CodigoPostalException extends Exception{

    public CodigoPostalException (){
        super("Introduce correctamente el codigo postal");
    }

}
