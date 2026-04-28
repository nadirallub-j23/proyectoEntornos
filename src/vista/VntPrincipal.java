package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VntPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				//llamar con cambiapanel al inserta
			}
		});
		mnNewMenu.add(mntmPelicula);
		
		JMenuItem mntmSerie = new JMenuItem("Serie");
		mntmSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamar con cambiapanel al inserta
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
