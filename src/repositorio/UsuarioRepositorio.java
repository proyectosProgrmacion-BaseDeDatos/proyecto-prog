package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import excepciones.CamposvaciosException;
import excepciones.DniException;
import excepciones.JuegoNoExisteException;
import excepciones.JuegoYaComprado;
import excepciones.SaldoInsuficienteException;
import modelo.TodosLosDatosUsuarios;
import modelo.Usuario;

public class UsuarioRepositorio {



    















    public List<Usuario> obtenerTodosUsuarios() throws SQLException, CamposvaciosException, DniException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                Usuario u = new Usuario(id, usuario, password, nombre, apellidos, dni);
                listaUsuarios.add(u);

            }
        }
        return listaUsuarios;

    }

    public int crearUsuario(Usuario u) throws CamposvaciosException, DniException, SQLException {
        String sql = "INSERT INTO `usuarios`(`usuario`, `password`, `dni`, `nombre`, `apellidos`) VALUES (?,?,?,?,?)";
        int rows = 0;
        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getDni());
            ps.setString(4, u.getNombre());
            ps.setString(5, u.getApellidos());

            rows = ps.executeUpdate();

            return rows;
        }

    }

    public int editarUsuario(int idUsuario, String usuario, String password) throws SQLException {
        int rows = 0;
        String sql = "UPDATE `usuarios` SET `usuario`= ? ,`password`= ? WHERE id_usuario = ?";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setInt(3, idUsuario);

            rows = ps.executeUpdate();

        }

        return rows;

    }

    public int eliminarUsuario(String dni) throws SQLException {
        int rows = 0;
        String sql = "DELETE FROM usuarios WHERE dni = ?";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);

            rows = ps.executeUpdate();
        }

        return rows;
    }

    public int verificarCredenciales(String usuario, String password) throws SQLException {
        int rows = 0;

        String sql = "SELECT * FROM usuarios WHERE usuario LIKE ? AND password LIKE ?";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rows = 1;
            }

        }

        return rows;

    }

    public List<TodosLosDatosUsuarios> obtenerDatosUsuario(String usuario, String password) throws SQLException {
        /*
         * SELECT * FROM usuarios u JOIN cuentas_bancarias c on c.id_usuario =
         * u.id_usuario JOIN usuarios_juegos uj on uj.id_usuario = u.id_usuario JOIN
         * juegos j ON j.id_juego = uj.id_juego WHERE usuario LIKE '?' AND password LIKE
         * '?';
         */

        List<TodosLosDatosUsuarios> listaDatosUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios u JOIN cuentas_bancarias c on c.id_usuario = u.id_usuario JOIN usuarios_juegos uj on uj.id_usuario = u.id_usuario JOIN juegos j ON j.id_juego = uj.id_juego WHERE usuario LIKE ? AND password LIKE ?";

        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_usuario");
                String usuario1 = rs.getString("usuario");
                String password1 = rs.getString("password");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                int idcuenta = rs.getInt("id_cuenta");
                String nombreTitular = rs.getString("nombre_titular");
                String numeroCuenta = rs.getString("numero_cuenta");
                double dinero = rs.getDouble("dinero");

                int idjuego = rs.getInt("id_juego");
                String nombrejuego = rs.getString("nombre");
                String genero = rs.getString("nombreJuego");
                String empresaDesarrollo = rs.getString("empresa_desarrolladora");
                LocalDate fechaLanzamiento = rs.getDate("fecha_lanzamiento").toLocalDate();
                double precio = rs.getDouble("precio");

                TodosLosDatosUsuarios tdu = new TodosLosDatosUsuarios(id, usuario1, password1, dni, nombre, apellidos,
                        idcuenta, nombreTitular, numeroCuenta, dinero, idjuego, nombrejuego, genero, empresaDesarrollo,
                        fechaLanzamiento, precio);
                        
                listaDatosUsuarios.add(tdu);
            }

            return listaDatosUsuarios;
        }

    }

    public void comprarJuego(int idUsuario, int idJuego)
            throws SQLException, JuegoYaComprado, JuegoNoExisteException, SaldoInsuficienteException {

        // verificar si el juego esta comprado
        String sqlComprobar = "SELECT COUNT(*) FROM usuarios_juegos WHERE id_usuario = ? AND id_juego = ?";
        try (Connection conn = DbConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlComprobar);

            ps.setInt(1, idUsuario);
            ps.setInt(2, idJuego);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    throw new JuegoYaComprado();
                }
            }

            // obtener precio del juego
            double precioJuego = 0;
            String sqlPrecio = "SELECT precio FROM juegos WHERE id_juego = ?";
            PreparedStatement psPrecio = conn.prepareStatement(sqlPrecio);

            psPrecio.setInt(1, idJuego);
            ResultSet rsPrecio = psPrecio.executeQuery();

            if (!rsPrecio.next()) {
                throw new JuegoNoExisteException();
            }

            precioJuego = rsPrecio.getInt(1);

            // obtener saldo usuario
            double saldo = 0;
            String sqlSaldoUsuario = "SELECT dinero FROM cuentas_bancarias WHERE id_usuario = ?";
            PreparedStatement psSaldoUsuario = conn.prepareStatement(sqlSaldoUsuario);

            psSaldoUsuario.setInt(1, idUsuario);
            ResultSet rsSaldoUsuario = psSaldoUsuario.executeQuery();

            while (rsSaldoUsuario.next()) {
                saldo = rsSaldoUsuario.getDouble(1);
            }

            if (saldo < precioJuego) {
                throw new SaldoInsuficienteException();
            }

            System.out.println("Compra realizada con exito");

            // restar el Precio juego a tu saldo y insertar la compra

            String sqlRestarPrecioJuego = "UPDATE `cuentas_bancarias` SET `dinero`= ? WHERE id_usuario = ?";
            PreparedStatement psRestarPrecioJuego = conn.prepareStatement(sqlRestarPrecioJuego);
            
            double saldoFinal = saldo - precioJuego;

            psRestarPrecioJuego.setDouble(1, saldoFinal);
            psRestarPrecioJuego.setInt(2, idUsuario);      
            
            if (psRestarPrecioJuego.executeUpdate() > 0) {
                System.out.println("Update realizado con exito");
            }

            // insertar juego comprado a la base de datos

            String sqlInsertarJuegoComprado = "INSERT INTO `usuarios_juegos`(`id_usuario`, `id_juego`, `fecha_compra`) VALUES (?,?,?)";
            PreparedStatement psInsertarJuego = conn.prepareStatement(sqlInsertarJuegoComprado);

            psInsertarJuego.setInt(1, idUsuario);
            psInsertarJuego.setInt(2, idJuego);
            psInsertarJuego.setDate(3, Date.valueOf(LocalDate.now()));

            if (psInsertarJuego.executeUpdate() > 0) {
                System.out.println("Juego comprado con exito");
            }

        }

    }

}
