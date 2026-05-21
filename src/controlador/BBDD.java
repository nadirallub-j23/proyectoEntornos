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
import modelo.Libro;
import modelo.Multimedia;

public class BBDD {
	private static final String x = "jdbc:mysql://localhost/resenas_db";
	private static final String xx = "root";
	private static final String xxx = "";

	/**
	 * Verifica si la conexión a la base de datos está disponible. Intenta
	 * conectarse a la base de datos y si lo consigue devuelve true. Si no lo
	 * consigue, por ejemplo porque XAMPP no está abierto, devuelve false.
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
			PreparedStatement insertaPeli = conexion.prepareStatement(
					"INSERT INTO pelicula (titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, personajes, duracion, actores) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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

	public ArrayList<Serie> consultarSeries() {
		ArrayList<Serie> arrSeries = new ArrayList<>();
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM serie");
			ResultSet registro = consulta.executeQuery();

			while (registro.next()) {
				Serie s = new Serie();
				s.setId(registro.getInt("id"));
				s.setTitulo(registro.getString("titulo"));
				s.setGenero(GENERO.valueOf(registro.getString("genero")));
				s.setAnio(registro.getInt("anio"));
				s.setAutor(registro.getString("autor"));
				s.setPuntuacion(registro.getFloat("puntuacion"));
				s.setDescripcion(registro.getString("descripcion"));
				s.setFechaInicio(registro.getString("fechaInicio"));
				s.setPersonajes(registro.getString("personajes"));
				s.setTemporadas(registro.getInt("temporadas"));
				s.setNumCapitulos(registro.getInt("numCapitulos"));
				s.setActores(registro.getString("actores"));
				s.setFechaFin(registro.getString("fechaFin"));
				arrSeries.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrSeries;
	}

	public void modificarSerie(int id, String titulo, String genero, int anio, String autor, Float puntuacion,
	        String descripcion, String fechaInicio, String personajes,
	        int temporadas, int numCapitulos, String actores, String fechaFin) {

		Connection conexion = null;
	    try { 
	     conexion = DriverManager.getConnection(x, xx, xxx);
	         PreparedStatement consulta = conexion.prepareStatement(
	            "UPDATE serie SET titulo=?, genero=?, anio=?, autor=?, puntuacion=?, descripcion=?, " +
	            "fechaInicio=?, personajes=?, temporadas=?, numCapitulos=?, actores=?, fechaFin=? " +
	            "WHERE id=?"); 

	        consulta.setString(1, titulo);
	        consulta.setString(2, genero);
	        consulta.setInt(3, anio);
	        consulta.setString(4, autor);
	        consulta.setFloat(5, puntuacion);
	        consulta.setString(6, descripcion);
	        consulta.setString(7, fechaInicio);
	        consulta.setString(8, personajes);
	        consulta.setInt(9, temporadas);
	        consulta.setInt(10, numCapitulos);
	        consulta.setString(11, actores);
	        consulta.setString(12, fechaFin);
	        consulta.setInt(13, id); 
	        consulta.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		conexion.close();
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
	public boolean insertaDatosLibro(Libro libro) {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);

			PreparedStatement insertaLibro = conexion.prepareStatement(
					"INSERT INTO libro (titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, fechaFin, personajes, numPaginas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			insertaLibro.setString(1, libro.getTitulo());
			insertaLibro.setString(2, libro.getGenero().toString());
			insertaLibro.setInt(3, libro.getAnio());
			insertaLibro.setString(4, libro.getAutor());
			insertaLibro.setFloat(5, libro.getPuntuacion());
			insertaLibro.setString(6, libro.getDescripcion());
			insertaLibro.setString(7, libro.getFechaInicio());
			insertaLibro.setString(8, libro.getFechaFin());
			insertaLibro.setString(9, libro.getPersonajes());
			insertaLibro.setInt(10, libro.getNumPaginas());
			insertaLibro.executeUpdate();

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
