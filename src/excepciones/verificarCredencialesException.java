package excepciones;

public class verificarCredencialesException extends Exception{

    public verificarCredencialesException(){
        super("Error al iniciar sesion verifica el usuario y la contraseña");
    }

}
