package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.BBDD;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JButton;

public class VntPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
    
	public static void main(String[] args) {
		BBDD bd = new BBDD();
	    if (!bd.verificarConexion()) {
	        JOptionPane.showMessageDialog(
	            null,
	            "No se ha podido conectar a la base de datos.\n" +
	            "Por favor, abre XAMPP e inicia el MySQL\n" +
	            "antes de ejecutar la aplicación.",
	            "ERROR DE CONEXION!!",
	            JOptionPane.ERROR_MESSAGE
	        );
	        System.exit(0); 
	    }
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VntPrincipal frame = new VntPrincipal();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VntPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		
		JMenu mnNewMenu = new JMenu("INSERTAR");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPelicula = new JMenuItem("Pelicula");
		mntmPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VntInsertaPelicula insertaPeli = new VntInsertaPelicula();
				insertaPeli.cargarComboGenero();
				cambiaPanel(insertaPeli);
			}
		});
		mnNewMenu.add(mntmPelicula);
		
		JMenuItem mntmSerie = new JMenuItem("Serie");
		mntmSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamar con cambiapanel al inserta
				VntInsertaSerie serie = new VntInsertaSerie();
				cambiaPanel(serie);
			}
		});
		mnNewMenu.add(mntmSerie);
		
		JMenuItem mntmLibro = new JMenuItem("Libro");
		mntmLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamar con cambiapanel al inserta
			}
		});
		mnNewMenu.add(mntmLibro);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JMenu mnConsultar = new JMenu("CONSULTAR");
		menuBar.add(mnConsultar);

		
		JMenuItem mntmVerTablas = new JMenuItem("Ver Todo");
		mntmVerTablas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        VntConsulta consulta = new VntConsulta();
		        consulta.cargarComboGenero(); 
		        cambiaPanel(consulta);
		    }
		});
		
		mnConsultar.add(mntmVerTablas);
		VntConsulta consulta = new VntConsulta();
		cambiaPanel(consulta);
		consulta.cargarComboGenero();
	}
	
	public void cambiaPanel(JPanel nuevoPanel) {
		contentPane.removeAll();
		contentPane.add(nuevoPanel);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
