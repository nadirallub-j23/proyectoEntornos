package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import modelo.Multimedia.GENERO;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class VntInsertaPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField textAnio;
	private JTextField textDirector;
	private JTextField txtFecha;
	private JTextField txtPersonajes;
	private JTextField txtActores;
	private JComboBox cmbGenero;

	/**
	 * Create the panel.
	 */
	public VntInsertaPelicula() {
		setLayout(null);
		
		JLabel lblPeliculaNueva = new JLabel("PELICULA NUEVA");
		lblPeliculaNueva.setForeground(new Color(44, 62, 80));
		lblPeliculaNueva.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblPeliculaNueva.setBounds(10, 21, 199, 33);
		add(lblPeliculaNueva);
		
		JLabel lblNewLabel_1_2 = new JLabel("Título:");
		lblNewLabel_1_2.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(26, 87, 94, 20);
		add(lblNewLabel_1_2);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(130, 90, 296, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Género:");
		lblNewLabel_1_2_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(26, 138, 94, 20);
		add(lblNewLabel_1_2_1);
		
		cmbGenero = new JComboBox();
		cmbGenero.setBounds(130, 140, 296, 22);
		add(cmbGenero);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Año:");
		lblNewLabel_1_2_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(26, 189, 94, 20);
		add(lblNewLabel_1_2_1_1);
		
		textAnio = new JTextField();
		textAnio.setBounds(130, 192, 86, 20);
		add(textAnio);
		textAnio.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Director:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1.setBounds(26, 242, 94, 20);
		add(lblNewLabel_1_2_1_1_1);
		
		textDirector = new JTextField();
		textDirector.setColumns(10);
		textDirector.setBounds(130, 245, 296, 20);
		add(textDirector);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Puntuación:");
		lblNewLabel_1_2_1_1_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1.setBounds(26, 304, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1);
		
		JSlider sliderPuntuacion = new JSlider();
		sliderPuntuacion.setPaintTicks(true);
		sliderPuntuacion.setPaintLabels(true);
		sliderPuntuacion.setMinorTickSpacing(1);
		sliderPuntuacion.setMaximum(10);
		sliderPuntuacion.setMajorTickSpacing(1);
		sliderPuntuacion.setForeground(new Color(44, 62, 80));
		sliderPuntuacion.setBackground(new Color(240, 242, 245));
		sliderPuntuacion.setBounds(130, 293, 296, 54);
		add(sliderPuntuacion);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Descripción: ");
		lblNewLabel_1_2_1_1_1_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(525, 87, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(629, 92, 547, 170);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2 = new JLabel("Fecha: ");
		lblNewLabel_1_2_1_1_1_1_2.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1_2.setBounds(26, 376, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1_2);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(130, 379, 111, 20);
		add(txtFecha);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1 = new JLabel("Personajes:");
		lblNewLabel_1_2_1_1_1_1_2_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1_2_1.setBounds(26, 431, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1_2_1);
		
		txtPersonajes = new JTextField();
		txtPersonajes.setColumns(10);
		txtPersonajes.setBounds(130, 434, 296, 20);
		add(txtPersonajes);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1_1 = new JLabel("Duración:");
		lblNewLabel_1_2_1_1_1_1_2_1_1.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1_2_1_1.setBounds(26, 494, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1_2_1_1);
		
		JSpinner spinnerDuracion = new JSpinner();
		spinnerDuracion.setBounds(130, 497, 49, 20);
		add(spinnerDuracion);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1_2 = new JLabel("Actores:");
		lblNewLabel_1_2_1_1_1_1_2_1_2.setForeground(new Color(44, 62, 80));
		lblNewLabel_1_2_1_1_1_1_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1_1_2_1_2.setBounds(26, 562, 94, 20);
		add(lblNewLabel_1_2_1_1_1_1_2_1_2);
		
		txtActores = new JTextField();
		txtActores.setColumns(10);
		txtActores.setBounds(130, 565, 296, 20);
		add(txtActores);
		
		JButton btnModificar = new JButton("INSERTAR");
		btnModificar.setForeground(new Color(44, 62, 80));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnModificar.setBackground(new Color(0, 168, 84));
		btnModificar.setBounds(810, 378, 127, 39);
		add(btnModificar);

	}
	
	public void cargarComboGenero() {
	    cmbGenero.removeAllItems();
	    cmbGenero.addItem("Seleccione un género..."); 
	    
	    for (GENERO g : GENERO.values()) {
	        cmbGenero.addItem(g);
	    }
	}
}
