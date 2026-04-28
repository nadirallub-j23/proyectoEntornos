package modelo;

public class Pelicula extends Multimedia {

	// Atributos
	private int duracion;
	private String actores;

	//Constructor por defecto
	public Pelicula() {
		duracion = 0;
		actores = "";
	}

	//Constructor por parametros
	public Pelicula(String titulo, Genero genero, int anio, String autor, float puntuacion, String descripcion,
			String fechaInicio, String personajes, int duracion, String actores) {
		super(titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, personajes);
		this.duracion = duracion;
		this.actores = actores;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	
}
