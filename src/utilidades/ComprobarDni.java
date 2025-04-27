package utilidades;

import excepciones.DniExceptions;

public class ComprobarDni {

    public static void verificar_dni(String dni) throws DniExceptions{

        String dniParteNum = dni.substring(0, 8);
        char letraDni = dni.charAt(8);
        String letras_dni = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.length() != 9) {
            throw new DniExceptions();
        }

        for (int i = 0; i < dniParteNum.length(); i++) {
            if (!Character.isDigit(dniParteNum.charAt(i))) {
                throw new DniExceptions();
            }
        }

        if (!Character.isLetter(letraDni)) {
            throw new DniExceptions();
        }
        
        int numEntero = Integer.parseInt(dniParteNum);

        char supuestaLetra = letras_dni.charAt(numEntero%23);

        if (supuestaLetra != letraDni) {
            throw new DniExceptions();
        }

    


    }

}
