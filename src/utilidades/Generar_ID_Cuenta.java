package utilidades;

public class Generar_ID_Cuenta {


    public static String crear_ID_cuenta(String nombreTitular, String numeroCuenta){

        String resultado = "";

        resultado+= nombreTitular.substring(0,1).toUpperCase();
        resultado+= numeroCuenta.substring(15,20);

        
        return resultado;

    }

}
