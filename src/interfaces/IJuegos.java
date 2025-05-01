package interfaces;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import excepciones.CamposvaciosException;
import excepciones.CrearJuegoException;
import excepciones.EliminarJuegoExceotion;
import excepciones.PrecioJuegoException;
import modelo.Juego;

public interface IJuegos {

    List<Juego> obtenerTodosJuegos() throws SQLException, CamposvaciosException, PrecioJuegoException;
    void eliminarJuego(int id) throws SQLException, EliminarJuegoExceotion;
    void crearJuego(String nombre, String genero,String empresaDesarrolladora,LocalDate fechaLanzamineto,double precio) throws SQLException, CrearJuegoException;

}
