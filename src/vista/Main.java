package vista;

import java.time.LocalDate;

import repositorio.JuegoRepositorio;
import repositorio.UsuarioRepositorio;
import servicio.CuentaBanServicio;
import servicio.JuegoServicio;
import servicio.UsuarioServicio;
import modelo.Juego;
import modelo.Usuario;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        try {

            UsuarioServicio us = new UsuarioServicio();
            CuentaBanServicio cs = new CuentaBanServicio();
            JuegoServicio js = new JuegoServicio();


            for (Usuario u : us.obtenerTodoUsuario()) {
                System.out.println(u);
            }

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            for (Juego j : js.obtenerTodosJuegos() ) {
                System.out.println(j);
            }

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            us.verificarCredenciales("Zzelen", "trebujena");
            
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            
            
            
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }

}