package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class ventanaReto extends JFrame{
	public ventanaReto() {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Lista de Retos");
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Unirse Reto");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Reto");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retos Activos");
		panel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
		JButton btnNewButton_3_1 = new JButton("Salir");
		panel_2.add(btnNewButton_3_1);

	}
}