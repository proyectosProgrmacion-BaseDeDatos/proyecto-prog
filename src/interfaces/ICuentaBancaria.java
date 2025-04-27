package interfaces;

import modelo.Juego;
import modelo.Usuario;

public interface ICuentaBancaria {

    public Juego comprarJuego(Usuario us1);

    public int ingresarDinero(int dinero);

}
