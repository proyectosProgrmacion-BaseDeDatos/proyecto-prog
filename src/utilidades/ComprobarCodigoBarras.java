package utilidades;

import excepciones.CodigoDeBarraException;

public class ComprobarCodigoBarras {

    public static void verificarCodigoBarras(String codigoBarra) throws CodigoDeBarraException{

        if (codigoBarra.length() != 13) {
            throw new CodigoDeBarraException();
        }

        for (int i = 0; i < codigoBarra.length(); i++) {
            if (!Character.isDigit(codigoBarra.charAt(i))) {
                throw new CodigoDeBarraException();
            }
        }

        //!variables
        String codigoSinDc = codigoBarra.substring(0, 12);
        char digitoControl = codigoBarra.charAt(12);
    
        int suma = 0;
        boolean impar = true;
        //!

        for (int i = 0; i < codigoSinDc.length(); i++) {
            int num = Integer.parseInt(Character.toString(codigoSinDc.charAt(i)));

            if (impar) {
                suma+= num*1;
                impar = false;
            }else{
                suma += num*3;
                impar = true;
            }

        }

        //!variables
        int dc = 10-(suma%10);
        int dcEntero = Integer.parseInt(Character.toString(digitoControl));

        if (dc == 10) {
            dc = 10;
        }
        //!

        if (dcEntero != dc) {
            throw new CodigoDeBarraException();
        }





    }
}
