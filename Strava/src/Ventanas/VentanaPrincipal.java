package Ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




public class VentanaPrincipal extends JFrame {
	//DECLARACION DE LOS ATRIBUTOS
	
	private JPanel contentPane;
	private JPanel panelCentral, panelArriba, panelNorte, panelArribaDrc, panelArribaIzq, panelNorteIzq, panelNorteMedio, panelNorteDrc;
	private JPanel panelP1, panelP2, panelArribaIzq1, panelArribaIzq12, panelArribaIzq2;
	private JButton btnSalir, btnRegistrarme;
	private JButton btnReto, btnEntrenamiento;
	public static JButton btnCerrarSesion, btnCambiarCon,  btnInicioSesion;
	private JFrame ventanaActual;
	
	private JLabel lblTitulo;
	public static JLabel lblNombre;
	private JLabel lblHora, lblFrase;
	public static JProgressBar pb = new JProgressBar();
	public static SpinnerModel modelosp;
	public static ArrayList<String> listaHistorialBusqueda = new ArrayList<String>();
	
	
	static Logger log = Logger.getLogger("Log de Usuarios");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		
		//BASE DE DATOS
		
		
		
		//CREACION DEL LOGGER
		Handler handler;
		try {
			handler = new FileHandler("Usuarios.log");
			handler.setFormatter(new SimpleFormatter());
			log.addHandler(handler);
		} catch (SecurityException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//PROPIEDADES DE LA VENTANA
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//CREAMOS LOS PANELES
		panelCentral = new JPanel();
		panelCentral.setBackground(new Color(122,217,196));
		panelCentral.setLayout(new GridLayout(0,1,0,0));
		
		panelArriba = new JPanel();
		panelArriba.setBackground(new Color(122,217,196));
		panelArriba.setLayout(new GridLayout(2,0,0,0));
		panelCentral.add(panelArriba);
		
		panelArribaIzq = new JPanel();
		panelArribaIzq.setLayout(new GridLayout(2, 1));
		panelArriba.add(panelArribaIzq);
		panelArribaIzq.setBackground(new Color(122,217,196));
		
		panelArribaIzq1 = new JPanel();
		panelArribaIzq.add(panelArribaIzq1);
		panelArribaIzq1.setLayout(new GridLayout(0,3,0,0));
		panelArribaIzq1.setBackground(new Color(122,217,196));
		
		panelArribaIzq12 = new JPanel();
		panelArribaIzq1.add(panelArribaIzq12);
		panelArribaIzq12.setBackground(new Color(122,217,196));
		
		panelArribaIzq2 = new JPanel();
		panelArribaIzq.add(panelArribaIzq2);
		panelArribaIzq2.setBackground(new Color(122,217,196));
		
	   
		panelArribaDrc = new JPanel();
		panelArriba.add(panelArribaDrc);
		panelArribaDrc.setLayout(new GridLayout(2, 3));
		panelArribaDrc.setBackground(new Color(122,217,196));
		
		panelNorte = new JPanel();
		panelNorte.setBackground(Color.WHITE);
		panelNorte.setLayout(new GridLayout(0,3,0,0));
		
		panelNorteIzq = new JPanel();
		panelNorteIzq.setBackground(new Color(122,217,196));
		panelNorte.add(panelNorteIzq);
		
		
		
		panelNorteMedio = new JPanel();
		panelNorteMedio.setBackground(new Color(122,217,196));
		panelNorte.add(panelNorteMedio);
		
		panelNorteDrc = new JPanel();
		panelNorteDrc.setBackground(new Color(122,217,196));
		panelNorte.add(panelNorteDrc);
	
		panelP1 = new JPanel();
		panelArribaDrc.add(panelP1);
		panelP1.setBackground(new Color(122,217,196));
		
		panelP2 = new JPanel();
		panelArribaDrc.add(panelP2);
		panelP2.setBackground(new Color(122,217,196));
		
		
		
		btnReto = new JButton();
		btnReto.setText("RETO");
		ponerFotoABoton(btnReto, "imagenes\\Zapatilla.gif", 120, 120, 120, 120);	
		panelP1.add(btnReto);
		
		btnEntrenamiento = new JButton();
		btnEntrenamiento.setText("ENTRENAMIENTO");
		ponerFotoABoton(btnEntrenamiento, "imagenes\\Calcetin.gif", 120, 120, 120, 120);
		panelP2.add(btnEntrenamiento);
		
		
		
		
		
		//INSERTAMOS LOS PANELES AL PANEL PRINCIPAL DE LA VENTANA
		contentPane.add(panelCentral, BorderLayout.CENTER);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		//CREAMOS LOS COMPONENTES
		btnInicioSesion = new JButton();
		btnInicioSesion.setText("Inicio Sesion");
		ponerFotoABoton(btnInicioSesion, "imagenes\\IconoIniciarSesion.png", 30, 30, 30, 30);
		
		btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ponerFotoABoton(btnSalir, "imagenes\\IconoSalir.png", 30, 30, 30, 30);
		
		btnRegistrarme = new JButton();
		btnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ponerFotoABoton(btnRegistrarme, "imagenes\\IconoRegistro.png", 30, 30, 30, 30);
		
		btnCerrarSesion = new JButton();
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ponerFotoABoton(btnCerrarSesion, "imagenes\\IconoCerrarSesion.png", 30, 30, 30, 30);
		
		
		lblNombre = new JLabel("");
		ImageIcon im = new ImageIcon("imagenes\\Titulo.gif");
        ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(200,50,Image.SCALE_DEFAULT));
        im.setDescription("Titulo.gif");


