package modelo;

import excepciones.CamposvaciosException;
import excepciones.CuentaBancariaException;
import excepciones.DineroNegativoException;
import utilidades.ComprobarCuentaBancaria;

public class CuentaBancaria {

    private int idCuenta;
    private int idUsuario; // Clave foránea
    private String nombreTitular;
    private String numeroCuenta;
    private double dinero;

    public CuentaBancaria(int idCuenta, int idUsuario, String nombreTitular, String numeroCuenta, double dinero) throws CuentaBancariaException, DineroNegativoException, CamposvaciosException {
        
        this.setIdCuenta(idCuenta);
        this.setIdUsuario(idUsuario);
        this.setNombreTitular(nombreTitular);
        this.setNumeroCuenta(numeroCuenta);
        this.setDinero(dinero);
    }

    public CuentaBancaria(int idUsuario, String nombreTitular, String numeroCuenta, double dinero) throws CamposvaciosException, CuentaBancariaException, DineroNegativoException {
        this.setIdUsuario(idUsuario);
        this.setNombreTitular(nombreTitular);
        this.setNumeroCuenta(numeroCuenta);
        this.setDinero(dinero);
    }

    

    //? ========= GET =========
    public int getIdCuenta() {
        return idCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getDinero() {
        return dinero;
    }

    //! ========= SET =========

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setIdUsuario(int idUsuario) {
        
        this.idUsuario = idUsuario;
    }

    public void setNombreTitular(String nombreTitular) throws CamposvaciosException {
        if (nombreTitular == null || nombreTitular.length() == 0) {
            throw new CamposvaciosException();
        }
        this.nombreTitular = nombreTitular;
    }

    public void setNumeroCuenta(String numeroCuenta) throws CuentaBancariaException, CamposvaciosException {
        
        if (numeroCuenta == null || numeroCuenta.length() == 0) {
            throw new CamposvaciosException();
        }

        ComprobarCuentaBancaria.verificarCuentaBancaria(numeroCuenta);

        this.numeroCuenta = numeroCuenta;
    }

    public void setDinero(double dinero) throws DineroNegativoException {

        if (dinero < 0) {
            throw new DineroNegativoException();
        }
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [idCuenta=" + idCuenta + ", idUsuario=" + idUsuario + ", nombreTitular=" + nombreTitular
                + ", numeroCuenta=" + numeroCuenta + ", dinero=" + dinero + "]";
    }
    
    
    

}