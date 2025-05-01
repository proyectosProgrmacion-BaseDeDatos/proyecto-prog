package modelo;
import java.time.LocalDate;

import excepciones.CamposvaciosException;
import excepciones.PrecioJuegoException;

public class Juego {

    private int idJuego;
    private String nombre;
    private String genero;
    private String empresaDesarrolladora;
    private LocalDate fechaDeLanzamiento;
    private double precio;

    public Juego(int idJuego, String nombre, String genero, String empresaDesarrolladora, LocalDate fechaDeLanzamiento, double precio) throws CamposvaciosException, PrecioJuegoException {
        
        this.setIdJuego(idJuego);
        this.setNombre(nombre);
        this.setGenero(genero);
        this.setEmpresaDesarrolladora(empresaDesarrolladora);
        this.setFechaDeLanzamiento(fechaDeLanzamiento);
        this.setPrecio(precio);

    }

    public Juego(String nombre, String genero, String empresaDesarrolladora, LocalDate fechaDeLanzamiento, double precio) throws CamposvaciosException, PrecioJuegoException {
        
        this.setIdJuego(idJuego);
        this.setNombre(nombre);
        this.setGenero(genero);
        this.setEmpresaDesarrolladora(empresaDesarrolladora);
        this.setFechaDeLanzamiento(fechaDeLanzamiento);
        this.setPrecio(precio);

    }

    //? ========= GET =========

    public int getIdJuego() {
        return idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getEmpresaDesarrolladora() {
        return empresaDesarrolladora;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    //! ========= SET =========

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }
    public void setNombre(String nombre) throws CamposvaciosException {
        if (nombre == null || nombre.length() == 0) {
            throw new CamposvaciosException();
        }
        this.nombre = nombre;
    }
    public void setGenero(String genero) throws CamposvaciosException {

        if (genero == null || genero.length() == 0) {
            throw new CamposvaciosException();
        }
        this.genero = genero;
    }
    public void setEmpresaDesarrolladora(String empresaDesarrolladora) throws CamposvaciosException {
        if (empresaDesarrolladora == null || empresaDesarrolladora.length() == 0) {
            throw new CamposvaciosException();
        }
        this.empresaDesarrolladora = empresaDesarrolladora;
    }
    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) throws CamposvaciosException {
        if (fechaDeLanzamiento == null) {
            throw new CamposvaciosException();
        }
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    public void setPrecio(double precio) throws PrecioJuegoException {
        if (precio < 0) {
            throw new PrecioJuegoException();
        }
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Juego [idJuego=" + idJuego + ", nombre=" + nombre + ", genero=" + genero + ", empresaDesarrolladora="
                + empresaDesarrolladora + ", fechaDeLanzamiento=" + fechaDeLanzamiento + ", precio=" + precio + "]";
    }
    
}



