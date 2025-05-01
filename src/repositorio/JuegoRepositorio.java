package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import excepciones.CamposvaciosException;
import excepciones.PrecioJuegoException;
import modelo.Juego;

public class JuegoRepositorio {

    public List<Juego> obtenerTodosJuegos() throws SQLException, CamposvaciosException, PrecioJuegoException{

        List<Juego> listaJuegos = new ArrayList<>();

        String sql = "SELECT * FROM juegos";
        
        try (Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_juego");
                String nombre = rs.getString("nombreJuego");
                String genero = rs.getString("genero");
                String empresaDesa = rs.getString("empresa_desarrolladora");
                LocalDate fechaLanzamineto = rs.getDate("fecha_lanzamiento").toLocalDate();
                double precio = rs.getDouble("precio");

                Juego j = new Juego(id, nombre, genero, empresaDesa, fechaLanzamineto, precio);
                listaJuegos.add(j);
            }
             
        } 
        
        return listaJuegos;

    }

    public int eliminarJuego(int id) throws SQLException{

        String sql = "DELETE FROM juegos WHERE id_juego = ?";
        int rows = 0;

        try (Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rows = ps.executeUpdate();

        } 

        return rows;

    }

    public int crearJuego(String nombre, String genero,String empresaDesarrolladora,LocalDate fechaLanzamineto,double precio) throws SQLException{
        
        int rows = 0;
        String sql = "INSERT INTO `juegos`(`nombreJuego`, `genero`, `empresa_desarrolladora`, `fecha_lanzamiento`, `precio`) VALUES (?,?,?,?,?)";

        try (Connection conn = DbConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, genero);
            ps.setString(3, empresaDesarrolladora);
            ps.setDate(4,java.sql.Date.valueOf(fechaLanzamineto));
            ps.setDouble(5, precio);

            rows = ps.executeUpdate();
        }

        return rows;

    }

    

}
