package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Multimedia.GENERO;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


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
		lblNewLabel.setBounds(297, 103, 166, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("MIS LIBROS");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(348, 539, 116, 39);
		add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 147, 695, 341);
		add(scrollPane);
		
		tablaPeliculas = new JTable();
		scrollPane.setViewportView(tablaPeliculas);
		
		modeloTablaPeliculas.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Duracion", "Actores"});
				
		tablaPeliculas.setModel(modeloTablaPeliculas);
				
			
		modeloTablaPeliculas.setRowCount(0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 594, 695, 341);
		add(scrollPane_1);
		
		tablaLibros = new JTable();
		scrollPane_1.setViewportView(tablaLibros);
		
		modeloTablaLibros.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Autor","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Nº paginas", "Fecha de fin"});
				
		tablaLibros.setModel(modeloTablaLibros);
				
			
		modeloTablaLibros.setRowCount(0);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(886, 147, 695, 341);
		add(scrollPane_2);
		
		tablaSeries = new JTable();
		scrollPane_2.setViewportView(tablaSeries);
		

		modeloTablaSeries.setColumnIdentifiers(new Object[] {"Titulo", "Genero", "Año", "Director","Puntuacion","Descripcion",
				"Fecha de Inicio", "Personajes", "Temporadas", "Nº capitulos", "Actores","Fecha de fin"});
				
		tablaSeries.setModel(modeloTablaSeries);
				
			
		modeloTablaSeries.setRowCount(0);
		
		JLabel lblMisLibros = new JLabel("MIS SERIES");
		lblMisLibros.setBounds(1204, 95, 127, 48);
		add(lblMisLibros);
		lblMisLibros.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(1204, 617, 127, 39);
		add(btnBorrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(974, 617, 127, 39);
		add(btnModificar);
		
		JSlider sliderPuntuacion = new JSlider();
		sliderPuntuacion.setMajorTickSpacing(1);
		sliderPuntuacion.setPaintTicks(true);
		sliderPuntuacion.setPaintLabels(true);
		sliderPuntuacion.setMinorTickSpacing(1);
		sliderPuntuacion.setMaximum(10);
		sliderPuntuacion.setBounds(1078, 772, 278, 54);
		add(sliderPuntuacion);
		
		JLabel lblNewLabel_1 = new JLabel("Puntuación");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(974, 783, 94, 14);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1078, 711, 253, 22);
		add(comboBox);
		
		JLabel lblNewLabel_1_2 = new JLabel("Genero");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(974, 713, 94, 14);
		add(lblNewLabel_1_2);

	}
}
