package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import modelo.Multimedia;
import modelo.Pelicula;
import modelo.Serie;
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
	private JSlider sliderPuntuacion;      
	private JTextArea textArea;            
	private JTextField textFieldAutor;
	private JButton btnInsertar;
	private JTextField textFieldTemporadas;
	private JTextField textFieldCapitulos;

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
		lblNewLabelTemporadas.setBounds(10, 299, 94, 20);
		add(lblNewLabelTemporadas);

		JLabel lblNewLabelNºdeCapitulos = new JLabel("Nº De Capitulos:");
		lblNewLabelNºdeCapitulos.setForeground(new Color(44, 62, 80));
		lblNewLabelNºdeCapitulos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelNºdeCapitulos.setBounds(10, 350, 127, 20);
		add(lblNewLabelNºdeCapitulos);

		JLabel lblNewLabelActores = new JLabel("Actores:");
		lblNewLabelActores.setForeground(new Color(44, 62, 80));
		lblNewLabelActores.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelActores.setBounds(10, 401, 94, 20);
		add(lblNewLabelActores);

		textActores = new JTextField();
		textActores.setBounds(114, 404, 296, 20);
		add(textActores);
		textActores.setColumns(10);

		JLabel lblNewLabelPuntuacion = new JLabel("Puntuación:");
		lblNewLabelPuntuacion.setForeground(new Color(44, 62, 80));
		lblNewLabelPuntuacion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPuntuacion.setBounds(10, 564, 94, 20);
		add(lblNewLabelPuntuacion);

		sliderPuntuacion = new JSlider();
		sliderPuntuacion.setPaintTicks(true);
		sliderPuntuacion.setPaintLabels(true);
		sliderPuntuacion.setMinorTickSpacing(1);
		sliderPuntuacion.setMaximum(10);
		sliderPuntuacion.setMajorTickSpacing(1);
		sliderPuntuacion.setForeground(new Color(44, 62, 80));
		sliderPuntuacion.setBackground(new Color(240, 242, 245));
		sliderPuntuacion.setBounds(114, 553, 296, 54);
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
		lblNewLabelFechaInicio.setBounds(10, 449, 127, 20);
		add(lblNewLabelFechaInicio);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(163, 452, 111, 20);
		add(txtFechaInicio);

		JLabel lblNewLabelPersonajes = new JLabel("Personajes:");
		lblNewLabelPersonajes.setForeground(new Color(44, 62, 80));
		lblNewLabelPersonajes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPersonajes.setBounds(10, 641, 94, 20);
		add(lblNewLabelPersonajes);

		txtPersonajes = new JTextField();
		txtPersonajes.setColumns(10);
		txtPersonajes.setBounds(114, 644, 296, 20);
		add(txtPersonajes);

		btnInsertar = new JButton("INSERTAR");
		btnInsertar.setForeground(new Color(44, 62, 80));
		btnInsertar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInsertar.setBackground(new Color(0, 168, 84));
		btnInsertar.setBounds(810, 378, 127, 39);
		add(btnInsertar);

		
		btnInsertar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Serie miSerie = new Serie();
		        BBDD miBd = new BBDD();
		        boolean correcto = false;
		        int anio = 0;

		        try {

		            if (cmbGenero.getSelectedIndex() == 0) {
		                JOptionPane.showMessageDialog(null, "Seleccione un género");
		                return;
		            }

		            anio = Integer.parseInt(textFieldAnio.getText());

		            miSerie.setTitulo(textFieldTitulo.getText());
		            miSerie.setGenero(Multimedia.GENERO.valueOf(cmbGenero.getSelectedItem().toString()));

		            if (anio < 1946 || anio > 2026) {
		                JOptionPane.showMessageDialog(null, "Año de publicación de la serie incorrecto!!");
		                textFieldAnio.setText("");
		                return;
		            } else {
		                miSerie.setAnio(anio);
		            }

		            miSerie.setAutor(textFieldAutor.getText());
		            miSerie.setPuntuacion(sliderPuntuacion.getValue());
		            miSerie.setDescripcion(textArea.getText());

		            String fechaInicioStr = txtFechaInicio.getText();
		            String fechaFinStr = textField.getText();
		            int temporadas = Integer.parseInt(textFieldTemporadas.getText());
		            int capitulos = Integer.parseInt(textFieldCapitulos.getText());

		            if (fechaFinStr.compareTo(fechaInicioStr) < 0) {
		                JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio");
		                textField.setText("");
		                return;
		            }

		            miSerie.setFechaInicio(fechaInicioStr);
		            miSerie.setFechaFin(fechaFinStr);
		            miSerie.setPersonajes(txtPersonajes.getText());
		            miSerie.setActores(textActores.getText());
		            miSerie.setTemporadas(temporadas);
		            miSerie.setNumCapitulos(capitulos);

		            int valor = JOptionPane.showConfirmDialog(null, "¿Desea guardar la serie?");
		            if (valor == JOptionPane.OK_OPTION) {
		                correcto = miBd.insertaDatosSerie(miSerie);
		                if (correcto) {
		                    JOptionPane.showMessageDialog(null, "Serie guardada correctamente");
		                    limpiarCampos();
		                } else {
		                    JOptionPane.showMessageDialog(null, "No se ha guardado la serie");
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Operación cancelada");
		            }

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "El año debe ser un número válido");
		        }
		    }
		});

		JLabel lblNewLabelFechaFin = new JLabel("Fecha De Fin: ");
		lblNewLabelFechaFin.setForeground(new Color(44, 62, 80));
		lblNewLabelFechaFin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelFechaFin.setBounds(10, 501, 127, 20);
		add(lblNewLabelFechaFin);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 504, 111, 20);
		add(textField);

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
		lblNewLabelGenero.setBounds(10, 189, 94, 20);
		add(lblNewLabelGenero);

		cmbGenero = new JComboBox();
		cmbGenero.setBounds(130, 196, 296, 22);
		add(cmbGenero);

		JLabel lblNewLabelAnio = new JLabel("Año:");
		lblNewLabelAnio.setForeground(new Color(44, 62, 80));
		lblNewLabelAnio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelAnio.setBounds(10, 246, 94, 20);
		add(lblNewLabelAnio);

		textFieldAnio = new JTextField();
		textFieldAnio.setColumns(10);
		textFieldAnio.setBounds(114, 249, 86, 20);
		add(textFieldAnio);
		
		
		JLabel lblFormatoInicio = new JLabel("(YYYY-MM-DD)");
		lblFormatoInicio.setForeground(new Color(150, 150, 150));
		lblFormatoInicio.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		lblFormatoInicio.setBounds(285, 452, 100, 20);
		add(lblFormatoInicio);

		
		JLabel lblFormatoFin = new JLabel("(YYYY-MM-DD)");
		lblFormatoFin.setForeground(new Color(150, 150, 150)); 
		lblFormatoFin.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		lblFormatoFin.setBounds(285, 504, 100, 20);
		add(lblFormatoFin);
		
		JLabel lblNewLabelAutor = new JLabel("Autor");
		lblNewLabelAutor.setForeground(new Color(44, 62, 80));
		lblNewLabelAutor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelAutor.setBounds(10, 145, 94, 20);
		add(lblNewLabelAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(114, 148, 296, 20);
		add(textFieldAutor);
		
		textFieldTemporadas = new JTextField();
		textFieldTemporadas.setColumns(10);
		textFieldTemporadas.setBounds(114, 302, 86, 20);
		add(textFieldTemporadas);
		
		textFieldCapitulos = new JTextField();
		textFieldCapitulos.setColumns(10);
		textFieldCapitulos.setBounds(150, 353, 86, 20);
		add(textFieldCapitulos);

		
		cargarComboGenero();
	}

	public void cargarComboGenero() {
		cmbGenero.removeAllItems();
		cmbGenero.addItem("Seleccione un género...");
		for (GENERO g : GENERO.values()) {
			cmbGenero.addItem(g);
		}
	}

	
	public void limpiarCampos() {
		textFieldTemporadas.setText("");
		textFieldCapitulos.setText("");
	    textFieldTitulo.setText("");
	    textFieldAutor.setText("");
	    textFieldAnio.setText("");
	    textActores.setText("");
	    txtFechaInicio.setText("");
	    textField.setText("");
	    txtPersonajes.setText("");
	    textArea.setText("");
	    sliderPuntuacion.setValue(0);
	    cmbGenero.setSelectedIndex(0);
	    
	}
}