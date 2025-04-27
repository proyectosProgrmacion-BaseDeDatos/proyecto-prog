package modelo;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.CodigoDeBarraException;


public class Juego {
    private String ID_juego,tituloJuego,genero,modosDeJuego,compatibilidad,precio,tamanio,empresaDesarrolladora;
    private LocalDate fechadeDeLanzamiento;
    
    
    public Juego(String ID_juego, String tituloJuego, String genero, String modosDeJuego, String compatibilidad,
            String precio, String tamanio, String empresaDesarrolladora, LocalDate fechadeDeLanzamiento) throws CampoVacioException {
        
        this.setID_juego(modosDeJuego);
        this.setTituloJuego(tituloJuego);
        this.setGenero(genero);
        this.setModosDeJuego(modosDeJuego);
        this.setCompatibilidad(compatibilidad);
        this.setPrecio(precio);
        this.setTamanio(tamanio);
        this.setEmpresaDesarrolladora(empresaDesarrolladora);
        this.setFechadeDeLanzamiento(fechadeDeLanzamiento);
    }

    
    //! ================  GET  ================
    
    public String getID_juego() {
        return ID_juego;
    }

    public String getTituloJuego() {
        return tituloJuego;
    }

    public String getGenero() {
        return genero;
    }

    public String getModosDeJuego() {
        return modosDeJuego;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getEmpresaDesarrolladora() {
        return empresaDesarrolladora;
    }

    public LocalDate getFechadeDeLanzamiento() {
        return fechadeDeLanzamiento;
    }


    //? ================  SET  ================

    

    public void setTituloJuego(String tituloJuego) throws CampoVacioException {
        if (tituloJuego == null || tituloJuego.length() == 0) {
            throw new CampoVacioException();
        }
        this.tituloJuego = tituloJuego;
    }

    public void setGenero(String genero) throws CampoVacioException {
        if (genero == null || genero.length() == 0) {
            throw new CampoVacioException();
        }
        this.genero = genero;
    }

    public void setModosDeJuego(String modosDeJuego) throws CampoVacioException {
        if (modosDeJuego == null || modosDeJuego.length() == 0) {
            throw new CampoVacioException();
        }
        this.modosDeJuego = modosDeJuego;
    }

    public void setCompatibilidad(String compatibilidad) throws CampoVacioException {
        if (compatibilidad == null || compatibilidad.length() == 0) {
            throw new CampoVacioException();
        }
        this.compatibilidad = compatibilidad;
    }

    public void setPrecio(String precio) throws CampoVacioException {
        if (precio == null || precio.length() == 0) {
            throw new CampoVacioException();
        }
        this.precio = precio;
    }

    public void setTamanio(String tamanio) throws CampoVacioException {
        if (tamanio == null || tamanio.length() == 0) {
            throw new CampoVacioException();
        }
        this.tamanio = tamanio;
    }

    public void setEmpresaDesarrolladora(String empresaDesarrolladora) throws CampoVacioException {
        if (empresaDesarrolladora == null || empresaDesarrolladora.length() == 0) {
            throw new CampoVacioException();
        }
        this.empresaDesarrolladora = empresaDesarrolladora;
    }

    public void setFechadeDeLanzamiento(LocalDate fechadeDeLanzamiento) throws CampoVacioException {
        if (fechadeDeLanzamiento == null) {
            throw new CampoVacioException();
        }
        this.fechadeDeLanzamiento = fechadeDeLanzamiento;
    }

    public void setID_juego(String iD_juego) {
        ID_juego = iD_juego;
    }


    @Override
    public String toString() {
        return "Juego [ID_juego=" + ID_juego + ", tituloJuego=" + tituloJuego + ", genero=" + genero + ", modosDeJuego="
                + modosDeJuego + ", compatibilidad=" + compatibilidad + ", precio=" + precio + ", tamanio=" + tamanio
                + ", empresaDesarrolladora=" + empresaDesarrolladora + ", fechadeDeLanzamiento=" + fechadeDeLanzamiento
                + "]";
    }

    


    


    
   
    
    


}


