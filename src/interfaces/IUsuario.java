package interfaces;

import java.sql.SQLException;
import java.util.List;

import excepciones.CamposvaciosException;
import excepciones.DniException;
import excepciones.UsuarioNoExisteException;
import excepciones.ImposibleEditarUsuario;
import excepciones.JuegoNoExisteException;
import excepciones.JuegoYaComprado;
import excepciones.SaldoInsuficienteException;
import excepciones.verificarCredencialesException;
import modelo.Usuario;

public interface IUsuario {

    List<Usuario> obtenerTodoUsuario() throws SQLException, CamposvaciosException, DniException;

    void crearUsuario(String usuario, String password, String nombre, String apellidos, String dni) throws CamposvaciosException, DniException, SQLException;

    void editarUsuario(int idUsuario, String usuario, String password) throws SQLException, ImposibleEditarUsuario;

    void eliminarUsuario(String dni) throws UsuarioNoExisteException, SQLException;

    void verificarCredenciales(String usuario, String password) throws verificarCredencialesException, SQLException;// para hacer login

    void comprarJuego(int idUsuario, int idJuego) throws SQLException, JuegoYaComprado, JuegoNoExisteException, SaldoInsuficienteException;
    
    //boolean verificarExistenciaUsuario(int dni);// lo voy a usar para comprobar que el usuario ya existe o no

}
