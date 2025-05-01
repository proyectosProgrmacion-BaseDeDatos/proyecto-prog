package excepciones;

public class PrecioJuegoException extends Exception{

    public PrecioJuegoException(){
        super("El juego no puede tener un precio negativo");
    }
}
