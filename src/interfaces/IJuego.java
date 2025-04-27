package interfaces;

import java.time.LocalDate;
import java.util.List;


import modelo.Juego;


public interface IJuego {

    public List<Juego> ostenerTodosLosJuegos();

    public Juego nuevojuego(String codigoBarra, String tituloJuego, String genero, String modosDeJuego,String compatibilidad, String precio, String tamanio, String empresaDesarrolladora,LocalDate fechadeDeLanzamiento );
    
    
}
