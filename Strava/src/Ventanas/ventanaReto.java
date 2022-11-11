package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.FlowLayout;

public class ventanaReto extends JFrame{
	public ventanaReto() {
		setBounds(425, 150, 800, 408);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Lista de Retos");
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnUnirse = new JButton("Unirse Reto");
		panel.add(btnUnirse);
		
		JButton btnCrearReto = new JButton("Crear Reto");
		panel.add(btnCrearReto);
		
		JButton btnRetosActivos = new JButton("Retos Activos");
		panel.add(btnRetosActivos);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
		JButton btnSalir = new JButton("Salir");
		panel_2.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
}