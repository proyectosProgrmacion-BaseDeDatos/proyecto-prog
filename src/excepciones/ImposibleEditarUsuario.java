package excepciones;

public class ImposibleEditarUsuario extends Exception{

    public ImposibleEditarUsuario(){
        super("No se a podido editar el usuario");
    }

}
