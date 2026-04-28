package modelo;

public class Serie extends Multimedia{
	//Atributos
	private int temporadas;
	private int numCapitulos;
	private String actores;
	private String fechaFin;
	
	//Constructor por defecto
	public Serie() {
		super();
		temporadas=0;
		numCapitulos=0;
		actores="";
		fechaFin="";
	}

	//Constructor por parametros
	public Serie(String titulo, GENERO genero, int anio, String autor, float puntuacion, String descripcion,
			String fechaInicio, String personajes, int temporadas, int numCapitulos, String actores, String fechaFin) {
		super(titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, personajes);
		this.temporadas = temporadas;
		this.numCapitulos = numCapitulos;
		this.actores = actores;
		this.fechaFin = fechaFin;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getNumCapitulos() {
		return numCapitulos;
	}

	public void setNumCapitulos(int numCapitulos) {
		this.numCapitulos = numCapitulos;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
