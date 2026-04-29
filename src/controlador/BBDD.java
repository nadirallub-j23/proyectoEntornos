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
	
	/**
	 * Inserta una serie en la base de datos.
	 * Como la tabla serie hereda de multimedia, primero inserta los datos
	 * comunes en multimedia y luego los datos propios de la serie en serie.
	 *
	 * @param titulo      Título de la serie
	 * @param genero      Género de la serie (ACCION, DRAMA, COMEDIA...)
	 * @param anio        Año de estreno de la serie
	 * @param puntuacion  Puntuación de la serie del 0 al 10
	 * @param descripcion Descripción de la serie
	 * @param fechaInicio Fecha de inicio de emisión (formato YYYY-MM-DD)
	 * @param fechaFin    Fecha de fin de emisión (formato YYYY-MM-DD)
	 * @param personajes  Personajes principales de la serie
	 * @param temporadas  Número de temporadas de la serie
	 * @param numCapitulos Número de capítulos de la serie
	 * @param actores     Actores principales de la serie
	 * @return true si la inserción fue correcta, false si hubo algún error
	 */
	public boolean insertarSerieEnBaseDeDatos(String titulo, String genero, int anio, float puntuacion, String descripcion,
			String fechaInicio, String fechaFin, String personajes, int temporadas, int numCapitulos, String actores) {
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(x, xx, xxx);
			PreparedStatement consultaMultimedia = conexion.prepareStatement(
					"INSERT INTO multimedia (titulo, genero, anio, puntuacion, descripcion, fechaInicio, fechaFin, personajes) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);//le dice a la base de datos que devuelva el id que acaba de generar después del INSERT.
			consultaMultimedia.setString(1, titulo);
			consultaMultimedia.setString(2, genero);
			consultaMultimedia.setInt(3, anio);
			consultaMultimedia.setFloat(4, puntuacion);
			consultaMultimedia.setString(5, descripcion);
			consultaMultimedia.setString(6, fechaInicio);
			consultaMultimedia.setString(7, fechaFin);
			consultaMultimedia.setString(8, personajes);
			consultaMultimedia.executeUpdate();


			ResultSet registro = consultaMultimedia.getGeneratedKeys();
			int idGenerado = 0;
			//Utilizamos el campo Id que es el (1), entonces le decimos que mientras el registro sea el siguiente pues que añada al id siguiente del ultimo insertado,y que lo guarde en idGenerado
			if (registro.next()) {
				idGenerado = registro.getInt(1);
			}


			PreparedStatement consultaSerie = conexion.prepareStatement("INSERT INTO serie (id, temporadas, numCapitulos, actores) VALUES (?, ?, ?, ?)");
			consultaSerie.setInt(1, idGenerado);
			consultaSerie.setInt(2, temporadas);
			consultaSerie.setInt(3, numCapitulos);
			consultaSerie.setString(4, actores);
			consultaSerie.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Obtiene todas las series de la base de datos
	 * uniendo la tabla multimedia con la tabla serie
	 * @return ArrayList con todas las series
	 */
	public ArrayList<Serie> consultarSeries() {
	    ArrayList<Serie> arrSeries = new ArrayList<>();
	    Connection conexion = null;
	    try {
	        conexion = DriverManager.getConnection(x, xx, xxx);
	        PreparedStatement consulta = conexion.prepareStatement(
	            "SELECT m.id, m.titulo, m.genero, m.anio, m.puntuacion, m.descripcion, " +
	            "m.fechaInicio, m.fechaFin, m.personajes, " +
	            "s.temporadas, s.numCapitulos, s.actores " +
	            "FROM multimedia m " +
	            "JOIN serie s ON m.id = s.id"
	        );
	        ResultSet registro = consulta.executeQuery();
	        while (registro.next()) {
	            Serie miSerie = new Serie();
	            miSerie.setTitulo(registro.getString("titulo"));
	            miSerie.setGenero(GENERO.valueOf(registro.getString("genero")));
	            miSerie.setAnio(registro.getInt("anio"));
	            miSerie.setPuntuacion(registro.getFloat("puntuacion"));
	            miSerie.setDescripcion(registro.getString("descripcion"));
	            miSerie.setFechaInicio(registro.getString("fechaInicio"));
	            miSerie.setFechaFin(registro.getString("fechaFin"));
	            miSerie.setPersonajes(registro.getString("personajes"));
	            miSerie.setTemporadas(registro.getInt("temporadas"));
	            miSerie.setNumCapitulos(registro.getInt("numCapitulos"));
	            miSerie.setActores(registro.getString("actores"));
	            arrSeries.add(miSerie);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conexion != null) {
	            try { conexion.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	    }
	    return arrSeries;
	}

	

}
