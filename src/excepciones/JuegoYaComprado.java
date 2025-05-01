package excepciones;

public class JuegoYaComprado extends Exception{

    public JuegoYaComprado(){
        super("Ya tienes este juego");
    }

}
