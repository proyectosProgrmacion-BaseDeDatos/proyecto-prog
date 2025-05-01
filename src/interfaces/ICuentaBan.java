package interfaces;

import java.sql.SQLException;

import excepciones.CamposvaciosException;
import excepciones.CuentaBancariaException;
import excepciones.CuentaBancariaYaExisteException;
import excepciones.DineroNegativoException;
import excepciones.NuevaCuentaBancariaException;
import excepciones.UsuarioNoExisteException;

public interface ICuentaBan {

    void crearCuentaBancaria(int idUsuario,String titular,String numeroCuenta,double saldo) throws CamposvaciosException, CuentaBancariaException, DineroNegativoException, SQLException, NuevaCuentaBancariaException, UsuarioNoExisteException, CuentaBancariaYaExisteException;

}
