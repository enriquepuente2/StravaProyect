package Ventanas;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ventanaEntrenamiento extends JFrame{
	public ventanaEntrenamiento() {
		
		setBounds(425, 150, 800, 408);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnNewButton = new JButton("Creacion Sesion");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulta Sesion");
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnSalir = new JButton("SALIR");
		panel_3.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		setVisible(true);
	}
	
}
