package utilidades;

public class GenerarID_usuario {

   

    public static String Generar_ID_usuario(String nombre, String apellidos, String dni){
        String resultado = "";

        resultado += nombre.substring(0,1).toUpperCase();
        
        String[] arrayApellidos = apellidos.split(" ");

        resultado += arrayApellidos[0].substring(0,3).toUpperCase();
        resultado += arrayApellidos[1].substring(0,3).toUpperCase();
        resultado += dni.substring(5,8);

      
        return resultado;
    }

}
