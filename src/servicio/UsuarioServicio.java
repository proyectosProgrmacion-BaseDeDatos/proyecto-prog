package servicio;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import repositorio.UsuarioRepositorio;
import excepciones.CamposvaciosException;
import excepciones.DniException;
import excepciones.UsuarioNoExisteException;
import excepciones.ImposibleEditarUsuario;
import excepciones.JuegoNoExisteException;
import excepciones.JuegoYaComprado;
import excepciones.SaldoInsuficienteException;
import excepciones.UsuarioNoExisteException;
import excepciones.verificarCredencialesException;
import interfaces.IUsuario;
import modelo.TodosLosDatosUsuarios;
import modelo.Usuario;

@SuppressWarnings("unused")
public class UsuarioServicio implements IUsuario {

    UsuarioRepositorio ur = new UsuarioRepositorio();

    @Override
    public List<Usuario> obtenerTodoUsuario() throws SQLException, CamposvaciosException, DniException {

        return ur.obtenerTodosUsuarios();
    }

    @Override
    public void crearUsuario(String usuario, String password, String nombre, String apellidos, String dni)
            throws CamposvaciosException, DniException, SQLException {

        Usuario u1 = new Usuario(usuario, password, nombre, apellidos, dni);

        int rows = ur.crearUsuario(u1);

        if (rows > 0) {
            System.out.println("El usuario se a añadido correctamente");
        } else {
            throw new SQLIntegrityConstraintViolationException("Ese usuario ya existe");
        }

    }

    @Override
    public void editarUsuario(int idUsuario, String usuario, String password)
            throws SQLException, ImposibleEditarUsuario {

        int rows = ur.editarUsuario(idUsuario, usuario, password);

        if (rows > 0) {
            System.out.println("Usuario editado correctamente");

        } else {
            throw new ImposibleEditarUsuario();
        }

    }

    @Override
    public void eliminarUsuario(String dni) throws UsuarioNoExisteException, SQLException {

        int rows = ur.eliminarUsuario(dni);

        if (rows > 0) {
            System.out.println("Usuario eliminado correctamente");

        } else {
            throw new UsuarioNoExisteException();
        }

    }

    @Override
    public void verificarCredenciales(String usuario, String password) throws verificarCredencialesException, SQLException {

        int rows = ur.verificarCredenciales(usuario, password);
        
        
        if (rows > 0) {
            
            System.out.println("Sesion iniciada correctamente");
            List<TodosLosDatosUsuarios> datos = ur.obtenerDatosUsuario(usuario, password);
            


            for (TodosLosDatosUsuarios tdu : datos) {
                System.out.println(tdu);
            }
            
            
        }else{
            throw new verificarCredencialesException();
        }
    }

    @Override
    public void comprarJuego(int idUsuario, int idJuego) throws SQLException, JuegoYaComprado, JuegoNoExisteException, SaldoInsuficienteException {

            ur.comprarJuego(idUsuario, idJuego);
    }

    

  

}
