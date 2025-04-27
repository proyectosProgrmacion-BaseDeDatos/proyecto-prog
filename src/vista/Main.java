package vista;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.CodigoDeBarraException;
import excepciones.DniExceptions;
import modelo.Juego;
import modelo.Usuario;
import utilidades.ComprobarCodigoBarras;

public class Main {

    public static void main(String[] args) {
        
        
        try {
            ComprobarCodigoBarras.verificarCodigoBarras("8480012007242");

            Juego j1 = new Juego("8480012007242", "Counter-Strike 2", "shooter", "Multijugador", "w11", "15$", "40 Gb", "Valve", LocalDate.now());

            System.out.println(j1);

            System.out.println();
            System.out.println();
            System.out.println();

            Usuario u1 = new Usuario("Zzelen", "123456789Lop", "12345678Z", "cristian", "Lopez Gonzalez", "callejon negro 17", "11540", "cadiz", "Sanlucar de Barrameda");

            System.out.println(u1);
        } catch (CodigoDeBarraException | CampoVacioException | DniExceptions e) {
            
            e.printStackTrace();
        }

    }

}
