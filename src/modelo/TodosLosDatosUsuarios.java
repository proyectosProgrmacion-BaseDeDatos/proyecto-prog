package modelo;

import java.time.LocalDate;

public class TodosLosDatosUsuarios {
    //datos usuario
    private int idUsuario;
    private String nombreusuario;
    private String password;
    private String dni;
    private String nombre;
    private String apellidos;
    

    //datos cuenta
    private int idCuenta;
    private String nombreTitular;
    private String numeroCuenta;
    private double dinero;

    

    // datos juego
    private int idJuego;
    private String nombreJuego;
    private String genero;
    private String empresaDesarrolladora;
    private LocalDate fechaLanzamiento;
    private double precio;
    public TodosLosDatosUsuarios(int idUsuario, String nombreusuario, String password, String dni, String nombre,String apellidos, int idCuenta, String nombreTitular, String numeroCuenta, double dinero, int idJuego,String nombreJuego, String genero, String empresaDesarrolladora, LocalDate fechaLanzamiento,double precio) {

        this.setIdUsuario(idUsuario);
        this.setNombreusuario(nombreusuario);
        this.setPassword(password);
        this.setDni(dni);
        this.setNombre(nombreJuego);
        this.setApellidos(apellidos);

        this.setIdCuenta(idCuenta);
        this.setNombreTitular(nombreTitular);
        this.setNumeroCuenta(numeroCuenta);
        this.setDinero(dinero);

        this.setIdJuego(idJuego);
        this.setNombreJuego(nombreJuego);
        this.setGenero(genero);
        this.setEmpresaDesarrolladora(empresaDesarrolladora);
        this.setFechaLanzamiento(fechaLanzamiento);
        this.setPrecio(precio);
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreusuario() {
        return nombreusuario;
    }
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getDinero() {
        return dinero;
    }
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    public int getIdJuego() {
        return idJuego;
    }
    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }
    public String getNombreJuego() {
        return nombreJuego;
    }
    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEmpresaDesarrolladora() {
        return empresaDesarrolladora;
    }
    public void setEmpresaDesarrolladora(String empresaDesarrolladora) {
        this.empresaDesarrolladora = empresaDesarrolladora;
    }
    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "TodosLosDatosUsuarios [idUsuario=" + idUsuario + ", nombreusuario=" + nombreusuario + ", password="
                + password + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idCuenta="
                + idCuenta + ", nombreTitular=" + nombreTitular + ", numeroCuenta=" + numeroCuenta + ", dinero="
                + dinero + ", idJuego=" + idJuego + ", nombreJuego=" + nombreJuego + ", genero=" + genero
                + ", empresaDesarrolladora=" + empresaDesarrolladora + ", fechaLanzamiento=" + fechaLanzamiento
                + ", precio=" + precio + "]";
    }

    

    



}
