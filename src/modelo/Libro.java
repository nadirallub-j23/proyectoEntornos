package modelo;

public class Libro extends Multimedia {

	// Atributos
	private int numPaginas;
	private String fechaFin;
	private int id;

	// Constructor por defecto
	public Libro() {
		super();
		numPaginas = 0;
		fechaFin = "";
		
		
	}

	// Constructor por parametros
	public Libro(int id, String titulo, GENERO genero, int anio, String autor, float puntuacion, String descripcion,
			String fechaInicio, String personajes, int numPaginas, String fechaFin) {
		super(titulo, genero, anio, autor, puntuacion, descripcion, fechaInicio, personajes);
		this.numPaginas = numPaginas;
		this.fechaFin = fechaFin;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

}
