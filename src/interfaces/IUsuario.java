package interfaces;

import modelo.CuentaBancaria;
import modelo.Usuario;

public interface IUsuario {

    public Usuario nuevoUsuario(String usuario,String password,String dni,String nombre , String apellidos , String direccion, String codigoPostal, String provincia, String localidad, String id_usuario ,CuentaBancaria cuenta);
    

}
