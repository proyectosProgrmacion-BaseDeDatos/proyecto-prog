package excepciones;

public class UsuarioNoExisteException extends Exception{

    public UsuarioNoExisteException(){
        super("Ese usuario no existe");
    }

}
