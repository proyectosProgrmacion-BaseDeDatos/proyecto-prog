package vista;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.CodigoDeBarraException;
import excepciones.CodigoPostalException;
import excepciones.CuentaBancariaException;
import excepciones.DniExceptions;
import modelo.CuentaBancaria;
import modelo.Juego;
import modelo.Usuario;

public class Main {

    public static void main(String[] args) {
        
        
        try {
            

            Juego j1 = new Juego("730", "Counter-Strike 2", "shooter", "Multijugador", "w11", "15$", "40 Gb", "Valve", LocalDate.now());

            System.out.println(j1);

            System.out.println();
            System.out.println();
            System.out.println();

            CuentaBancaria c1 = new CuentaBancaria("cristian", "14320154497422504551", 2000.00);
            CuentaBancaria c2 = new CuentaBancaria("Alejandro", "98765432871029384756", 120.00);
            CuentaBancaria c3 = new CuentaBancaria("Vicente", "12345678061234567890", 1500.00);
            CuentaBancaria c4 = new CuentaBancaria("Nacho", "22223333319876543210", 200.00);
            CuentaBancaria c5 = new CuentaBancaria("Diego", "11112222001357913579", 1200.00);
            CuentaBancaria c6 = new CuentaBancaria("Jesus", "00010002092468246824", 500.00);
            
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);

            System.out.println();
            System.out.println();
            System.out.println();

            
            Usuario u1 = new Usuario("Zzelen", "123456789Lop", "12345678Z", "cristian", "Lopez Gonzalez", "callejon negro 17", "11540", "cadiz", "Sanlucar de Barrameda", c1);
            Usuario u2 = new Usuario("Futher", "pLZXnm", "12345678Z", "Diego", "Cancela Caro", "Avenida de chipiona N54", "11560", "cadiz", "trebujena", c2);
            Usuario u3 = new Usuario("Maniatic16", "yHEUKP", "12345678Z", "Vicente", "Garcia Sanchez", "Avenida de godoy N20", "11540", "cadiz", "Sanlucar de Barrameda", c3);
            Usuario u4 = new Usuario("Nachoelprime", "pJZYXf", "12345678Z", "Nacho", "Rivas Cardenas", "Calle san agustin N5", "11540", "cadiz", "Sanlucar de Barrameda", c4);
            Usuario u5 = new Usuario("ikazy", "EjnUAL", "12345678Z", "Alejandro", "Parrado Alvarez", "Calle montero N18", "11540", "cadiz", "Sanlucar de Barrameda", c5);
            Usuario u6 = new Usuario("jealmu", "HDDcDz", "12345678Z", "Jesus", "Alcocer Rodriguez", "calle cartajenera N12", "11401", "cadiz", "Jerez de la frontera", c6);
            
            System.out.println(u1);
            System.out.println(u2);
            System.out.println(u3);
            System.out.println(u4);
            System.out.println(u5);
            System.out.println(u6);




        } catch ( CampoVacioException | DniExceptions | CodigoPostalException | CuentaBancariaException  e) {
            
            e.printStackTrace();
        }

    }

}
