package modelo;

import excepciones.CampoVacioException;
import excepciones.DniExceptions;
import utilidades.ComprobarDni;
import utilidades.GenerarID_usuario;

public class Usuario {
    private String id_usuario;
    private String usuario;
    private String password;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String codigoPostal;
    private String provincia;
    private String localidad;



    public Usuario(String usuario, String password, String dni, String nombre, String apellidos, String direccion,
            String codigoPostal, String provincia, String localidad) throws CampoVacioException, DniExceptions {

        this.setUsuario(usuario);
        this.setPassword(password);
        this.setDni(dni);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDireccion(direccion);
        this.setCodigoPostal(codigoPostal);
        this.setProvincia(provincia);
        this.setLocalidad(localidad);
        this.setId_usuario(id_usuario);
    }

    //! ================  GET  ================

    public String getUsuario() {
        return usuario;
    }
    public String getPassword() {
        return password;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public String getProvincia() {
        return provincia;
    }
    public String getLocalidad() {
        return localidad;
    }

    //? ================  SET  ================

   
    public void setUsuario(String usuario) throws CampoVacioException {
        if (usuario == null || usuario.length() == 0) {
            throw new CampoVacioException();
        }
        this.usuario = usuario;
    }
    public void setPassword(String password) throws CampoVacioException {
        if (password == null || password.length() == 0) {
            throw new CampoVacioException();
        }
        this.password = password;
    }
    public void setDni(String dni) throws CampoVacioException, DniExceptions {
        if (dni == null || dni.length() == 0) {
            throw new CampoVacioException();
        }

        ComprobarDni.verificar_dni(dni);

        this.dni = dni;
    }
    public void setNombre(String nombre) throws CampoVacioException {
        if (nombre == null || nombre.length() == 0) {
            throw new CampoVacioException();
        }
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) throws CampoVacioException {
        if (apellidos == null || apellidos.length() == 0) {
            throw new CampoVacioException();
        }
        this.apellidos = apellidos;
    }
    public void setDireccion(String direccion) throws CampoVacioException {
        if (direccion == null || direccion.length() == 0) {
            throw new CampoVacioException();
        }
        this.direccion = direccion;
    }
    public void setCodigoPostal(String codigoPostal) throws CampoVacioException {
        if (codigoPostal == null || codigoPostal.length() == 0) {
            throw new CampoVacioException();
        }
        this.codigoPostal = codigoPostal;
    }
    public void setProvincia(String provincia) throws CampoVacioException {
        if (provincia == null || provincia.length() == 0) {
            throw new CampoVacioException();
        }
        this.provincia = provincia;
    }
    public void setLocalidad(String localidad) throws CampoVacioException {
        if (localidad == null || localidad.length() == 0) {
            throw new CampoVacioException();
        }
        this.localidad = localidad;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = GenerarID_usuario.Generar_ID_usuario(getNombre(), getApellidos(), getDni());
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + ", dni=" + dni
                + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", codigoPostal="
                + codigoPostal + ", provincia=" + provincia + ", localidad=" + localidad + "]";
    }

    

    
    


    


}
