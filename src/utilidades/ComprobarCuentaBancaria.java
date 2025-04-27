package utilidades;

import excepciones.CuentaBancariaException;

public class ComprobarCuentaBancaria {

    public static void verificarCeuntaBancaria(String numeroCuenta) throws CuentaBancariaException {

        if (numeroCuenta.length() != 20) {
            throw new CuentaBancariaException();
        }

        for (int i = 0; i < numeroCuenta.length(); i++) {
            if (!Character.isDigit(numeroCuenta.charAt(i))) {
                throw new CuentaBancariaException();
            }
        }
        // partes del dijito control
        String numeroControlDc = numeroCuenta.substring(8, 10);

        // partes de la cuenta
        String parteEntidadSucursal = numeroCuenta.substring(0, 8);
        String parteNumCuenta = numeroCuenta.substring(10, 20);

        // numeros apra multiplicar
        int[] arrayNumeros1 = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };
        int[] arrayNumeros2 = { 4, 8, 5, 10, 9, 7, 3, 6 };

        // multiplicaciones
        int multiNumCuenta = 0;
        int multiEntidadSucursal = 0;

        // multiplicar numeros cuenta
        for (int i = 0; i < arrayNumeros1.length; i++) {
            int num = Integer.parseInt(Character.toString(parteNumCuenta.charAt(i)));

            multiNumCuenta += num * arrayNumeros1[i];

        }
        // multiplicar numeros sucursar entidad
        for (int i = 0; i < arrayNumeros2.length; i++) {
            int num = Integer.parseInt(Character.toString(parteEntidadSucursal.charAt(i)));

            multiEntidadSucursal += num * arrayNumeros2[i];

        }
        
        int digitoControl1 = 11-(multiEntidadSucursal%11);
        int digitoControl2 = 11-(multiNumCuenta%11);
        
        
        if (digitoControl1 == 10) {
            digitoControl1 = 1;
        }

        if (digitoControl1 == 11) {
            digitoControl1 = 0;
        }

        if (digitoControl2 == 10) {
            digitoControl2 = 1;
        }

        if (digitoControl2 == 11) {
            digitoControl2 = 0;
        }
        // comprobaciones
        String numStr1 = digitoControl1+"" ;
        String numStr2 = digitoControl2 +"";
        String resultado = numStr1 + numStr2;
        

        if (!resultado.equals(numeroControlDc) ) {
            throw new CuentaBancariaException();
        }

        


        

        

    }

}
