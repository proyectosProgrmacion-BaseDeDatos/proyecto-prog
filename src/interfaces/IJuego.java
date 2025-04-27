package interfaces;

import java.time.LocalDate;
import java.util.List;

import modelo.Juego;
import modelo.Usuario;

public interface IJuego {

    public List<Juego> ostenerTodosLosJuegos();

    public Juego nuevojuego(String codigoBarra, String tituloJuego, String genero, String modosDeJuego,
            String compatibilidad, String precio, String tamanio, String empresaDesarrolladora,LocalDate fechadeDeLanzamiento);

    public Usuario nuevoUsuario(String usuario,String password,String dni,String nombre , String apellidos , String direccion, String codigoPostal, String provincia, String localidad, String id_usuario);
    
    //?     public Juego comprarJuego(String dniero);
    
}
