package Ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JComboBox;


public class ventanaRegis extends JFrame{
	public ventanaRegis() {
		
		setBounds(425, 150, 800, 408);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnRegGoogle = new JButton("Reg.Google");
		panel_4.add(btnRegGoogle);
		
		JButton btnRegFacebook = new JButton("Reg.Facebook");
		panel_4.add(btnRegFacebook);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JTextArea txtrRegistro = new JTextArea();
		txtrRegistro.setText("REGISTRO");
		panel_1.add(txtrRegistro);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		panel_2.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		setVisible(true);

		
	}
	

}
