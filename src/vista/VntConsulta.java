package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Multimedia.GENERO;


public class VntConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tablaPeliculas;
	private JTable tablaLibros;
	private JTable tablaSeries;
	DefaultTableModel modeloTablaSeries = new DefaultTableModel();
	DefaultTableModel modeloTablaPeliculas = new DefaultTableModel();
	DefaultTableModel modeloTablaLibros = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public VntConsulta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MIS PELICULAS");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 42, 166, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("MIS LIBROS");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(603, 39, 166, 39);
		add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 85, 364, 166);
		add(scrollPane);
		
		tablaPeliculas = new JTable();
		scrollPane.setViewportView(tablaPeliculas);
		
		modeloTablaPeliculas.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Duracion", "Actores"});
				
		tablaPeliculas.setModel(modeloTablaPeliculas);
				
			
		modeloTablaPeliculas.setRowCount(0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(502, 85, 364, 166);
		add(scrollPane_1);
		
		tablaLibros = new JTable();
		scrollPane_1.setViewportView(tablaLibros);
		
		modeloTablaLibros.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Autor","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Nº paginas", "Fecha de fin"});
				
		tablaLibros.setModel(modeloTablaLibros);
				
			
		modeloTablaLibros.setRowCount(0);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(177, 306, 509, 166);
		add(scrollPane_2);
		
		tablaSeries = new JTable();
		scrollPane_2.setViewportView(tablaSeries);
		

		modeloTablaSeries.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Temporadas", "Nº capitulos", "Actores","Fecha de fin"});
				
		tablaSeries.setModel(modeloTablaSeries);
				
			
		modeloTablaSeries.setRowCount(0);
		
		JLabel lblMisLibros = new JLabel("MIS SERIES");
		lblMisLibros.setBounds(366, 261, 127, 48);
		add(lblMisLibros);
		lblMisLibros.setFont(new Font("Sylfaen", Font.BOLD, 20));

	}
}
