package excepciones;

public class JuegoNoExisteException extends Exception{

    public JuegoNoExisteException(){
        super("El juego no existe");
    }

}
