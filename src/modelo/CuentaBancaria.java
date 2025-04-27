package modelo;

import excepciones.CampoVacioException;
import excepciones.CuentaBancariaException;
import utilidades.ComprobarCuentaBancaria;
import utilidades.Generar_ID_Cuenta;

public class CuentaBancaria {
    private String id_cuentaBancaria;
    private String titular;
    private String numeroCuenta;
    private double dinero;

    public CuentaBancaria(String titular, String numeroCuenta, double dinero) throws CuentaBancariaException, CampoVacioException {
        
        this.setTitular(titular);
        this.setNumeroCuenta(numeroCuenta);
        this.setDinero(dinero);
        this.setId_cuentaBancaria(id_cuentaBancaria);
        
    } 
    public String getId_cuentaBancaria() {
        return id_cuentaBancaria;
    }
    
    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getDinero() {

        return dinero;
    }

    public void setTitular(String titular) throws CampoVacioException {
        if (titular == null || titular.length() == 0) {
            throw new CampoVacioException();
        }
        this.titular = titular;
    }

    public void setNumeroCuenta(String numeroCuenta) throws CuentaBancariaException, CampoVacioException {

        if (numeroCuenta == null || numeroCuenta.length() == 0) {
            throw new CampoVacioException();
        }

        ComprobarCuentaBancaria.verificarCeuntaBancaria(numeroCuenta);

        this.numeroCuenta = numeroCuenta;

        
    }

    public void setId_cuentaBancaria(String id_cuentaBancaria) {
        this.id_cuentaBancaria = Generar_ID_Cuenta.crear_ID_cuenta(getTitular(), getNumeroCuenta());
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    @Override
    public String toString() {
        return "CuentaBancaria [id_cuentaBancaria=" + id_cuentaBancaria + ", titular=" + titular + ", numeroCuenta="
                + numeroCuenta + ", dinero=" + dinero + "]";
    }

    

    

}
