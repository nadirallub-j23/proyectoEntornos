package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.BBDD;
import modelo.Multimedia.GENERO;


public class VntInsertaSerie extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textActores;
	private JTextField txtFechaInicio;
	private JTextField txtPersonajes;
	private JTextField textField;
	private JTextField textFieldTitulo;
	private JTextField textFieldAnio;
	private JComboBox cmbGenero;
	private JComboBox comboBoxTemporadas;  
	private JComboBox comboBoxCapitulos;   
	private JSlider sliderPuntuacion;      
	private JTextArea textArea;            

	public VntInsertaSerie() {

		setLayout(null);

		JLabel lblSerieNueva = new JLabel("SERIE NUEVA");
		lblSerieNueva.setForeground(new Color(44, 62, 80));
		lblSerieNueva.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblSerieNueva.setBounds(10, 21, 199, 33);
		add(lblSerieNueva);

		JLabel lblNewLabelTemporadas = new JLabel("Temporadas:");
		lblNewLabelTemporadas.setForeground(new Color(44, 62, 80));
		lblNewLabelTemporadas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelTemporadas.setBounds(10, 243, 94, 20);
		add(lblNewLabelTemporadas);

		JLabel lblNewLabelNºdeCapitulos = new JLabel("Nº De Capitulos:");
		lblNewLabelNºdeCapitulos.setForeground(new Color(44, 62, 80));
		lblNewLabelNºdeCapitulos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelNºdeCapitulos.setBounds(10, 294, 127, 20);
		add(lblNewLabelNºdeCapitulos);

		JLabel lblNewLabelActores = new JLabel("Actores:");
		lblNewLabelActores.setForeground(new Color(44, 62, 80));
		lblNewLabelActores.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelActores.setBounds(10, 345, 94, 20);
		add(lblNewLabelActores);

		textActores = new JTextField();
		textActores.setBounds(114, 348, 86, 20);
		add(textActores);
		textActores.setColumns(10);

		JLabel lblNewLabelPuntuacion = new JLabel("Puntuación:");
		lblNewLabelPuntuacion.setForeground(new Color(44, 62, 80));
		lblNewLabelPuntuacion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPuntuacion.setBounds(10, 508, 94, 20);
		add(lblNewLabelPuntuacion);

		sliderPuntuacion = new JSlider(); // AÑADIDO - quitado JSlider delante
		sliderPuntuacion.setPaintTicks(true);
		sliderPuntuacion.setPaintLabels(true);
		sliderPuntuacion.setMinorTickSpacing(1);
		sliderPuntuacion.setMaximum(10);
		sliderPuntuacion.setMajorTickSpacing(1);
		sliderPuntuacion.setForeground(new Color(44, 62, 80));
		sliderPuntuacion.setBackground(new Color(240, 242, 245));
		sliderPuntuacion.setBounds(114, 497, 296, 54);
		add(sliderPuntuacion);

		JLabel lblNewLabelDescripcion = new JLabel("Descripción: ");
		lblNewLabelDescripcion.setForeground(new Color(44, 62, 80));
		lblNewLabelDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelDescripcion.setBounds(525, 87, 94, 20);
		add(lblNewLabelDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(629, 92, 547, 170);
		add(scrollPane);

		textArea = new JTextArea(); 
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabelFechaInicio = new JLabel("Fecha De Inicio: ");
		lblNewLabelFechaInicio.setForeground(new Color(44, 62, 80));
		lblNewLabelFechaInicio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelFechaInicio.setBounds(10, 393, 127, 20);
		add(lblNewLabelFechaInicio);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(163, 396, 111, 20);
		add(txtFechaInicio);

		JLabel lblNewLabelPersonajes = new JLabel("Personajes:");
		lblNewLabelPersonajes.setForeground(new Color(44, 62, 80));
		lblNewLabelPersonajes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPersonajes.setBounds(10, 585, 94, 20);
		add(lblNewLabelPersonajes);

		txtPersonajes = new JTextField();
		txtPersonajes.setColumns(10);
		txtPersonajes.setBounds(114, 588, 296, 20);
		add(txtPersonajes);

		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setForeground(new Color(44, 62, 80));
		btnInsertar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInsertar.setBackground(new Color(0, 168, 84));
		btnInsertar.setBounds(810, 378, 127, 39);
		add(btnInsertar);

		
		btnInsertar.addActionListener(e -> {
		    String titulo = textFieldTitulo.getText();
		    String genero = cmbGenero.getSelectedItem().toString();
		    
		    
		    int anio = 0;
		    try {
		        anio = Integer.parseInt(textFieldAnio.getText());
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null,
		            "El campo Año debe ser solo un número, por ejemplo: 2008",
		            "Error",
		            JOptionPane.ERROR_MESSAGE);
		        return;
		    }
		    
		    String actores = textActores.getText();
		    String fechaInicio = txtFechaInicio.getText();
		    String fechaFin = textField.getText();
		    float puntuacion = sliderPuntuacion.getValue();
		    String descripcion = textArea.getText();
		    String personajes = txtPersonajes.getText();
		    int temporadas = (int) comboBoxTemporadas.getSelectedItem();
		    int numCapitulos = (int) comboBoxCapitulos.getSelectedItem();

		    BBDD bd = new BBDD();
		    boolean ok = bd.insertarSerieEnBaseDeDatos(titulo, genero, anio, puntuacion, descripcion,
		                                   fechaInicio, fechaFin, personajes,
		                                   temporadas, numCapitulos, actores);
		    if (ok) {
		        JOptionPane.showMessageDialog(null, "Serie insertada correctamente");
		        limpiarCampos();
		    } else {
		        JOptionPane.showMessageDialog(null, "Error al insertar", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		});

		JLabel lblNewLabelFechaFin = new JLabel("Fecha De Fin: ");
		lblNewLabelFechaFin.setForeground(new Color(44, 62, 80));
		lblNewLabelFechaFin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelFechaFin.setBounds(10, 445, 127, 20);
		add(lblNewLabelFechaFin);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 448, 111, 20);
		add(textField);

		comboBoxTemporadas = new JComboBox(); 
		comboBoxTemporadas.setMaximumRowCount(12);
		comboBoxTemporadas.setBounds(163, 245, 69, 22);
		add(comboBoxTemporadas);

		comboBoxCapitulos = new JComboBox(); 
		comboBoxCapitulos.setMaximumRowCount(12);
		comboBoxCapitulos.setBounds(163, 296, 69, 22);
		add(comboBoxCapitulos);

		JLabel lblNewLabelTitulo = new JLabel("Título:");
		lblNewLabelTitulo.setForeground(new Color(44, 62, 80));
		lblNewLabelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelTitulo.setBounds(10, 84, 94, 20);
		add(lblNewLabelTitulo);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(114, 87, 296, 20);
		add(textFieldTitulo);

		JLabel lblNewLabelGenero = new JLabel("Género:");
		lblNewLabelGenero.setForeground(new Color(44, 62, 80));
		lblNewLabelGenero.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelGenero.setBounds(10, 133, 94, 20);
		add(lblNewLabelGenero);

		cmbGenero = new JComboBox();
		cmbGenero.setBounds(130, 140, 296, 22);
		add(cmbGenero);

		JLabel lblNewLabelAnio = new JLabel("Año:");
		lblNewLabelAnio.setForeground(new Color(44, 62, 80));
		lblNewLabelAnio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelAnio.setBounds(10, 190, 94, 20);
		add(lblNewLabelAnio);

		textFieldAnio = new JTextField();
		textFieldAnio.setColumns(10);
		textFieldAnio.setBounds(114, 193, 86, 20);
		add(textFieldAnio);

		
		cargarComboGenero();
		cargarComboTemporadasYCapitulos();
	}

	public void cargarComboGenero() {
		cmbGenero.removeAllItems();
		cmbGenero.addItem("Seleccione un género...");
		for (GENERO g : GENERO.values()) {
			cmbGenero.addItem(g);
		}
	}

	
	public void cargarComboTemporadasYCapitulos() {
		for (int i = 1; i <= 20; i++) {
			comboBoxTemporadas.addItem(i);
		}
		for (int i = 1; i <= 100; i++) {
			comboBoxCapitulos.addItem(i);
		}
	}
	
	public void limpiarCampos() {
	    textFieldTitulo.setText("");
	    textFieldAnio.setText("");
	    textActores.setText("");
	    txtFechaInicio.setText("");
	    textField.setText("");
	    txtPersonajes.setText("");
	    textArea.setText("");
	    sliderPuntuacion.setValue(0);
	    cmbGenero.setSelectedIndex(0);
	    comboBoxTemporadas.setSelectedIndex(0);
	    comboBoxCapitulos.setSelectedIndex(0);
	}
}