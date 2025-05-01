package servicio;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import repositorio.JuegoRepositorio;
import excepciones.CamposvaciosException;
import excepciones.CrearJuegoException;
import excepciones.EliminarJuegoExceotion;
import excepciones.PrecioJuegoException;
import interfaces.IJuegos;
import modelo.Juego;

public class JuegoServicio implements IJuegos{
JuegoRepositorio jr = new JuegoRepositorio();

    @Override
    public List<Juego> obtenerTodosJuegos() throws SQLException, CamposvaciosException, PrecioJuegoException {

        return jr.obtenerTodosJuegos();
    }

    @Override
    public void eliminarJuego(int id) throws SQLException, EliminarJuegoExceotion {
        int rows = 0;
        rows = jr.eliminarJuego(id);

        if (rows > 0) {
            System.out.println("Juego eliminado correctamente");
        }else{
            throw new EliminarJuegoExceotion();
        }
        
    }

    @Override
    public void crearJuego(String nombre, String genero,String empresaDesarrolladora,LocalDate fechaLanzamineto,double precio) throws SQLException, CrearJuegoException {

        int rows = 0;

        rows = jr.crearJuego(nombre, genero, empresaDesarrolladora, fechaLanzamineto, precio);

        if (rows > 0) {
            System.out.println("El juego se a creado correctamente");
            
        }else{
            throw new CrearJuegoException();
        }
        
    }

    

}
