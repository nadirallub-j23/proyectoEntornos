package modelo;

public class Multimedia {

	//Atributos
	 public enum GENERO {
	        ROMANCE, ACCION, SUSPENSE, FANTASIA, TERROR, COMEDIA, DOCUMENTAL,HISTORICO,DRAMA,CIENCIA_FICCION
	    }

	    private String titulo;
	    private GENERO genero;
	    private int anio;
	    private String autor;
	    private float puntuacion;
	    private String descripcion;
	    private String fechaInicio;
	    private String personajes;
	    
	    //Constructor por defecto
	    public Multimedia() {
	    	genero=GENERO.FANTASIA;
	    	titulo="";
	    	anio=0;
	    	autor="";
	    	puntuacion=0.0f;
	    	descripcion="";
	    	fechaInicio="";
	    	personajes="";
	    	
	    }

	  //Constructor por parametros
		public Multimedia(String titulo, GENERO genero, int anio, String autor, float puntuacion, String descripcion,
				String fechaInicio, String personajes) {
			super();
			this.titulo = titulo;
			this.genero = genero;
			this.anio = anio;
			this.autor = autor;
			this.puntuacion = puntuacion;
			this.descripcion = descripcion;
			this.fechaInicio = fechaInicio;
			this.personajes = personajes;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public GENERO getGenero() {
			return genero;
		}

		public void setGenero(GENERO genero) {
			this.genero = genero;
		}

		public int getAnio() {
			return anio;
		}

		public void setAnio(int anio) {
			this.anio = anio;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public float getPuntuacion() {
			return puntuacion;
		}

		public void setPuntuacion(float puntuacion) {
			this.puntuacion = puntuacion;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(String fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public String getPersonajes() {
			return personajes;
		}

		public void setPersonajes(String personajes) {
			this.personajes = personajes;
		}
	    
	    
	    
}
