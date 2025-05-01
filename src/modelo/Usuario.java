package modelo;

import excepciones.CamposvaciosException;
import excepciones.DniException;
import utilidades.ComprobarDni;

public class Usuario {

    private int idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;

    

    public Usuario(int idUsuario, String usuario, String password, String nombre, String apellidos, String dni) throws CamposvaciosException, DniException {
       
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
        this.setPassword(password);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDni(dni);
    }

    public Usuario(String usuario, String password, String nombre, String apellidos, String dni) throws CamposvaciosException, DniException {
       
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
        this.setPassword(password);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDni(dni);
    }

    //? ========= GET =========

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    //! ========= SET =========

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) throws CamposvaciosException {
        if (usuario == null || usuario.length() == 0) {
            throw new CamposvaciosException();
        }
        this.usuario = usuario;
    }

    public void setPassword(String password) throws CamposvaciosException {
        if (password == null || password.length() == 0) {
            throw new CamposvaciosException();
        }
        this.password = password;
    }

    public void setNombre(String nombre) throws CamposvaciosException {
        if (nombre == null || nombre.length() == 0) {
            throw new CamposvaciosException();
        }
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) throws CamposvaciosException {
        if (apellidos == null || apellidos.length() == 0) {
            throw new CamposvaciosException();
        }
        this.apellidos = apellidos;
    }

    public void setDni(String dni) throws CamposvaciosException, DniException {
        if (dni == null || dni.length() == 0) {
            throw new CamposvaciosException();
        }

        ComprobarDni.verificar_dni(dni);

        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", nombre="
                + nombre + ", apellidos=" + apellidos + ", dni=" + dni + "]";
    }

    
    
}