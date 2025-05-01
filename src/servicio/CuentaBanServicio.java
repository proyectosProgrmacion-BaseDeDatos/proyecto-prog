package servicio;

import java.sql.SQLException;

import repositorio.CuentaBanRepositorio;
import excepciones.CamposvaciosException;
import excepciones.CuentaBancariaException;
import excepciones.CuentaBancariaYaExisteException;
import excepciones.DineroNegativoException;
import excepciones.NuevaCuentaBancariaException;
import excepciones.UsuarioNoExisteException;
import interfaces.ICuentaBan;
import modelo.CuentaBancaria;

public class CuentaBanServicio implements ICuentaBan{
CuentaBanRepositorio cbr = new CuentaBanRepositorio();
    @Override
    public void crearCuentaBancaria(int idUsuario, String titular, String numeroCuenta, double saldo) throws CamposvaciosException, CuentaBancariaException, DineroNegativoException, SQLException, NuevaCuentaBancariaException, UsuarioNoExisteException, CuentaBancariaYaExisteException {

        int rows = 0;

        CuentaBancaria c1 = new CuentaBancaria(idUsuario, titular, numeroCuenta, saldo);
        cbr.altaCuentaBancaria(c1);

        if (rows < 0) {
            throw new NuevaCuentaBancariaException();
        }else{
            System.out.println("Cuenta creada con exito");
        }

    }

}
