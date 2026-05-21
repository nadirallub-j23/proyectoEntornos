package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Multimedia.GENERO;
import modelo.Pelicula;
import modelo.Serie;
import modelo.Multimedia;

public class BBDD {
	private static final String x = "jdbc:mysql://localhost/resenas_db";
	private static final String xx = "root";
	private static final String xxx = "";
	
	/**
	 * Verifica si la conexión a la base de datos está disponible.
	 * Intenta conectarse a la base de datos y si lo consigue devuelve true.
	 * Si no lo consigue, por ejemplo porque XAMPP no está abierto, devuelve false.
	 *  
	 * @return true si la conexión fue exitosa, false si no se pudo conectar
	 */
	public boolean verificarConexion() {
		try {
			Connection conexion = DriverManager.getConnection(x, xx, xxx);
			conexion.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	public boolean insertaDatosPeli(Pelicula p) {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement insertaPeli = conexion.prepareStatement("INSERT INTO pelicula (titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, personajes, duracion, actores) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			insertaPeli.setString(1, p.getTitulo());
			insertaPeli.setString(2, p.getGenero().toString());
			insertaPeli.setInt(3, p.getAnio());
			insertaPeli.setString(4, p.getAutor());
			insertaPeli.setFloat(5, p.getPuntuacion());
			insertaPeli.setString(6, p.getDescripcion());
			insertaPeli.setString(7, p.getFechaInicio());
			insertaPeli.setString(8, p.getPersonajes());
			insertaPeli.setInt(9, p.getDuracion());
			insertaPeli.setString(10, p.getActores());
			insertaPeli.executeUpdate();

			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertaDatosSerie(Serie serie) {
	    Connection conexion = null;
	    try {
	        conexion = DriverManager.getConnection(x, xx, xxx);

	        PreparedStatement insertaSerie = conexion.prepareStatement(
	            "INSERT INTO serie (titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, fechaFin, personajes, temporadas, numCapitulos, actores) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	        insertaSerie.setString(1, serie.getTitulo());
	        insertaSerie.setString(2, serie.getGenero().toString());
	        insertaSerie.setInt(3, serie.getAnio());
	        insertaSerie.setString(4, serie.getAutor());
	        insertaSerie.setFloat(5, serie.getPuntuacion());
	        insertaSerie.setString(6, serie.getDescripcion());
	        insertaSerie.setString(7, serie.getFechaInicio());   
	        insertaSerie.setString(8, serie.getFechaFin());     
	        insertaSerie.setString(9, serie.getPersonajes());
	        insertaSerie.setInt(10, serie.getTemporadas());
	        insertaSerie.setInt(11, serie.getNumCapitulos());
	        insertaSerie.setString(12, serie.getActores());
	        insertaSerie.executeUpdate();
	        
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;

	    } finally {
	        try {
	            conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	

}
