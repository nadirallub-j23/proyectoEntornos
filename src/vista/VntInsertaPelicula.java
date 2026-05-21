package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import controlador.BBDD;
import modelo.Multimedia;
import modelo.Multimedia.GENERO;
import modelo.Pelicula;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblNewLabeltTitulo = new JLabel("Título:");
		lblNewLabeltTitulo.setForeground(new Color(44, 62, 80));
		lblNewLabeltTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabeltTitulo.setBounds(26, 87, 94, 20);
		add(lblNewLabeltTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(130, 90, 296, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabelGenero = new JLabel("Género:");
		lblNewLabelGenero.setForeground(new Color(44, 62, 80));
		lblNewLabelGenero.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelGenero.setBounds(26, 138, 94, 20);
		add(lblNewLabelGenero);
		
		cmbGenero = new JComboBox();
		cmbGenero.setBounds(130, 140, 296, 22);
		add(cmbGenero);
		
		JLabel lblNewLabelAnio = new JLabel("Año:");
		lblNewLabelAnio.setForeground(new Color(44, 62, 80));
		lblNewLabelAnio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelAnio.setBounds(26, 189, 94, 20);
		add(lblNewLabelAnio);
		
		JLabel lblFormatoInicio = new JLabel("(YYYY-MM-DD)");
		lblFormatoInicio.setForeground(new Color(150, 150, 150));
		lblFormatoInicio.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		lblFormatoInicio.setBounds(251, 378, 100, 20);
		add(lblFormatoInicio);
		
		textAnio = new JTextField();
		textAnio.setBounds(130, 192, 86, 20);
		add(textAnio);
		textAnio.setColumns(10);
		
		JLabel lblNewLabelDirector = new JLabel("Director:");
		lblNewLabelDirector.setForeground(new Color(44, 62, 80));
		lblNewLabelDirector.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelDirector.setBounds(26, 242, 94, 20);
		add(lblNewLabelDirector);
		
		textDirector = new JTextField();
		textDirector.setColumns(10);
		textDirector.setBounds(130, 245, 296, 20);
		add(textDirector);
		
		JLabel lblNewLabelPuntuacion = new JLabel("Puntuación:");
		lblNewLabelPuntuacion.setForeground(new Color(44, 62, 80));
		lblNewLabelPuntuacion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPuntuacion.setBounds(26, 304, 94, 20);
		add(lblNewLabelPuntuacion);
		
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
		
		JLabel lblNewLabelDescripcion = new JLabel("Descripción: ");
		lblNewLabelDescripcion.setForeground(new Color(44, 62, 80));
		lblNewLabelDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelDescripcion.setBounds(525, 87, 94, 20);
		add(lblNewLabelDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(629, 92, 547, 170);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabelFecha = new JLabel("Fecha: ");
		lblNewLabelFecha.setForeground(new Color(44, 62, 80));
		lblNewLabelFecha.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelFecha.setBounds(26, 376, 94, 20);
		add(lblNewLabelFecha);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(130, 379, 111, 20);
		add(txtFecha);
		
		JLabel lblNewLabelPersonajes = new JLabel("Personajes:");
		lblNewLabelPersonajes.setForeground(new Color(44, 62, 80));
		lblNewLabelPersonajes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelPersonajes.setBounds(26, 431, 94, 20);
		add(lblNewLabelPersonajes);
		
		txtPersonajes = new JTextField();
		txtPersonajes.setColumns(10);
		txtPersonajes.setBounds(130, 434, 296, 20);
		add(txtPersonajes);
		
		JLabel lblNewLabelDuracion = new JLabel("Duración:");
		lblNewLabelDuracion.setForeground(new Color(44, 62, 80));
		lblNewLabelDuracion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelDuracion.setBounds(26, 494, 94, 20);
		add(lblNewLabelDuracion);
		
		JSpinner spinnerDuracion = new JSpinner();
		spinnerDuracion.setBounds(130, 497, 49, 20);
		add(spinnerDuracion);
		
		JLabel lblNewLabelActores = new JLabel("Actores:");
		lblNewLabelActores.setForeground(new Color(44, 62, 80));
		lblNewLabelActores.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabelActores.setBounds(26, 562, 94, 20);
		add(lblNewLabelActores);
		
		txtActores = new JTextField();
		txtActores.setColumns(10);
		txtActores.setBounds(130, 565, 296, 20);
		add(txtActores);
		
		JButton btnModificar = new JButton("INSERTAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula miPeli = new Pelicula();
				BBDD miBd = new BBDD();
				boolean correcto = false;
				int anio;
				anio=Integer.parseInt(textAnio.getText());
				
				
				miPeli.setTitulo(txtTitulo.getText());
				miPeli.setGenero(Multimedia.GENERO.valueOf(cmbGenero.getSelectedItem().toString()));
				if(anio<1888||anio>2026) {
					JOptionPane.showMessageDialog(null, "Año de publicación de la películaa incorrecto!!");
					textAnio.setText("");
				}else {
					miPeli.setAnio(anio);
				}
				miPeli.setAutor(textDirector.getText());
				miPeli.setPuntuacion(sliderPuntuacion.getValue());
				miPeli.setDescripcion(textArea.getText());
				miPeli.setFechaInicio(txtFecha.getText());
				miPeli.setDuracion((int) spinnerDuracion.getValue());
				miPeli.setPersonajes(txtPersonajes.getText());
	            miPeli.setActores(txtActores.getText());
	            
	            int valor = JOptionPane.showConfirmDialog(null, "¿Desea guardar a la película?");
				if (valor==JOptionPane.OK_OPTION) {
					correcto=miBd.insertaDatosPeli(miPeli);
					if(correcto) {
						JOptionPane.showMessageDialog(null, "Película guardada correctamente");
						limpiarCampos();						
					}else {
						JOptionPane.showMessageDialog(null, "No se ha guardado a la película");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Se ha producido un error");
				}
				
				
			}
		});
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
	
	public void limpiarCampos() {
		txtTitulo.setText("");
		textAnio.setText("");
		textDirector.setText("");
		txtFecha.setText("");
		txtPersonajes.setText("");
		txtActores.setText("");
		cmbGenero.setSelectedIndex(0);
	}
}