        lblTitulo = new JLabel("");


        lblTitulo.setIcon(imagenConDimensiones);

        lblTitulo.setForeground(Color.BLACK);

        lblFrase = new JLabel("");

        ImageIcon im1 = new ImageIcon("imagenes\\Eslogan.gif");
        ImageIcon imagenConDimensiones1 = new ImageIcon(im1.getImage().getScaledInstance(400,75,Image.SCALE_DEFAULT));
        im.setDescription("Eslogan.gif");
        lblFrase.setIcon(imagenConDimensiones1);
		
		FlowLayout flowLayout = (FlowLayout) panelNorteIzq.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		FlowLayout flowLayout2 = (FlowLayout) panelNorteDrc.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		
		if (lblNombre.getText() == "") {
			btnCerrarSesion.setVisible(false);
		}
		
		panelNorteMedio.add(lblTitulo);
		
		lblHora = new JLabel("");
		
		btnCambiarCon = new JButton();
		btnCambiarCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ponerFotoABoton(btnCambiarCon, "imagenes\\IconoCambiarContrase�a.png", 30, 30, 30, 30);
		btnCambiarCon.setVisible(false);
		
		modelosp = new SpinnerNumberModel(50, 0, 100, 1);
		panelArribaIzq12.add(btnInicioSesion);
		panelArribaIzq12.add(btnSalir);
		panelArribaIzq12.add(btnCerrarSesion);
		panelArribaIzq12.add(btnCambiarCon);
		

		panelNorteDrc.add(lblHora);
		panelArribaIzq12.add(btnRegistrarme);
		panelNorteIzq.add(lblNombre);
		
		panelArribaIzq2.add(lblFrase);
		
		setLocationRelativeTo( null );
	}
		
		 
		//EVENTOS
		
		
		
		
		
		
		
		
		
		
		
		//--------------------------------------------------------------------------------------------------------------
		
		//HILOS
		
		/*
		 * ESTE HILO NOS MUESTRA LA HORA ACTUAL EL CUAL SE ACTUALIZA CADA SEGUNDO PARA QUE SEA POSIBLE ACTUALIZARSE.
		 */
		
		
	
		
		//----------------------------------------------------------------------------------------------------------------
		
		

	
	/**
	 * Metodo que carga de un fichero de texto los el mapaUsuarios.
	 */
	
	
	
	
	/**
	 * METODO QUE GUARDA EL mapaUsuarios EN UN FICHERO DE TEXTO
	 */
	
		
		
	
		
	/**
	 * METODO QUE PONE UN COLOR DETERMINADO A UN BOTON CON LAS MEDIDAS PERSONALIZADAS
	 * @param btn --> EL BOTON AL QUE SE LE VA A PONER UNA IM�GEN
	 * @param rutaFoto --> RUTA DE LA IMAGEN PARA PODER ACCEDER A ELLA
	 * @param x --> VALOR DE LA COORDENADA X DE LA IMAGEN
	 * @param y --> VALOR DE LA COORDENADA Y DE LA IMAGEN
	 * @param width --> ANCHURA DE LA IMAGEN
	 * @param height --> ALTURA DE LA IMAGEN
	 */
	public static void ponerFotoABoton (JButton btn, String rutaFoto, int x, int y, int width, int height) {
		btn.setBounds(x, y, width, height);
		int ancho = btn.getWidth();
		int alto = btn.getHeight();
		ImageIcon icon = new ImageIcon(rutaFoto);
		Icon i = new ImageIcon(icon.getImage().getScaledInstance(alto, ancho, Image.SCALE_DEFAULT));
		btn.setIcon(i);
		btn.setBackground(new Color(33,138,193));
	}
	
	/**
	 * METODO QUE PONE UN COLOR SELECCIONADO A UN BOTON CON LAS MEDIDAS PERSONALIZADAS
	 * @param btn --> EL BOTON AL QUE SE LE VA A PONER UNA IM�GEN
	 * @param rutaFoto --> RUTA DE LA IMAGEN PARA PODER ACCEDER A ELLA
	 * @param x --> VALOR DE LA COORDENADA X DE LA IMAGEN
	 * @param y --> VALOR DE LA COORDENADA Y DE LA IMAGEN
	 * @param width --> ANCHURA DE LA IMAGEN
	 * @param height --> ALTURA DE LA IMAGEN
	 * @param color --> EL COLOR SELECCIONADO
	 */
	public static void ponerFotoABotonDelColorQueQuieras (JButton btn, String rutaFoto, int x, int y, int width, int height, Color color) {
		btn.setBounds(x, y, width, height);
		int ancho = btn.getWidth();
		int alto = btn.getHeight();
		ImageIcon icon = new ImageIcon(rutaFoto);
		Icon i = new ImageIcon(icon.getImage().getScaledInstance(alto, ancho, Image.SCALE_DEFAULT));
		btn.setIcon(i);
		btn.setBackground(color);
	}
	
	
    
	
}





