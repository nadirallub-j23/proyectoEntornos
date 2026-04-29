package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.BBDD;
import modelo.Multimedia.GENERO;
import modelo.Serie;

import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;


public class VntConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tablaPeliculas;
	private JTable tablaLibros;
	private JTable tablaSeries;
	DefaultTableModel modeloTablaSeries = new DefaultTableModel();
	DefaultTableModel modeloTablaPeliculas = new DefaultTableModel();
	DefaultTableModel modeloTablaLibros = new DefaultTableModel();
	private JComboBox cmbGenero;
	private BBDD bd = new BBDD();
	/**
	 * Create the panel.
	 */
	public VntConsulta() {
		setBackground(new Color(240, 242, 245));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MIS PELICULAS");
		lblNewLabel.setForeground(new Color(44, 62, 80)); 
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(297, 103, 166, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("MIS LIBROS");
		lblNewLabel_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(348, 539, 140, 39);
		add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 147, 695, 341);
		add(scrollPane);
		
		tablaPeliculas = new JTable();
		tablaPeliculas.setRowHeight(25);
		scrollPane.setViewportView(tablaPeliculas);
		
		modeloTablaPeliculas.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Duracion", "Actores"});
				
		tablaPeliculas.setModel(modeloTablaPeliculas);
				
			
		modeloTablaPeliculas.setRowCount(0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 594, 695, 341);
		add(scrollPane_1);
		
		tablaLibros = new JTable();
		tablaLibros.setRowHeight(25);
		scrollPane_1.setViewportView(tablaLibros);
		
		modeloTablaLibros.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Autor","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Nº paginas", "Fecha de fin"});
				
		tablaLibros.setModel(modeloTablaLibros);
				
			
		modeloTablaLibros.setRowCount(0);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(886, 147, 695, 341);
		add(scrollPane_2);
		
		tablaSeries = new JTable();
		tablaSeries.setRowHeight(25);
		scrollPane_2.setViewportView(tablaSeries);
		

		modeloTablaSeries.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Temporadas", "Nº capitulos", "Actores","Fecha de fin"});
				
		tablaSeries.setModel(modeloTablaSeries);
				
			
		modeloTablaSeries.setRowCount(0);
		
		JLabel lblMisLibros = new JLabel("MIS SERIES");
		lblMisLibros.setForeground(new Color(44, 62, 80));
		lblMisLibros.setBounds(1204, 95, 200, 48);
		add(lblMisLibros);
		lblMisLibros.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(new Color(231, 76, 60)); 
		btnBorrar.setForeground(new Color(44, 62, 80));
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnBorrar.setBounds(1204, 617, 127, 39);
		add(btnBorrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(52, 152, 219)); 
		btnModificar.setForeground(new Color(44, 62, 80));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnModificar.setBounds(974, 617, 127, 39);
		add(btnModificar);
		
		JSlider sliderPuntuacion = new JSlider();
		sliderPuntuacion.setBackground(new Color(240, 242, 245));
		sliderPuntuacion.setForeground(new Color(44, 62, 80));
		sliderPuntuacion.setMajorTickSpacing(1);
		sliderPuntuacion.setPaintTicks(true);
		sliderPuntuacion.setPaintLabels(true);
		sliderPuntuacion.setMinorTickSpacing(1);
		sliderPuntuacion.setMaximum(10);
		sliderPuntuacion.setBounds(1078, 772, 278, 54);
		add(sliderPuntuacion);
		
		JLabel lblNewLabel_1 = new JLabel("Puntuación");
		lblNewLabel_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(974, 783, 94, 14);
		add(lblNewLabel_1);
		
		cmbGenero = new JComboBox();
		cmbGenero.setBounds(1078, 711, 253, 22);
		add(cmbGenero);
		
		JLabel lblNewLabel_1_2 = new JLabel("Genero");
		lblNewLabel_1_2.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(974, 713, 94, 20);
		add(lblNewLabel_1_2);
		
		
		
		cargarComboGenero(); //carga el combo de géneros con los valores del enum (ACCION, DRAMA, COMEDIA...) para que aparezcan en el desplegable cuando abres el panel
	    cargarSeries();//consulta la base de datos y carga todas las series que tienes insertadas en la tabla tablaSeries para que las veas nada más abrir el panel.

	}
	
	public void cargarComboGenero() {
	    cmbGenero.removeAllItems();
	    cmbGenero.addItem("Seleccione un género..."); 
	    
	    for (GENERO g : GENERO.values()) {
	        cmbGenero.addItem(g);
	    }
	}
	
	/**
	 * Carga todas las series desde la base de datos y las muestra en la tabla de la interfaz.
	 * 
	 * Este método realiza los siguientes pasos:
	 * 1. Limpia el contenido actual de la tabla.
	 * 2. Consulta la base de datos para obtener todas las series.
	 * 3. Recorre la lista de series obtenidas.
	 * 4. Añade cada serie como una fila en el modelo de la tabla.
	 * 
	 * Notas:
	 * - Se utiliza un objeto de tipo BBDD para acceder a los datos.
	 * - El campo "director" no aplica a series, por eso se deja vacío.
	 * - El orden de los datos debe coincidir con el modelo de columnas de la tabla.
	 */
	public void cargarSeries() {
	    modeloTablaSeries.setRowCount(0); // limpiamos la tabla
	    BBDD bd = new BBDD();
	    ArrayList<Serie> arrSeries = new ArrayList<>();
	    arrSeries = bd.consultarSeries();
	    for (Serie s : arrSeries) {
	        modeloTablaSeries.addRow(new Object[] {
	            s.getTitulo(),
	            s.getGenero(),
	            s.getAnio(),
	            "", // director no existe en serie
	            s.getPuntuacion(),
	            s.getDescripcion(),
	            s.getFechaInicio(),
	            s.getPersonajes(),
	            s.getTemporadas(),
	            s.getNumCapitulos(),
	            s.getActores(),
	            s.getFechaFin()
	        });
	    }
	}
}
