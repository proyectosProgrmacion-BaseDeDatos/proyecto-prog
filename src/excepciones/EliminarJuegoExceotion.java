package excepciones;

public class EliminarJuegoExceotion extends Exception{

    public EliminarJuegoExceotion(){
        super("Error al eliminar el juego por que esa id no existe");
    }

}
