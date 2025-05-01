package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbConnection;
import excepciones.CuentaBancariaYaExisteException;
import excepciones.UsuarioNoExisteException;
import modelo.CuentaBancaria;

public class CuentaBanRepositorio {

    public int altaCuentaBancaria(CuentaBancaria c1)
            throws SQLException, UsuarioNoExisteException, CuentaBancariaYaExisteException {
        int rows = 0;

        String sql2 = "SELECT COUNT(*) FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement psVerificarUsuario = conn.prepareStatement(sql2);

            psVerificarUsuario.setInt(1, c1.getIdUsuario());

            ResultSet rsVerificar = psVerificarUsuario.executeQuery();

            if (rsVerificar.next()) {

                if (rsVerificar.getInt(1) < 1) {
                    throw new UsuarioNoExisteException();
                }

            }

            // comprobar que el usuario no tenga una cuenta ya
            String sql3 = "SELECT COUNT(*) FROM cuentas_bancarias WHERE id_usuario = ?";

            PreparedStatement psComprobarExistenciaCuentaBancaria = conn.prepareStatement(sql3);
            psComprobarExistenciaCuentaBancaria.setInt(1, c1.getIdUsuario());

            ResultSet rsExistencia = psComprobarExistenciaCuentaBancaria.executeQuery();

            if (rsExistencia.next()) {
                if (rsExistencia.getInt(1) > 0) {
                    throw new CuentaBancariaYaExisteException();
                }
            }
            String sql = "INSERT INTO `cuentas_bancarias`(`id_usuario`, `nombre_titular`, `numero_cuenta`, `dinero`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, c1.getIdUsuario());
            ps.setString(2, c1.getNombreTitular());
            ps.setString(3, c1.getNumeroCuenta());
            ps.setDouble(4, c1.getDinero());
            rows = ps.executeUpdate();
        }
            return rows;
    }










    
}


